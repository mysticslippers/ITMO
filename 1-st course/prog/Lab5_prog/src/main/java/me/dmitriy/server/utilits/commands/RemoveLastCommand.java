package me.dmitriy.server.utilits.commands;

import me.dmitriy.server.utilits.CollectionManager;
import me.dmitriy.server.utilits.exceptions.CollectionNotRecognizedException;
import me.dmitriy.server.utilits.exceptions.WrongArgumentException;

/**
 * Класс, реализующий команду remove_last.
 */

public class RemoveLastCommand extends AbstractCommand{
    CollectionManager collectionManager;

    /**
     * Конструктор команды.
     * @param collectionManager collectionManager
     */

    public RemoveLastCommand(CollectionManager collectionManager){
        super("remove_last", "удалить последний элемент из коллекции");
        this.collectionManager = collectionManager;
    }

    /**
     * Метод, проверяющий валидность аргумента.
     * @param argument argument
     * @return Возвращает true, если аргумент валиден.
     */

    @Override
    public boolean hasValidArgument(String argument){
        boolean valid = true;
        try{
            if(argument != null) throw new WrongArgumentException();
            if(collectionManager.getCollection().size() == 0) throw new CollectionNotRecognizedException();
        }catch(WrongArgumentException exception){
            System.out.println("This command does not contain an argument!");
            valid = false;
        }catch(CollectionNotRecognizedException exception){
            System.out.println("We cannot access the collection object. The collection is empty!");
        }
        return valid;
    }

    /**
     * Метод, исполняющий команду remove_last.
     */

    @Override
    public void execute(){
        collectionManager.removeLast();
        System.out.println("The object has been deleted!");
    }
}
