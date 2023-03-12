package me.dmitriy.server.utilits.commands;

import me.dmitriy.server.data.Ticket;
import me.dmitriy.server.utilits.CollectionManager;
import me.dmitriy.server.utilits.exceptions.WrongArgumentException;

/**
 * Класс, реализующий команду info.
 */

public class InfoCommand extends AbstractCommand{
    CollectionManager collectionManager;

    /**
     * Конструктор команды.
     * @param collectionManager collectionManager
     */

    public InfoCommand(CollectionManager collectionManager){
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
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
     * Метод, исполняющий команду info.
     */

    @Override
    public void execute(){
        System.out.println("Collection type: " + Ticket.class);
        System.out.println("Time of initialization: " + collectionManager.getTimeOfInitialization());
        System.out.println("Size of collection: " + (collectionManager.getCollection().size()));
        System.out.println("Time of conservation: " + collectionManager.getTimeOfConservation());
    }
}
