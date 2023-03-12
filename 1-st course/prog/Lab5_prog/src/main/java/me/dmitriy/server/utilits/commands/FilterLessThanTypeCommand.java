package me.dmitriy.server.utilits.commands;

import me.dmitriy.client.UserInputManager;
import me.dmitriy.server.data.TicketType;
import me.dmitriy.server.utilits.CollectionManager;
import me.dmitriy.server.utilits.exceptions.CollectionNotRecognizedException;
import me.dmitriy.server.utilits.exceptions.WrongArgumentException;

/**
 * Класс, реализующий команду filter_less_than_type type.
 */

public class FilterLessThanTypeCommand extends AbstractCommand{
    CollectionManager collectionManager;
    TicketType ticketType;

    /**
     * Конструктор команды.
     * @param collectionManager collectionManager
     */

    public FilterLessThanTypeCommand(CollectionManager collectionManager){
        super("filter_less_than_type type", "вывести элементы, значение поля type которых меньше заданного");
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
            if(!UserInputManager.isTicketTypeValid(argument)) valid = false;
            ticketType = TicketType.valueOf(argument);
        }catch(WrongArgumentException exception){
            System.out.println("This command does contain an argument!");
            valid = false;
        }catch(CollectionNotRecognizedException exception){
            System.out.println("We cannot access the collection object. The collection is empty!");
            valid = false;
        }catch(IllegalArgumentException exception){
            System.out.println("Please enter a non-empty value!");
            valid = false;
        }
        return valid;
    }

    /**
     * Метод, исполняющий команду filter_less_than_type type.
     */

    @Override
    public void execute(){
        this.collectionManager.filterLessThanType(ticketType);
    }
}
