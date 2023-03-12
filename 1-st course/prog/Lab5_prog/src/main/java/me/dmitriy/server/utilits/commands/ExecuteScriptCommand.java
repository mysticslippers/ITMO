package me.dmitriy.server.utilits.commands;

import me.dmitriy.server.utilits.exceptions.WrongArgumentException;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**
 * Класс, реализующий команду execute_script file_name.
 */

public class ExecuteScriptCommand extends AbstractCommand{

    /**
     * Конструктор команды.
     */

    public ExecuteScriptCommand(){
        super("execute_script file_name", "считать и исполнить скрипт из указанного файла. " +
                "В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");
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
            if(!argument.equals(System.getenv("script"))) throw new FileNotFoundException();
        }catch(WrongArgumentException exception){
            System.out.println("This command does contain an argument!");
            valid = false;
        }catch(FileNotFoundException exception){
            System.out.println("File not found!");
            valid = false;
        }catch(NoSuchElementException exception){
            System.out.println("The file is empty!");
            valid = false;
        }
        return valid;
    }

    /**
     * Метод, исполняющий команду execute_script file_name.
     */

    @Override
    public void execute(){
        System.out.println("/");
    }
}
