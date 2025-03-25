package Commands;

import MyClasses.Route;

import java.util.Iterator;
import java.util.LinkedHashMap;

import static Service.CollectionManager.routeList;

public class ShowCommand implements Command{

    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        if (!routeList.isEmpty()) {
            Iterator<Route> it = routeList.values().iterator();
            while (it.hasNext()) {          //без вайла будет выводиться только 1й элт
                Route currentRoute = it.next();
                System.out.println(currentRoute.toString() + '\n' + '\n');
            }
        }
        else {
            System.out.println("Коллекция пуста! Введите add для добавления нового элемента.");
        }
        return null;
    }

    @Override
    public String getDescription() {
        return "выводит коллекцию";
    }

}


