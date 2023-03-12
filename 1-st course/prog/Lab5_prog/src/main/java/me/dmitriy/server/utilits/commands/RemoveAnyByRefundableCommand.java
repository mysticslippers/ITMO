package me.dmitriy.server.utilits.commands;

import me.dmitriy.client.UserInputManager;
import me.dmitriy.server.utilits.CollectionManager;
import me.dmitriy.server.utilits.exceptions.CollectionNotRecognizedException;
import me.dmitriy.server.utilits.exceptions.WrongArgumentException;

/**
 * Класс, реализующий команду remove_any_by_refundable refundable.
 */

public class RemoveAnyByRefundableCommand extends AbstractCommand{
    CollectionManager collectionManager;
    boolean refundableTicket;

    /**
     * Конструктор команды.
     * @param collectionManager collectionManager
     */

    public RemoveAnyByRefundableCommand(CollectionManager collectionManager){
        super("remove_any_by_refundable refundable", "удалить из коллекции один элемент, значение поля refundable которого эквивалентно заданному");
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
            if(argument == null) throw new WrongArgumentException();
            if(collectionManager.getCollection().size() == 0) throw new CollectionNotRecognizedException();
            if(!UserInputManager.isRefundableValid(argument)) valid = false;
            refundableTicket = Boolean.parseBoolean(argument);
        }catch(WrongArgumentException exception){
            System.out.println("This command does contain an argument!");
            valid = false;
        }catch(CollectionNotRecognizedException exception){
            System.out.println("We cannot access the collection object. The collection is empty!");
            valid = false;
        }catch(NullPointerException exception){
            System.out.println("Object does not exist!");
            valid = false;
        }catch(IllegalArgumentException exception){
            System.out.println("Please enter a non-empty value!");
            valid = false;
        }
        return valid;
    }

    /**
     * Метод, исполняющий команду remove_any_by_refundable refundable.
     */

    @Override
    public void execute(){
        this.collectionManager.removeAnyByRefundable(refundableTicket);
        System.out.println("The object has been deleted!");
    }
}
