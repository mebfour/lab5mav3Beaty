package Commands;

import InputHandler.InputProvider;
import MyClasses.Route;

import java.util.*;
import java.util.stream.Collectors;

import static Service.CollectionManager.routeList;

public class RemoveGreater implements Command{
    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inpKey;
        boolean flagSuc = true;
        while (true) {
            try {
                if (args.length > 1 && flagSuc) {
                    inpKey = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                } else {
                    // Если аргумента нет, запрашиваем ввод с консоли
                    System.out.print("Введите ключ элемента: ");
                    inpKey = scanner.nextLine();
                }
                // Сортировка LinkedHashMap
                if (routeList.containsKey(inpKey)) {

                    // Удаление элементов, начиная с определённого ключа
                    if (!routeList.isEmpty()) {
                        Iterator<Map.Entry<String, Route>> it = routeList.entrySet().iterator();
                        boolean foundKey = false; // Флаг для поиска ключа
                        while (it.hasNext()) {
                            Map.Entry<String, Route> entry = it.next();
                            Route currentRoute = entry.getValue();
                            if (foundKey) {
                                // Удаляем все элементы после найденного ключа
                                it.remove(); // Используем итератор для удаления

                            } else if (entry.getKey().equals(inpKey)) {
                                // Нашли ключ, устанавливаем флаг
                                foundKey = true;
                            }
                        }
                    } else {
                        System.out.println("Коллекция пуста! Введите add для добавления нового элемента.");
                    }

                    break;
                } else {
                    System.out.println("Элемент с ключом " + inpKey + " не найден");
                    flagSuc = false;
                    // Цикл продолжится для нового ввода
                }

            } catch (Exception e) {
                System.out.println("Ошибка");
            }
        }
        return null;
    }
    @Override
    public String getDescription() {
        return "удаляет из коллекции все элементы, превышающие заданный";
    }

}