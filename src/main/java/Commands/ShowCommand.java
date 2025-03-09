package Commands;

import MyClasses.Route;

import java.util.Iterator;

import static Service.CollectionManager.routeList;

public class ShowCommand implements Command{

    @Override
    public void execute(String[] args) {

        if (!routeList.isEmpty()) {
            Iterator<Route> it = routeList.values().iterator();

            Route currentRoute = it.next();
            System.out.println(currentRoute.toString() + '\n' + '\n');

        }
        else {
            System.out.println("Коллекция пуста! Введите add для добавления нового элемента.");
        }
    }

    @Override
    public String getDescription() {
        return "выводит коллекцию";
    }

}


