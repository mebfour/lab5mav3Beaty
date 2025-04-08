package Commands.ForScript;

import Commands.Command;
import InputHandler.InputProvider;
import InputHandler.ScriptInputProvider;
import InputHandler.inputObject;
import MyClasses.Route;
import Service.CommandManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

import static Service.CollectionManager.routeList;

public class ExecuteScript implements Command {
    private static final HashSet<String> callStack = new HashSet<>();

    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        String filePath;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (args.length > 1) {
                filePath = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
            } else {
                // Если аргумента нет, запрашиваем ввод с консоли
                System.out.print("Введите путь к файлу: ");
                filePath = scanner.nextLine().trim();
            }
            callStack.add("execute_script " + filePath);

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
                    InputProvider inputProvider = new ScriptInputProvider(reader);

                    String[] parts = line.split("\\s+", 2); // Разделяем по пробелу (максимум на 2 части)
                    String line1 = parts[0]; // Первая часть — команда
                    String argument = parts.length > 1 ? parts[1] : ""; // Вторая часть — аргумент (если есть)
                    switch (line1) {
                        case ("execute_script"): {
                            if (callStack.contains(line)) {
                                System.out.println("Упс, рекурсия. Не вызывайте одни и те же скрипты");
                                break;
                            }
                            callStack.add(line);

                        }



                        case ("add"): {
                            Route rn = new Route();
                            inputObject.inputObject(rn, inputProvider);
                            break;
                        }
                        case ("insert_with_key"): {
                            Route rn = new Route();
                            inputObject.inputKey(rn);
                            inputObject.inputObject(rn, inputProvider);
                            routeList.put(rn.getKey(), rn);
                            break;
                        }
                        case ("update_id"): {
                            String k = inputObject.findKeyById(inputProvider, null);
                            Route rn = routeList.get(k);
                            inputObject.inputObject(rn, inputProvider);
                            routeList.put(rn.getName(), rn);
                            break;
                        }
                        default:
                            CommandManager.checkComm(line);
                            break;

                    }

                }
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (StackOverflowError e) {
                System.out.println("Переделайте скрипт, пожалуйста.");
            } finally {
                callStack.remove("execute_script " + filePath);
            }

        }
        return null;
    }


    @Override
    public String getDescription () {
        return "считывает и исполняет скрипт";

    }
}
