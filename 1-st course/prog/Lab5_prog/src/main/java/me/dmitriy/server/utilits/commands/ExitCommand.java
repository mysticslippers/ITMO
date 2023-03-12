package me.dmitriy.server.utilits.commands;

import me.dmitriy.server.utilits.exceptions.WrongArgumentException;

/**
 * Класс, реализующий команду exit.
 */

public class ExitCommand extends AbstractCommand{

    /**
     * Конструктор команды.
     */

    public ExitCommand(){
        super("exit", "завершить программу (без сохранения в файл)");
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
     * Метод, исполняющий команду exit.
     */

    @Override
    public void execute(){
        System.out.println("Completion of the program.....");
        System.exit(0);
    }
}
