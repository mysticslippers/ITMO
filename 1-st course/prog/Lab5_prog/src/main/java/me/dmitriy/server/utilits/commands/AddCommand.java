package me.dmitriy.server.utilits.commands;

import me.dmitriy.client.UserInputManager;
import me.dmitriy.server.utilits.CollectionManager;
import me.dmitriy.server.utilits.exceptions.WrongArgumentException;

/**
 * Класс, реализующий команду add {element}.
 */

public class AddCommand extends AbstractCommand{
    CollectionManager collectionManager;

    /**
     * Конструктор команды.
     * @param collectionManager collectionManager
     */

    public AddCommand(CollectionManager collectionManager){
        super("add {element}", "добавить новый элемент в коллекцию");
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
     * Метод, исполняющий команду add {element}.
     */

    @Override
    public void execute(){
        collectionManager.addToCollection(UserInputManager.getTicketFromConsole(collectionManager.idCounter()));
    }
}
