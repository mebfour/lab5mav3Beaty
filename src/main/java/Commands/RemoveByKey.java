package Commands;

import java.util.LinkedHashMap;
import java.util.Scanner;

import static Service.CollectionManager.routeList;

public class RemoveByKey implements Command {

    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите ключ элемента, который Вы хотите удалить: ");
            String inpKey = scanner.nextLine().trim();  // Добавил trim() для обработки пробелов

            if (routeList.containsKey(inpKey)) {
                routeList.remove(inpKey);
                System.out.println("Элемент с ключом '" + inpKey + "' успешно удален");
                break;
            } else {
                System.out.println("Элемент с ключом '" + inpKey + "' не найден");
                // Цикл продолжится для нового ввода
            }
        }
        return null;
    }

    @Override
    public String getDescription() {
        return "удаляет элемент из коллекции по его ключу";
    }
}


