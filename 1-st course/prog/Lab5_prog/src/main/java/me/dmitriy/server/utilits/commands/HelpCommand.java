package me.dmitriy.server.utilits.commands;


import me.dmitriy.server.utilits.CommandManager;
import me.dmitriy.server.utilits.exceptions.WrongArgumentException;

/**
 * Класс, реализующий команду help.
 */

public class HelpCommand extends AbstractCommand{

    /**
     * Конструктор команды.
     */

    public HelpCommand(){
        super("help", "вывести справку по доступным командам");
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
     * Метод, исполняющий команду help.
     */

    @Override
    public void execute(){
        System.out.println("""
                help : вывести справку по доступным командам
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add {element} : добавить новый элемент в коллекцию
                update id {element} : обновить значение элемента коллекции, id которого равен заданному
                remove_by_id id : удалить элемент из коллекции по его id
                clear : очистить коллекцию
                save : сохранить коллекцию в файл
                execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                exit : завершить программу (без сохранения в файл)
                remove_first : удалить первый элемент из коллекции
                remove_last : удалить последний элемент из коллекции
                remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный
                remove_any_by_refundable refundable : удалить из коллекции один элемент, значение поля refundable которого эквивалентно заданному
                filter_less_than_type type : вывести элементы, значение поля type которых меньше заданного
                print_field_descending_price : вывести значения поля price всех элементов в порядке убывания""");
    }
}
