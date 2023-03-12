package me.dmitriy.server.utilits.commands;

import me.dmitriy.server.utilits.CollectionManager;
import me.dmitriy.server.utilits.exceptions.WrongArgumentException;

/**
 * Класс, реализующий команду clear.
 */

public class ClearCommand extends AbstractCommand{
    CollectionManager collectionManager;

    /**
     * Конструктор команды.
     * @param collectionManager collectionManager
     */

    public ClearCommand(CollectionManager collectionManager){
        super("clear", "очистить коллекцию");
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
        }catch(WrongArgumentException exception){
            System.out.println("This command does not contain an argument!");
            valid = false;
        }
        return valid;
    }

    /**
     * Метод, исполняющий команду clear.
     */

    @Override
    public void execute(){
        collectionManager.getCollection().clear();
        System.out.println("Collection cleared");
    }
}
