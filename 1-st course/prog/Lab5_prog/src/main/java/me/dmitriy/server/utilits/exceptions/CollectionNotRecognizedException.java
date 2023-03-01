package me.dmitriy.server.utilits.exceptions;

/**
 * Класс-исключение, будет вызван в случае отсутствия коллекции.
 */

public class CollectionNotRecognizedException extends Exception{

    /**
     * Конструктор исключения.
     * @param message
     */

    public CollectionNotRecognizedException(String message){
        super(message);
    }
}
