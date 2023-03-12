package me.dmitriy.server.utilits.commands;

import me.dmitriy.server.data.Ticket;
import me.dmitriy.server.utilits.CollectionManager;
import me.dmitriy.server.utilits.exceptions.WrongArgumentException;

/**
 * Класс, реализующий команду print_field_descending_price.
 */

public class PrintFieldDescendingPriceCommand extends AbstractCommand{
    CollectionManager collectionManager;

    /**
     * Конструктор команды.
     * @param collectionManager collectionManager
     */

    public PrintFieldDescendingPriceCommand(CollectionManager collectionManager){
        super("print_field_descending_price", "вывести значения поля price всех элементов в порядке убывания");
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
     * Метод, исполняющий команду print_field_descending_price.
     */

    @Override
    public void execute(){
        collectionManager.sortByPrice(collectionManager.getCollection());
        for(Ticket ticket : collectionManager.getCollection()){
            System.out.println(ticket);
        }
    }
}
