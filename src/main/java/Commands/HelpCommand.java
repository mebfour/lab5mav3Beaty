package Commands;

import java.util.LinkedHashMap;
import java.util.Map;

import static Service.CommandManager.commandList;

public class HelpCommand implements Command {

    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        System.out.println("Доступные команды:");
        for (Map.Entry<String, Command> currentCommand : commandList.entrySet()) {
            String commandName = currentCommand.getKey();
            Command command = commandList.get(commandName);
            System.out.println("- " + commandName +" "+ command.getDescription()+'\n');
        }
        return null;
    }
    @Override
    public String getDescription() {
        return "выводит описание всех доступных команд";
    }

}