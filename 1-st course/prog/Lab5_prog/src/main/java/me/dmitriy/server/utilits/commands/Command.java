package me.dmitriy.server.utilits.commands;

/**
 * Интерфейс для реализации шаблона команд.
 */

public interface Command{
    /**
     * Абстрактный метод для получения названия команды.
     */

    String getName();

    /**
     * Абстрактный метод для получения описания команды.
     */

    String getDescription();

    /**
     * Абстрактный метод для исполнения команды.
     */

    void execute();

    /**
     * Абстрактный метод для определения валидности аргумента команды.
     */

    boolean hasValidArgument(String argument);
}
