package me.dmitriy.server.utilits;


import me.dmitriy.server.utilits.commands.Command;
import me.dmitriy.server.utilits.exceptions.NoSuchCommandException;
import me.dmitriy.server.utilits.exceptions.ScriptException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс, реализующий работу комманд.
 */

public class CommandManager{
    private final HashMap<String, Command> commands = new HashMap<>();
    private final ArrayList<String> historyOfCommands = new ArrayList<>(10);
    private final Command addCommand;
    private final Command clearCommand;
    private final Command executeScriptCommand;
    private final Command exitCommand;
    private final Command filterLessThanTypeCommand;
    private final Command helpCommand;
    private final Command historyCommand;
    private final Command infoCommand;
    private final Command printFieldDescendingPriceCommand;
    private final Command removeAnyByRefundableCommand;
    private final Command removeByIdCommand;
    private final Command removeFirstCommand;
    private final Command removeLastCommand;
    private final Command removeLowerCommand;
    private final Command saveCommand;
    private final Command showCommand;
    private final Command updateByIdCommand;

    /**
     * Конструктор связывающий команды и CommandManager.
     * @param addCommand command
     * @param clearCommand command
     * @param executeScriptCommand command
     * @param exitCommand command
     * @param filterLessThanTypeCommand command
     * @param helpCommand command
     * @param infoCommand command
     * @param printFieldDescendingPriceCommand command
     * @param removeAnyByRefundableCommand command
     * @param removeByIdCommand command
     * @param removeFirstCommand command
     * @param removeLastCommand command
     * @param removeLowerCommand command
     * @param saveCommand command
     * @param showCommand command
     * @param updateByIdCommand command
     */

    public CommandManager(Command addCommand, Command clearCommand, Command executeScriptCommand, Command exitCommand,
                          Command filterLessThanTypeCommand, Command helpCommand, Command historyCommand, Command infoCommand, Command printFieldDescendingPriceCommand,
                          Command removeAnyByRefundableCommand, Command removeByIdCommand, Command removeFirstCommand,
                          Command removeLastCommand, Command removeLowerCommand, Command saveCommand, Command showCommand, Command updateByIdCommand){
        this.addCommand = addCommand;
        this.clearCommand = clearCommand;
        this.executeScriptCommand = executeScriptCommand;
        this.exitCommand = exitCommand;
        this.filterLessThanTypeCommand = filterLessThanTypeCommand;
        this.helpCommand = helpCommand;
        this.historyCommand = historyCommand;
        this.infoCommand = infoCommand;
        this.printFieldDescendingPriceCommand = printFieldDescendingPriceCommand;
        this.removeAnyByRefundableCommand = removeAnyByRefundableCommand;
        this.removeByIdCommand = removeByIdCommand;
        this.removeFirstCommand = removeFirstCommand;
        this.removeLastCommand = removeLastCommand;
        this.removeLowerCommand = removeLowerCommand;
        this.saveCommand = saveCommand;
        this.showCommand = showCommand;
        this.updateByIdCommand = updateByIdCommand;

        putCommands();
    }

    /**
     * Метод для заполнения HashMap командами и их наименованием.
     */

    public void putCommands(){
        commands.put("add", addCommand);
        commands.put("clear", clearCommand);
        commands.put("execute_script", executeScriptCommand);
        commands.put("exit", exitCommand);
        commands.put("filter_less_than_type", filterLessThanTypeCommand);
        commands.put("help", helpCommand);
        commands.put("history", historyCommand);
        commands.put("info", infoCommand);
        commands.put("print_field_descending_price", printFieldDescendingPriceCommand);
        commands.put("remove_any_by_refundable", removeAnyByRefundableCommand);
        commands.put("remove_by_id", removeByIdCommand);
        commands.put("remove_first", removeFirstCommand);
        commands.put("remove_last", removeLastCommand);
        commands.put("remove_lower", removeLowerCommand);
        commands.put("save", saveCommand);
        commands.put("show", showCommand);
        commands.put("update_by_id", updateByIdCommand);
    }

    /**
     * @return Команды.
     */

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    /**
     * @return Историю команд.
     */

    public ArrayList<String> getHistoryOfCommands(){
        return historyOfCommands;
    }

    /**
     * Метод для добавления команд в историю.
     * @param command command
     */

    public void addToHistoryOfCommands(String command){
        historyOfCommands.add(command);
    }

    /**
     * Метод для сохранения истории команд в файл перед завершением работы программы.
     */

    public void saveHistoryOfCommands(){
        try(FileWriter fileWriter = new FileWriter(System.getenv("historyOfCommands"))){
            for(String command : getHistoryOfCommands()){
                fileWriter.write(command);
            }
            fileWriter.flush();
        }catch(IOException exception){
            System.out.println("Please do not delete the file!");
        }
    }

    /**
     * Метод, исполняющий команду execute_script file_name.
     */

    public void executeScriptCommand(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getenv("script")))){
            String line;

            while((line = bufferedReader.readLine()) != null){
                String command;
                String argument;
                String[] tokens = line.trim().replaceAll("( )\1*", " ").split(" ");
                if(tokens.length > 2) throw new NoSuchCommandException();
                else if(tokens.length == 2){
                    command = tokens[0];
                    argument = tokens[1];
                }
                else{
                    command = tokens[0];
                    argument = null;
                }
                if(!getCommands().containsKey(command)) throw new NoSuchCommandException();
                if(command.equals("execute_script")) throw new ScriptException();
                if(getCommands().get(command).hasValidArgument(argument)){
                    addToHistoryOfCommands(command + "\n");
                    switch (command){
                        case "help" -> helpCommand();
                        case "history" -> historyOfCommands();
                        default -> getCommands().get(command).execute();
                    }
                }
            }

        }catch(IOException exception){
            System.out.println("The script is not available for use!");
        }catch(NoSuchCommandException exception){
            System.out.println("There is no such command!");
        }catch(ScriptException exception){
            System.out.println("The script command cannot be in the script itself!");
        }
    }

    /**
     * Метод, исполняющий команду help.
     */

    public void helpCommand(){
        for(Command command : this.commands.values()){
            System.out.println(command.getName() + ": " + command.getDescription());
        }
    }

    /**
     * Метод, исполняющий команду history.
     */

    public void historyOfCommands(){
        System.out.println("Used the following commands: ");
        for(String command : getHistoryOfCommands()){
            System.out.println(command);
        }
    }
}