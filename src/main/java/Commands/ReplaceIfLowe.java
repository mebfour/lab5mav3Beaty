package Commands;

import MyClasses.Route;

import java.util.*;

import static Service.CollectionManager.routeList;

public class ReplaceIfLowe implements Command{
    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inpEl;
        String inpKey;
        boolean flagSuc = true;
        boolean done = false;

        while (true) {
            try {
                if (args.length > 1 && flagSuc) {
                    inpEl = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                } else {
                    // Если аргумента нет, запрашиваем ввод с консоли
                    System.out.print("Введите ключ элемента: ");
                    inpEl = scanner.nextLine();
                }
                if (routeList.containsKey(inpEl)) {
                    if (!routeList.isEmpty()) {
                        Route routeToModify = routeList.get(inpEl);

                        System.out.println("Введите новый ключ: ");
                        inpKey = scanner.nextLine();

                        if (inpKey.compareTo(routeToModify.getKey()) < 0){
                            routeToModify.setKey(inpEl);
                        }else {
                            System.out.println("Введенный ключ не меньше уже имеющегося, так низя(");
                        }
                    } else {
                        System.out.println("Коллекция пуста! Введите add для добавления нового элемента.");
                    }

                    break;
                } else {
                    System.out.println("Элемент с ключом " + inpEl + " не найден");
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
        return "заменяет значение по ключу, если новое значение меньше старого";
    }
}
