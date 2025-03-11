package Commands;

import MyClasses.Route;

import java.util.Comparator;

import static Service.CollectionManager.routeList;

public class MaxByID implements Command{
    @Override
    public void execute(String[] args) {
        if (!routeList.isEmpty()){
            Route maxRoute =
                    routeList.values().stream()
                            .max(Comparator.comparing(Route::getId)) // Сравниваем по алфавиту
                            .orElse(null);
            System.out.println(maxRoute);
        }else{
            System.out.println("Коллекция пуста! Введите add для добавления нового элемента.");
        }
    }

    @Override
    public String getDescription() {
        return "выводит любой объект из коллекции, значение поля id которого является максимальным";
    }
}
