package me.dmitriy.server.utilits;

import me.dmitriy.server.data.Ticket;
import me.dmitriy.server.utilits.commands.*;
import me.dmitriy.server.utilits.exceptions.NoSuchCommandException;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс, реализующий интерактивную работу с консолью.
 */

public class LaunchManager{
    private boolean process = true;
    ArrayList<Ticket> collection = new ArrayList<>();
    CollectionManager collectionManager = new CollectionManager(collection);
    CommandManager commandManager = new CommandManager(new AddCommand(collectionManager), new ClearCommand(collectionManager),
            new ExecuteScriptCommand(), new ExitCommand(), new FilterLessThanTypeCommand(collectionManager), new HelpCommand(),
            new HistoryCommand(), new InfoCommand(collectionManager), new PrintFieldDescendingPriceCommand(collectionManager),
            new RemoveAnyByRefundableCommand(collectionManager), new RemoveByIdCommand(collectionManager),
            new RemoveFirstCommand(collectionManager), new RemoveLastCommand(collectionManager),
            new RemoveLowerCommand(collectionManager), new SaveCommand(collectionManager), new ShowCommand(collectionManager),
            new UpdateByIdCommand(collectionManager));

    /**
     * Метод, реализующий работу команд введённых с консоли.
     */

    public void getCommandFromConsole(){
        collectionManager.loadCollectionFromFile();
        Scanner scanner = new Scanner(System.in);
        while(isProcess()){
            try{
                System.out.println("Enter the command: ");
                String command;
                String argument;
                String[] tokens = scanner.nextLine().trim().replaceAll("( )\1*", " ").split(" ");
                System.out.println("----------------------");
                if(tokens.length > 2) throw new NoSuchCommandException();
                else if(tokens.length == 2){
                    command = tokens[0];
                    argument = tokens[1];
                }
                else{
                    command = tokens[0];
                    argument = null;
                }
                if(!commandManager.getCommands().containsKey(command)) throw new NoSuchCommandException();
                if(commandManager.getCommands().get(command).hasValidArgument(argument)){
                    commandManager.addToHistoryOfCommands(command + "\n");
                    switch (command){
                        case "help" -> commandManager.helpCommand();
                        case "history" -> commandManager.historyOfCommands();
                        case "execute_script" -> commandManager.executeScriptCommand();
                        default -> commandManager.getCommands().get(command).execute();
                    }
                }
            }catch(NoSuchCommandException exception){
                System.out.println("Wrong command input, try entering the command and argument separated by a space.");
                System.out.println("For more detailed information, enter the help command!");
            }catch(NoSuchElementException exception){
                System.out.println("Something went wrong!");
                commandManager.saveHistoryOfCommands();
                setProcess(false);
            }catch(IllegalArgumentException exception){
                System.out.println("Error");
                commandManager.saveHistoryOfCommands();
                setProcess(false);
            }
        }
    }

    /**
     * Геттер для поля process.
     * @return process
     */

    public boolean isProcess(){
        return this.process;
    }

    /**
     * Сеттер для поля process.
     * @param process process
     */

    public void setProcess(boolean process){
        this.process = process;
    }
}