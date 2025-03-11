package Commands;

import java.util.Scanner;

import static Service.CollectionManager.routeList;

public class RemoveByKey implements Command {

    @Override
    public void execute(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ключ элемента, который Вы хотите удалить: ");
        String k = scanner.nextLine();
        routeList.remove(k);
    }

    @Override
    public String getDescription() {
        return "удаляет элемент из коллекции по его ключу";
    }


}
