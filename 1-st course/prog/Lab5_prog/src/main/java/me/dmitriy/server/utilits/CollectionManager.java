package me.dmitriy.server.utilits;

import me.dmitriy.client.UserInputManager;
import me.dmitriy.server.data.Ticket;
import me.dmitriy.server.data.TicketType;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Класс, реализующий работу коллекции(без команд).
 */

public class CollectionManager{
    private ArrayList<Ticket> collection;
    private LocalDateTime timeOfInitialization;
    private LocalDateTime timeOfConservation;

    /**
     * Конструктор, связывающий коллекцию и CollectionManager.
     * @param collection collection
     */

    public CollectionManager(ArrayList<Ticket> collection){
        this.collection = collection;
    }

    /**
     * @return Коллекцию.
     */

    public ArrayList<Ticket> getCollection() {
        return collection;
    }

    /**
     * Метод для инициализации коллекции (загрузки данных из файла в коллекцию).
     */

    public void loadCollectionFromFile(){
        this.collection = FileManager.readFile();
        this.timeOfInitialization = LocalDateTime.now();
    }

    /**
     * Метод для сохранение коллекции (записи данных в файл).
     */

    public void saveCollectionToFile(){
        FileManager.writeFile(this.collection);
        this.timeOfConservation = LocalDateTime.now();
    }

    /**
     * @return Время инициализации коллекции.
     */

    public LocalDateTime getTimeOfInitialization(){
        return this.timeOfInitialization;
    }

    /**
     * @return Время сохранения коллекции.
     */

    public LocalDateTime getTimeOfConservation(){
        return this.timeOfConservation;
    }

    /**
     * @param id id
     * @return Элемент коллекции по id.
     */

    public Ticket getTicketById(Long id){
        for(Ticket ticket : this.collection){
            if(ticket.getId().equals(id)){
                return ticket;
            }
        }
        return null;
    }

    /**
     * Метод для сортировки коллекции по полю price у класса Ticket в порядке убывания.
     * @param collection collection
     */

    public void sortByPrice(ArrayList<? extends Ticket> collection){
        ComparatorManager comparator = new ComparatorManager();
        collection.sort(comparator);
    }

    /**
     * @return Последующий номер(id) объекта коллекции.
     */

    public long idCounter(){
        return this.collection.size() + 1;
    }

    /**
     * Метод для добавления нового элемента в коллекцию.
     * @param ticket ticket
     */

    public void addToCollection(Ticket ticket){
        this.collection.add(ticket);
    }

    /**
     * Метод для удаления первого объекта.
     */

    public void removeFirst(){
        this.collection.remove(0);
    }

    /**
     * Метод для удаления последнего объекта.
     */

    public void removeLast(){
        this.collection.remove(this.collection.size() - 1);
    }

    /**
     * Метод для удаление всех объектов коллекции, значение поля которых меньше заданного.
     * @param priceTicket priceTicket
     */

    public void removeLower(float priceTicket){
        sortByPrice(this.collection);
        this.collection.removeIf(ticket -> (priceTicket > ticket.getPrice()));
    }

    /**
     * Метод для обновления элемента коллекции по id.
     * @param id id
     */

    public void updateById(long id){
        this.collection.set(this.collection.indexOf(getTicketById(id)), UserInputManager.getTicketFromConsole(id));
    }

    /**
     * Метод для удаления одного элемента коллекции значение поля refundable которого эквивалентно заданному.
     * @param refundable refundable
     */

    public void removeAnyByRefundable(boolean refundable){
        for(Ticket ticket : this.collection){
            if(ticket.getRefundable() == refundable){
                this.collection.remove(ticket);
                break;
            }
        }
    }

    /**
     * Метод для вывода всех элементов коллекции, значение поля type которых меньше заданного
     * @param ticketType ticketType
     */

    public void filterLessThanType(TicketType ticketType){
        for(Ticket ticket : this.collection){
            if(!ticket.getType().equals(ticketType)) System.out.println(ticket);
        }
    }
}
