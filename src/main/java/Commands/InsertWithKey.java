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
        inputObject.inputKey(rn);
        inputObject.inputObject(rn, inputProvider);
        routeList.put(rn.getKey(), rn);

        return null;


//        InputProvider inputProvider = new KeyboardInputProvider();
//        Route rn = new Route();
//
//        String inpKey;
//        while (true) {
//            if (args.length > 1) {
//                inpKey = args[1];
//                inputObject.inputKey(rn);
//                inputObject.inputObject(rn, inputProvider);
//
//
//            } else {
//                // Если аргумента нет, запрашиваем ввод с консоли
//                Scanner scanner = new Scanner(System.in);
//                System.out.print("Введите ключ: ");
//                inpKey = scanner.nextLine();
//                break;
//            }
//            break;
//
//        }
//        rn.setKey(inpKey);
//        inputObject.inputKey(rn);
//        inputObject.inputObject(rn, inputProvider);
//
//        return null;
    }

    @Override
    public String getDescription() {
        return "добавляет элемент с заданным ключом";
    }

}
