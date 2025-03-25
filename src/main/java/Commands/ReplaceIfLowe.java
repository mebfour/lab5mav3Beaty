package Commands;

import MyClasses.Route;

import java.util.LinkedHashMap;
import java.util.Scanner;

import static Service.CollectionManager.routeList;

public class ReplaceIfLowe implements Command{
    @Override
    public LinkedHashMap<Object, Object> execute(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inpKey;
        int inpID;
        while (true){
            System.out.println("Введите ключ элемента, который Вы хотите изменить: ");
            inpKey = scanner.nextLine();
            if (routeList.containsKey(inpKey)){
                try {
                    System.out.print("Введите новый id элемента: ");
                    inpID = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Нужно ввести целое число.");
                }
            }else {
                System.out.println("Элемент с таким ключом не найден, давайте попробуем еще раз!");
            }
        }
        Route routeToModify = routeList.get(inpKey);
        // Изменяем поле объекта

        if (inpID < routeToModify.getId()){
            routeToModify.setId(inpID);
        }else {
            System.out.println("Введенный ID не меньше уже имеющегося, так низя(");
        }
        return null;
    }

    @Override
    public String getDescription() {
        return "заменяет значение по ключу, если новое значение меньше старого";
    }
}
