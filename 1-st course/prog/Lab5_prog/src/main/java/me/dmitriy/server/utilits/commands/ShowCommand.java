package me.dmitriy.server.utilits.commands;

import me.dmitriy.server.data.Ticket;
import me.dmitriy.server.utilits.CollectionManager;
import me.dmitriy.server.utilits.exceptions.CollectionNotRecognizedException;
import me.dmitriy.server.utilits.exceptions.WrongArgumentException;

/**
 * Класс, реализующий команду show.
 */

public class ShowCommand extends AbstractCommand{
    CollectionManager collectionManager;

    /**
     * Конструктор команды.
     * @param collectionManager collectionManager
     */

    public ShowCommand(CollectionManager collectionManager){
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
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
            valid = false;
        }
        return valid;
    }

    /**
     * Метод, исполняющий команду show.
     */

    @Override
    public void execute(){
        for(Ticket ticket : collectionManager.getCollection()){
            System.out.println(ticket.toString());
        }
    }
}
