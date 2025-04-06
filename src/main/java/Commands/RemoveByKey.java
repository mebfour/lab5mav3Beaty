package Commands;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

import static Service.CollectionManager.routeList;

public class RemoveByKey implements Command {

    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inpKey;
        boolean flagSuc = true;
        while (true) {
            try {
                if (args.length > 1 && flagSuc == true) {
                inpKey = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
            } else {
                // Если аргумента нет, запрашиваем ввод с консоли
                System.out.print("Введите ключ элемента, который Вы хотите удалить: ");
                inpKey = scanner.nextLine();
            }
                if (routeList.containsKey(inpKey)) {
                    routeList.remove(inpKey);
                    System.out.println("Элемент с ключом " + inpKey + " успешно удален");
                    break;
                } else {
                    System.out.println("Элемент с ключом " + inpKey + " не найден");
                    flagSuc = false;
                    // Цикл продолжится для нового ввода
                }

            } catch (Exception e) {
                System.out.println("Ошибка");
                args = new String[0];
            }
        }
        return null;
    }

    @Override
    public String getDescription() {
        return "удаляет элемент из коллекции по его ключу";
    }
}


