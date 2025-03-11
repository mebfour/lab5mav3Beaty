package Commands;

import MyClasses.Route;

import java.util.*;
import java.util.stream.Collectors;

import static Service.CollectionManager.routeList;

public class RemoveLower implements Command{
    @Override
    public void execute(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inpKey;
        // Ввод ключа
        while (true) {
            try {
                System.out.print("Введите id элемента, до которого вы хотите удалить все: ");
                inpKey = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число.");
            }
        }

        // Сортировка LinkedHashMap
        LinkedHashMap<String, Route> sortedMap = routeList.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(Route::getId)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // функция слияния
                        LinkedHashMap::new)); // сохраняем порядок вставки

        // Удаление элементов, начиная с определённого ключа
        if (!routeList.isEmpty()) {
            Iterator<Map.Entry<String, Route>> it = routeList.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry<String, Route> entry = it.next();
                Route currentRoute = entry.getValue();
                if (currentRoute.getId() < inpKey) {
                    // Удаляем элементы, у которых id меньше inpKey
                    it.remove(); // Используем итератор для удаления
                }
            }
        } else {
            System.out.println("Коллекция пуста! Введите add для добавления нового элемента.");
        }
    }


    @Override
    public String getDescription() {
        return "удаляет из коллекции все элементы, превышающие заданный";
    }
}
