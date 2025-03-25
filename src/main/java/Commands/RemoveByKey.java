package Commands;

import java.util.LinkedHashMap;
import java.util.Scanner;

import static Service.CollectionManager.routeList;

public class RemoveByKey implements Command {

    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ключ элемента, который Вы хотите удалить: ");
        String k = scanner.nextLine();
        routeList.remove(k);
        return null;
    }

    @Override
    public String getDescription() {
        return "удаляет элемент из коллекции по его ключу";
    }


}
