package Commands;

import InputHandler.InputProvider;
import InputHandler.KeyboardInputProvider;
import InputHandler.inputObject;
import MyClasses.Route;

import java.util.LinkedHashMap;
import java.util.Scanner;

import static Service.CollectionManager.routeList;

public class InsertWithKey extends AddCommand {

    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {

        InputProvider inputProvider = new KeyboardInputProvider();
        Route rn = new Route();
        Scanner scanner = new Scanner(System.in);
        String key = null;
        while (true) {

            try {
                if (!routeList.isEmpty()) {
                    if (args.length > 1) {
                        key = args[1];
                    } else {
                        // Если аргумента нет, запрашиваем ввод с консоли
                        System.out.print("Введите ключ: ");
                        key = scanner.nextLine();
                    }
                    break; // Выходим из цикла при успешном вводе
                }else {
                    System.out.println("Коллекция пуста! Введите add для добавления нового элемента.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка");
                args = new String[0];
            }
        }
        rn.setKey(key);
        inputObject.inputObject(rn, inputProvider);
        routeList.put(rn.getKey(), rn);

        return null;
    }

    @Override
    public String getDescription() {
        return "добавляет элемент с заданным ключом";
    }

}
