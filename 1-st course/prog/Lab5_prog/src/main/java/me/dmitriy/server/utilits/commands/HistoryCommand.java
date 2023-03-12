package me.dmitriy.server.utilits.commands;

import me.dmitriy.server.utilits.exceptions.WrongArgumentException;

/**
 * Класс, реализующий команду history.
 */

public class HistoryCommand extends AbstractCommand{

    /**
     * Конструктор команды.
     */

    public HistoryCommand(){
        super("history", "выводит список последних 10 используемых команд");
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
     * Метод, исполняющий команду history.
     */

    @Override
    public void execute(){
        System.out.println("/");
    }
}
