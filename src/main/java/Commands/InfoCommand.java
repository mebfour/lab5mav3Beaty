package Commands;

import Service.CollectionManager;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.LinkedHashMap;

public class InfoCommand implements Command{

    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        Date time = CollectionManager.getInitializationTime();
        System.out.println("Тип коллекции: " + CollectionManager.getCollectionType().getSimpleName() + '\n'
                + "Дата инициализации коллекции: " + time.toString().substring(0, 10) +" " + time.toString().substring(11, 19) + '\n'
                + "Размер коллекции: " + collectionManager.getCollection().size() + "\n"
        );
        return null;
    }

    @Override
    public String getDescription() {
        return "выводит информацию о коллекции";
    }


}
