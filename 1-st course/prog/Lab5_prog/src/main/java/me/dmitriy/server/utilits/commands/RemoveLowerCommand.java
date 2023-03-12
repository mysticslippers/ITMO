package me.dmitriy.server.utilits.commands;

import me.dmitriy.client.UserInputManager;
import me.dmitriy.server.utilits.CollectionManager;
import me.dmitriy.server.utilits.exceptions.CollectionNotRecognizedException;
import me.dmitriy.server.utilits.exceptions.WrongArgumentException;

/**
 * Класс, реализующий команду remove_lower {element}.
 */

public class RemoveLowerCommand extends AbstractCommand{
    CollectionManager collectionManager;
    float priceTicket;

    /**
     * Конструктор команды.
     * @param collectionManager collectionManager
     */

    public RemoveLowerCommand(CollectionManager collectionManager){
        super("remove_lower {element}", "удалить из коллекции все элементы, меньшие, чем заданный");
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
            if(!UserInputManager.isPriceValid(argument)) valid = false;
            priceTicket = Float.parseFloat(argument);
        }catch(WrongArgumentException exception){
            System.out.println("This command does contain an argument!");
            valid = false;
        }catch(CollectionNotRecognizedException exception){
            System.out.println("We cannot access the collection object. The collection is empty!");
            valid = false;
        }
        return valid;
    }

    /**
     * Метод, исполняющий команду remove_lower {element}.
     */

    @Override
    public void execute(){
        collectionManager.removeLower(priceTicket);
    }
}
