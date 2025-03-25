package Service;

import Commands.*;
import Commands.XmlProcessing.ExecuteScript;
import Commands.XmlProcessing.SaveCommand;

import java.util.HashMap;
import java.util.Map;


public class CommandManager {
    public static Map<String, Command> commandList = new HashMap<>();

    static {

        commandList.put("add", new AddCommand());
        commandList.put("info", new InfoCommand());
        commandList.put("show", new ShowCommand());
        commandList.put("exit", new ExitCommand());
        commandList.put("insert_with_key", new InsertWithKey());
        commandList.put("updateId", new UpdateID());
        commandList.put("help", new HelpCommand());
        commandList.put("removeByKey", new RemoveByKey());
        commandList.put("clear", new Clear());
        commandList.put("removeGreater", new RemoveGreater());
        commandList.put("removeLower", new RemoveLower());
        commandList.put("replaceIfLowe", new ReplaceIfLowe());
        commandList.put("minByName", new MinByName());
        commandList.put("maxById", new MaxByID());
        commandList.put("save", new SaveCommand());

        commandList.put("execute_script", new ExecuteScript());
        commandList.put("filter_greater_than_distance", new FilterGreaterThanDistance());
    }
    public static void checkComm (String inp){
        String[] inpWords = inp.split(" ");
        String commandName = inpWords[0];

        Command command = commandList.get(commandName);
            if (command != null){
                command.execute(inpWords);
            }else {
                System.out.println("Такой команды нет, давайте попробуем другой набор символов");
            }


    }


}

