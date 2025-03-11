package Commands;

import MyClasses.Route;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import static Service.CollectionManager.routeList;

public class FilterGreaterThanDistance implements Command{
    @Override
    public void execute(String[] args) {
        Double minDist;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите расстояние: ");
                minDist = Double.parseDouble(scanner.nextLine());    //такую же херню с интами

                break;
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести число.");
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


    }

    @Override
    public String getDescription() {
        return "выводит элементы, значение поля distance которых больше заданного";
    }
}
