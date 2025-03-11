package Commands.XmlProcessing;

import Commands.Command;
import InputHandler.InputProvider;
import InputHandler.KeyboardInputProvider;
import InputHandler.ScriptInputProvider;
import InputHandler.inputName;
import MyClasses.Route;
import Service.CommandManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExecuteScript implements Command {

    @Override
    public void execute(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите путь к файлу: ");
            //        String filePath = "src\\main\\java\\files\\script.txt";
            String filePath = scanner.nextLine().trim();
            if (!new java.io.File(filePath).exists()) {
                System.out.println("Файл не найден: " + filePath);
                continue;
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                CommandManager commandManager = new CommandManager();
                while ((line = reader.readLine()) != null) {
                    // Убираем лишние пробелы в начале и конце строки
                    line = line.trim();
                    // Пропускаем пустые строки и комментарии (начинающиеся с #)
                    if (line.isEmpty() || line.startsWith("#")) {
                        continue;
                    }
                    // Выполняем команду

                    switch (line) {
                        case ("add"):
                            InputProvider inputProvider = new ScriptInputProvider(reader);
                            Route rn = new Route();
                            inputName.sthName(rn, inputProvider);
                            break;
                        default:
                            commandManager.checkComm(line);
                            break;
                    }

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (StackOverflowError e) {
                System.out.println("Переделайте скрипт, пожалуйста.");
            }

        }
    }
        @Override
    public String getDescription() {
        return "считывает и исполняет скрипт";
    }
}
