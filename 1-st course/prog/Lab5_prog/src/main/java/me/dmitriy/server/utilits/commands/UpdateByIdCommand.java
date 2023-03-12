package me.dmitriy.server.utilits.commands;

import me.dmitriy.client.UserInputManager;
import me.dmitriy.server.utilits.CollectionManager;
import me.dmitriy.server.utilits.exceptions.CollectionNotRecognizedException;
import me.dmitriy.server.utilits.exceptions.WrongArgumentException;

/**
 * Класс, реализующий команду update id {element}.
 */

public class UpdateByIdCommand extends AbstractCommand{
    CollectionManager collectionManager;
    long ticketId;

    /**
     * Конструктор команды.
     * @param collectionManager collectionManager
     */

    public UpdateByIdCommand(CollectionManager collectionManager){
        super("update id {element}", "обновить значение элемента коллекции, id которого равен заданному");
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
            if(!UserInputManager.isIdValid(argument)) valid = false;
            ticketId = Long.parseLong(argument);
            if(collectionManager.getTicketById(ticketId) == null) throw new NullPointerException();
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
     * Метод, исполняющий команду update id {element}.
     */

    @Override
    public void execute(){
        collectionManager.updateById(ticketId);
    }
}
