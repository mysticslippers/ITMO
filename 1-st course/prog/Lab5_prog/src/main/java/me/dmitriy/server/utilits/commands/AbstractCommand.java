package me.dmitriy.server.utilits.commands;

/**
 * Абстрактный класс, реализующий шаблон Command.
 */

public abstract class AbstractCommand implements Command{
    private final String name;
    private final String description;

    /**
     * Конструктор любой команды, состоящий из имени и описания.
     */

    public AbstractCommand(String name, String description){
        this.name = name;
        this.description = description;
    }

    /**
     * @return Имя команды.
     */
    @Override
    public String getName(){
        return name;
    }

    /**
     * @return Описание команды.
     */
    @Override
    public String getDescription(){
        return description;
    }

    /**
     * @return Возвращает true, если у команды должен быть аргумент.
     */

    @Override
    public abstract boolean hasValidArgument(String argument);

    /**
     * Абстрактный метод для исполнения команды.
     */

    @Override
    public abstract void execute();
}
