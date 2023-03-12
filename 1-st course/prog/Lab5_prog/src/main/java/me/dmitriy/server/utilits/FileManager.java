package me.dmitriy.server.utilits;

import me.dmitriy.client.UserInputManager;
import me.dmitriy.server.data.*;

import javax.xml.stream.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.regex.*;

/**
 * Класс, реализующий связь файла и коллекции.
 */

public class FileManager{

    /**
     * Метод, реализущий чтение данных из файла в коллекцию и их проверку на валидность.
     * @return Возвращает коллекцию из файла.
     */

    public static ArrayList<Ticket> readFile(){
        ArrayList<Ticket> collection = new ArrayList<>();
        ArrayList<String> info = new ArrayList<>();
        String filePath = System.getenv("Collection");
        Pattern patternAttribute = Pattern.compile(">(.*)<");
        String line;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            while((line = bufferedReader.readLine()) != null) {
                line = (line.contains("><")) ? line.replace("><", "<") : line;
                Matcher matcher = patternAttribute.matcher(line);
                if (matcher.find()) {
                    String attribute = matcher.group();
                    info.add(attribute.trim().substring(1, attribute.length() - 1));

                    if (line.contains("/venueType")) {
                        try {
                            if(UserInputManager.isFileNotNull()
                                    && UserInputManager.isIdValid(info.get(0))
                                    && UserInputManager.isNameValid(info.get(1)) &&
                                    UserInputManager.isCoordinatesValid(info.get(2), info.get(3))
                                    && UserInputManager.isPriceValid(info.get(5))
                                    && UserInputManager.isCommentValid(info.get(6))
                                    && UserInputManager.isRefundableValid(info.get(7))
                                    && UserInputManager.isTicketTypeValid(info.get(8))
                                    && UserInputManager.isVenueIdValid(info.get(9))
                                    && UserInputManager.isVenueNameValid(info.get(10))
                                    && UserInputManager.isVenueCapacityValid(info.get(11))
                                    && UserInputManager.isVenueTypeValid(info.get(12))){

                                collection.add(new Ticket(Long.parseLong(info.get(0)), info.get(1), new Coordinates(Float.parseFloat(info.get(2)),
                                        Integer.parseInt(info.get(3))), LocalDateTime.now(), Float.parseFloat(info.get(5)), info.get(6),
                                        Boolean.parseBoolean(info.get(7)), TicketType.valueOf(info.get(8)),
                                        new Venue(Integer.parseInt(info.get(9)), info.get(10), Long.parseLong(info.get(11)), VenueType.valueOf(info.get(12)))));
                                System.out.println("Объект с id " + Long.parseLong(info.get(0)) + " добавлен в коллекцию.");
                                info.clear();
                            } else {
                                System.out.println("Данные об объекте ID: " + info.get(0) + " не валидны!");
                                info.clear();
                            }
                        }catch(IllegalArgumentException exception){
                            System.out.println("Данные об объекте ID: " + info.get(0) + " не валидны!");
                            info.clear();
                        }
                    }
                }
            }
        }catch(FileNotFoundException exception){
            System.out.println("File not found!");
        }catch(NoSuchElementException exception){
            System.out.println("The file is empty!");
        }catch(IOException exception){
            System.out.println("The file cannot be read!");
        }

        return collection;
    }

    /**
     * Метод, реализующий загрузку данных коллекции в файл.
     * @param collection collection
     */

    public static void writeFile(ArrayList<Ticket> collection){
        ArrayList<String> info = new ArrayList<>();
        String filePath = System.getenv("Collection");
        Pattern patternAttribute = Pattern.compile("-\\s[0-9a-zA-Z-.:]*");
        String line;

        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath)){
            XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(fileOutputStream, "UTF-8");
            xmlStreamWriter.writeStartDocument("UTF-8","1.0");
            fileOutputStream.write("\n".getBytes());
            xmlStreamWriter.writeStartElement("Tickets");
            fileOutputStream.write(("\n").getBytes());

            for (Ticket ticket : collection) {
                fileOutputStream.write(("\t").getBytes());
                xmlStreamWriter.writeStartElement(("Ticket"));
                fileOutputStream.write(("\n\t\t").getBytes());

                line = ticket.toString();
                Matcher matcher = patternAttribute.matcher(line);
                while (matcher.find()) {
                    String attribute = matcher.group().trim();
                    info.add(attribute.substring(2));
                }

                xmlStreamWriter.writeStartElement("id");
                xmlStreamWriter.writeCharacters(info.get(0));
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t\t").getBytes());

                xmlStreamWriter.writeStartElement("name");
                xmlStreamWriter.writeCharacters(info.get(1));
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t\t").getBytes());

                xmlStreamWriter.writeStartElement("coordinates");
                fileOutputStream.write(("\n\t\t\t").getBytes());
                xmlStreamWriter.writeStartElement("x");
                xmlStreamWriter.writeCharacters(info.get(2));
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t\t\t").getBytes());
                xmlStreamWriter.writeStartElement("y");
                xmlStreamWriter.writeCharacters(info.get(3));
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t\t").getBytes());
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t\t").getBytes());

                xmlStreamWriter.writeStartElement("zonedDateTime");
                xmlStreamWriter.writeCharacters(info.get(4));
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t\t").getBytes());

                xmlStreamWriter.writeStartElement("price");
                xmlStreamWriter.writeCharacters(info.get(5));
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t\t").getBytes());

                xmlStreamWriter.writeStartElement("comment");
                xmlStreamWriter.writeCharacters(info.get(6));
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t\t").getBytes());

                xmlStreamWriter.writeStartElement("refundable");
                xmlStreamWriter.writeCharacters(info.get(7));
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t\t").getBytes());


                xmlStreamWriter.writeStartElement("ticketType");
                xmlStreamWriter.writeCharacters(info.get(8));
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t\t").getBytes());

                xmlStreamWriter.writeStartElement("venue");
                fileOutputStream.write(("\n\t\t\t").getBytes());
                xmlStreamWriter.writeStartElement("venueId");
                xmlStreamWriter.writeCharacters(info.get(9));
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t\t\t").getBytes());
                xmlStreamWriter.writeStartElement("venueName");
                xmlStreamWriter.writeCharacters(info.get(10));
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t\t\t").getBytes());
                xmlStreamWriter.writeStartElement("capacity");
                xmlStreamWriter.writeCharacters(info.get(11));
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t\t\t").getBytes());
                xmlStreamWriter.writeStartElement("venueType");
                xmlStreamWriter.writeCharacters(info.get(12));
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t\t").getBytes());
                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n\t").getBytes());

                xmlStreamWriter.writeEndElement();
                fileOutputStream.write(("\n").getBytes());
                info.clear();
            }

            xmlStreamWriter.writeEndElement();
            fileOutputStream.write(("\n").getBytes());
            xmlStreamWriter.writeEndDocument();

            xmlStreamWriter.flush();
            fileOutputStream.flush();
        }catch(FileNotFoundException exception){
            System.out.println("File not found!");
        }catch(IOException | XMLStreamException exception){
            System.out.println("Cannot write to file!");
        }
    }
}
