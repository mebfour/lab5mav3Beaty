package Commands;

import Service.CollectionManager;
import java.time.ZonedDateTime;
public class InfoCommand implements Command{

    @Override
    public void execute(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        ZonedDateTime time = collectionManager.getCollectionInitializationTime();
        System.out.println("Тип коллекции: " + CollectionManager.getCollectionType().getSimpleName() + '\n'
                + "Дата инициализации коллекции: " + time.toString().substring(0, 10) +" " + time.toString().substring(11, 19) + '\n'
                + "Размер коллекции: " + collectionManager.getCollection().size() + "\n"
        );
    }

    @Override
    public String getDescription() {
        return "выводит информацию о коллекции";
    }


}
