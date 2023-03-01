package me.dmitriy.server.utilits;

import me.dmitriy.server.data.Ticket;

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
     * @param collection
     */

    public CollectionManager(ArrayList<Ticket> collection){
        this.collection = collection;
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
     * @param id
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
     * Метод для сортировки коллекции по полю price в порядке убывания.
     * @param collection
     */

    public void sortByPrice(ArrayList<? extends Ticket> collection){
        ComparatorManager comparator = new ComparatorManager();
        collection.sort(comparator);
    }


}
