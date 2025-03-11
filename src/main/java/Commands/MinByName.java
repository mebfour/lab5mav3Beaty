package Commands;
import MyClasses.Route;

import java.util.*;
import java.util.stream.Collectors;
import static Service.CollectionManager.routeList;

public class MinByName implements Command{
    @Override
    public void execute(String[] args) {
        if (!routeList.isEmpty()){
            Route minRoute =
                    routeList.values().stream()
                            .min(Comparator.comparing(Route::getName)) // Сравниваем по алфавиту
                            .orElse(null);
            System.out.println(minRoute);
        }else{
            System.out.println("Коллекция пуста! Введите add для добавления нового элемента.");
        }
    }

    @Override
    public String getDescription() {
        return "выводит любой объект из коллекции, значение поля name которого является минимальным";
    }
}
