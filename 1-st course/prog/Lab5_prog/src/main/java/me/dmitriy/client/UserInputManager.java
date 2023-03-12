package me.dmitriy.client;

import me.dmitriy.server.data.*;
import me.dmitriy.server.utilits.exceptions.FieldEmptyException;
import me.dmitriy.server.utilits.exceptions.NumberOutOfRangeException;
import me.dmitriy.server.utilits.exceptions.StringLengthOutOfRangeException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс, реализующий пользовательский ввод и нахождение в нём ошибок.
 */

public class UserInputManager{

    /**
     * Валидатор для поля id у класса Ticket.
     * @return Возвращает true, если id - валидное значение.
     */

    public static boolean isIdValid(String id){
        boolean exist = true;
        long longId;
        try{
            if(id.isEmpty()) throw new FieldEmptyException();
            longId = Long.parseLong(id);
            if(longId <= 0) throw new NumberOutOfRangeException();
        }catch(NumberFormatException exception){
            System.out.println("The id field must contain a number!");
            exist = false;
        }catch(NumberOutOfRangeException exception){
            System.out.println("The id field must contain a number greater than zero!");
            exist = false;
        }catch(FieldEmptyException exception){
            System.out.println("The Ticket's id field cannot be empty!");
            exist = false;
        }
        return exist;
    }

    /**
     * Валидатор для поля name у класса Ticket.
     * @return Возврощает true, если имя - валидное значение.
     */

    public static boolean isNameValid(String name){
        boolean exist = true;
        try{
            if(name.isEmpty()) throw new FieldEmptyException();
        }catch(FieldEmptyException exception){
            System.out.println("The name field cannot be empty!");
            exist = false;
        }
        return exist;
    }

    /**
     * Валидатор для поля coordinates у класса Coordinates.
     * @return Возвращает true, если x, y - валидные значения.
     */

    public static boolean isCoordinatesValid(String x, String y){
        boolean exist = true;
        float floatX;
        int intY;
        try{
            if(x.isEmpty() || y.isEmpty()) throw new FieldEmptyException();
            floatX = Float.parseFloat(x);
            intY = Integer.parseInt(y);
            if(floatX <= -390) throw new NumberOutOfRangeException();
        }catch(NumberFormatException exception){
            System.out.println("Numbers entered incorrectly!");
            exist = false;
        }catch(NumberOutOfRangeException exception){
            System.out.println("X coordinate must be greater than -390!");
            exist = false;
        }catch(FieldEmptyException exception){
            System.out.println("The X and Y coordinate fields must not be empty!");
            exist = false;
        }
        return exist;
    }

    /**
     * Валидатор для поля price у класса Ticket.
     * @return Возврщает true, если price - валидное значение.
     */

    public static boolean isPriceValid(String price){
        boolean exist = true;
        float floatPrice;
        try{
            if(price.isEmpty()) throw new FieldEmptyException();
            floatPrice = Float.parseFloat(price);
            if(floatPrice <= 0) throw new NumberOutOfRangeException();
        }catch(NumberFormatException exception){
            System.out.println("Number entered incorrectly!");
            exist = false;
        }catch(NumberOutOfRangeException exception){
            System.out.println("Price must be greater than 0!");
            exist = false;
        }catch(FieldEmptyException exception){
            System.out.println("The price field must not be empty!");
            exist = false;
        }
        return exist;
    }

    /**
     * Валидатор для поля comment у класса Ticket.
     * @return Возврщает true, если comment - валидное значение.
     */

    public static boolean isCommentValid(String comment){
        boolean exist = true;
        try{
            if(comment.length() > 404) throw new StringLengthOutOfRangeException();
            if(comment.isEmpty()) throw new FieldEmptyException();
        }catch(FieldEmptyException exception){
            System.out.println("The price field must not be empty!");
            exist = false;
        }catch(StringLengthOutOfRangeException exception){
            System.out.println("Comment length must not exceed 404 characters!");
            exist = false;
        }
        return exist;
    }

    /**
     * Валидатор для поля refundable у класса Ticket.
     * @return Возврщает true, если refundable - валидное значение.
     */

    public static boolean isRefundableValid(String refundable){
        boolean exist = true;
        try{
            if(refundable == null) throw new FieldEmptyException();
            if(!refundable.equalsIgnoreCase("true") && !refundable.equalsIgnoreCase("false")) throw new IllegalArgumentException();
        }catch(FieldEmptyException exception){
            System.out.println("The refundable field must not be empty!");
            exist = false;
        }catch(IllegalArgumentException exception){
            System.out.println("The field must be either true or false!");
            exist = false;
        }
        return exist;
    }

    /**
     * Валидатор для поля ticketType у класса Ticket.
     * @return Возвращает true, если ticketType - валидное значение.
     */

    public static boolean isTicketTypeValid(String userInputTicketType){
        boolean exist = true;
        try{
            TicketType.valueOf(userInputTicketType);
        }catch(IllegalArgumentException exception){
            System.out.println("The value must be from a list!");
            exist = false;
        }
        return exist;
    }

    /**
     * Валидатор для поля name у класса Venue.
     * @return Возвращает true, если name - валидное значение.
     */

    public  static boolean isVenueNameValid(String name){
        boolean exist = true;
        try{
            if(name.isEmpty()) throw new FieldEmptyException();
        }catch(FieldEmptyException exception){
            System.out.println("The name field cannot be empty!");
            exist = false;
        }
        return exist;
    }

    /**
     * Валидатор для поля id у класса Venue.
     * @return Возвращает true, если id - валидное значение.
     */

    public  static boolean isVenueIdValid(String id){
        boolean exist = true;
        int longId;
        try{
            if(id.isEmpty()) throw new FieldEmptyException();
            longId = Integer.parseInt(id);
            if(longId <= 0) throw new NumberOutOfRangeException();
        }catch(NumberFormatException exception){
            System.out.println("The id field must contain a number!");
            exist = false;
        }catch(NumberOutOfRangeException exception){
            System.out.println("The id field must contain a number greater than zero!");
            exist = false;
        }catch(FieldEmptyException exception){
            System.out.println("The Venue's id field cannot be empty!");
            exist = false;
        }
        return exist;
    }

    /**
     * Валидатор для поля capacity у класса Venue.
     * @return Возвращает true, если capacity - валидное значение.
     */

    public static boolean isVenueCapacityValid(String capacity){
        boolean exist = true;
        long longCapacity;
        try{
            if(capacity.isEmpty()) throw new FieldEmptyException();
            longCapacity = Long.parseLong(capacity);
            if(longCapacity <= 0) throw new NumberOutOfRangeException();
        }catch(NumberFormatException exception){
            System.out.println("The capacity field must contain a number!");
            exist = false;
        }catch(NumberOutOfRangeException exception){
            System.out.println("The capacity field must contain a number greater than zero!");
            exist = false;
        }catch(FieldEmptyException exception){
            System.out.println("The capacity field cannot be empty!");
            exist = false;
        }
        return exist;
    }

    /**
     * Валидатор для поля VenueType.
     * @return Возвращает true, если VenueType - валидное значение.
     */

    public static boolean isVenueTypeValid(String userInputVenueType){
        boolean exist = true;
        try{
            VenueType.valueOf(userInputVenueType);
        }catch(IllegalArgumentException exception){
            System.out.println("The value must be from a list!");
            exist = false;
        }
        return exist;
    }

    /**
     * Валидатор для определения исходного файла.
     * @return Возвращает true, если путь до переменной окружения с именем Collection указан верно.
     */

    public static boolean isFileNotNull(){
        return System.getenv().get("Collection") != null;
    }

    /**
     * Метод для создания объекта из консоли.
     * @return Возвращает только что созданный объект из консоли.
     */

    public static Ticket getTicketFromConsole(long counterId){
        ArrayList<String> ticketInfo = new ArrayList<>();
        String info;
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Let's name the object:");
            do {
                info = scanner.nextLine().trim();
                System.out.println("----------------------");
            } while (!isNameValid(info));
            ticketInfo.add(info);
            System.out.println(info);

            System.out.println("Great! Let's give it the coordinates.");
            System.out.println("Enter values with SPACE between them:");
            String strX = "";
            String strY = "";
            do {
                try{
                    info = scanner.nextLine().trim();
                    if(info.isEmpty()) throw new FieldEmptyException();
                    strX = info.substring(0, info.indexOf(" ")).trim();
                    strY = info.substring(info.indexOf(" ")).trim();
                }catch(FieldEmptyException exception){
                    System.out.println("Please, enter values with SPACE between them!");
                }
                System.out.println("----------------------");
                System.out.println(strX + " " + strY);
            } while (!isCoordinatesValid(strX, strY));
            ticketInfo.add(strX);
            ticketInfo.add(strY);

            System.out.println("Excellent! Let's give it a price:");
            do {
                info = scanner.nextLine().trim();
                System.out.println("----------------------");
                System.out.println(info);
            } while (!isPriceValid(info));
            ticketInfo.add(info);

            System.out.println("Nice! Let's comment on it:");
            do {
                info = scanner.nextLine().trim();
                System.out.println("----------------------");
                System.out.println(info);
            } while (!isCommentValid(info));
            ticketInfo.add(info);

            System.out.println("Cool! Let's give it refundable:");
            do {
                info = scanner.nextLine().trim();
                System.out.println("----------------------");
                System.out.println(info);
            } while (!isRefundableValid(info));
            ticketInfo.add(info);

            System.out.println("Great! Let's give it type:");
            do {
                System.out.println(TicketType.showList());
                info = scanner.nextLine().trim();
                System.out.println("----------------------");
                System.out.println(info);
            } while (!isTicketTypeValid(info));
            ticketInfo.add(info);

            System.out.println("Excellent! Let's give some information about it's Venue.");
            System.out.println("Please give Venue's name:");
            do {
                info = scanner.nextLine().trim();
                System.out.println("----------------------");
                System.out.println(info);
            } while (!isVenueNameValid(info));
            ticketInfo.add(info);

            System.out.println("Please give Venue's capacity:");
            do {
                info = scanner.nextLine();
                System.out.println("----------------------");
                System.out.println(info);
            } while (!isVenueCapacityValid(info));
            ticketInfo.add(info);

            System.out.println("Please give Venue's type:");
            do {
                System.out.println(VenueType.showList());
                info = scanner.nextLine();
                System.out.println("----------------------");
                System.out.println(info);
            } while (!isVenueTypeValid(info));
            ticketInfo.add(info);

            System.out.println("Object created!");
        }catch(NoSuchElementException exception){
            System.out.println("Something went wrong!");
        }
        return new Ticket(counterId, ticketInfo.get(0), new Coordinates(Float.parseFloat(ticketInfo.get(1)), Integer.parseInt(ticketInfo.get(2))),
                LocalDateTime.now(), Float.parseFloat(ticketInfo.get(3)), ticketInfo.get(4), Boolean.parseBoolean(ticketInfo.get(5)),
                TicketType.valueOf(ticketInfo.get(6)),
                new Venue((int) counterId, ticketInfo.get(7), Long.parseLong(ticketInfo.get(8)), VenueType.valueOf(ticketInfo.get(9))));
    }
}
