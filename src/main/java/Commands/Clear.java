package Commands;

import java.util.LinkedHashMap;

import static Service.CollectionManager.routeList;

public class Clear implements Command{
    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        routeList.clear();
        System.out.println("Коллекция очищена успешно!");
        return null;
    }

    @Override
    public String getDescription() {
        return "очищает коллекцию";
    }
}
