package Commands;

import MyClasses.Route;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static Service.CollectionManager.routeList;

public class FilterGreaterThanDistance implements Command{
    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        Double minDist;
        while (true) {
            try {if (args.length > 1) {
                minDist = Double.parseDouble(args[1]);
            } else {
                // Если аргумента нет, запрашиваем ввод с консоли
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите расстояние: ");
                minDist = Double.parseDouble(scanner.nextLine());
            }
                break; // Выходим из цикла при успешном вводе
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести число.");
                args = new String[0];
            }
        }

        if (!routeList.isEmpty()) {
            Iterator<Map.Entry<String, Route>> it = routeList.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Route> entry = it.next();
                Route currentRoute = entry.getValue();
                if (currentRoute.getDistance() > minDist) {
                    // Удаляем элементы, у которых id меньше inpKey
                    System.out.println(currentRoute); // Используем итератор для удаления
                }
            }
        } else {
            System.out.println("Коллекция пуста! Введите add для добавления нового элемента.");
        }


        return null;
    }

    @Override
    public String getDescription() {
        return "выводит элементы, значение поля distance которых больше заданного";
    }
}
