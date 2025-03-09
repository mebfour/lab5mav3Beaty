package Commands;

import static Service.CollectionManager.routeList;

public class Clear implements Command{
    @Override
    public void execute(String[] args) {
        routeList.clear();
        System.out.println("Коллекция очищена успешно!");
    }

    @Override
    public String getDescription() {
        return "очищает коллекцию";
    }
}
