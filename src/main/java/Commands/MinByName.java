package Commands;
import MyClasses.Route;

import java.util.*;

import static Service.CollectionManager.routeList;

public class MinByName implements Command{
    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        if (!routeList.isEmpty()){
            Route minRoute =
                    routeList.values().stream()
                            .min(Comparator.comparing(Route::getName)) // Сравниваем по алфавиту
                            .orElse(null);
            System.out.println(minRoute);
        }else{
            System.out.println("Коллекция пуста! Введите add для добавления нового элемента.");
        }
        return null;
    }

    @Override
    public String getDescription() {
        return "выводит любой объект из коллекции, значение поля name которого является минимальным";
    }
}
