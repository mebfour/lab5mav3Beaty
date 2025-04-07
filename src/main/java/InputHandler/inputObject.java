package InputHandler;

import MyClasses.Coordinates;
import MyClasses.Location;
import MyClasses.Route;
import Service.CollectionManager;


import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import static Service.CollectionManager.routeList;
import static java.lang.System.in;

public class inputObject {


    public static void inputKey(Route route){
        Scanner scanner = new Scanner(in);
        System.out.println("Введите ключ: ");
        String key = scanner.nextLine();
        route.setKey(key);
    }

    public static String findKeyById(InputProvider inputProvider, String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inpId;
        while (true) {
            try {

                if (args.length > 1) {
                    inpId = Integer.parseInt(args[1]);
                } else {
                    // Если аргумента нет, запрашиваем ввод с консоли

                    inpId = inputProvider.readInt("Введите ID: ", 1);
                }
                for (Map.Entry<String, Route> entry : routeList.entrySet()) {
                    if (entry.getValue().getId() == inpId) {
                        return entry.getKey();
                    }
                }
                System.out.println("Элемент с таким id не найден.");
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число.");
            }
        }
    }

    public static void inputObject(Route route, InputProvider inputProvider) {
        // Устанавливаем название
        route.setName(inputProvider.readString("Введите название:"));
        if (route.getKey() == null) {
            route.setKey(route.getName());
        }
        // Устанавливаем координаты
        Coordinates coordinates = new Coordinates();
        coordinates.setX(inputProvider.readLong("Введите x:", -326));
        coordinates.setY(inputProvider.readInt("Введите y:", -258));
        route.setCoordinates(coordinates);

        // Устанавливаем локацию "куда"
        Location locationTo = new Location();
        locationTo.setName(inputProvider.readString("Введите, куда вы хотите попасть:"));
        locationTo.setX(inputProvider.readFloat("Введите x:"));
        locationTo.setY(inputProvider.readInt("Введите y:", Integer.MIN_VALUE));
        locationTo.setZ(inputProvider.readInt("Введите z:", Integer.MIN_VALUE));
        route.setTo(locationTo);

        // Устанавливаем локацию "откуда"
        Location locationFrom = new Location();
        locationFrom.setName(inputProvider.readString("Введите, откуда вы добираетесь:"));
        locationFrom.setX(inputProvider.readFloat("Введите x:"));
        locationFrom.setY(inputProvider.readInt("Введите y:", Integer.MIN_VALUE));
        locationFrom.setZ(inputProvider.readInt("Введите z:", Integer.MIN_VALUE));
        route.setFrom(locationFrom);
        try {
            Double dist = inputProvider.readDouble("Введите расстояние:", 1);
            if (dist != -1) {
                route.setDistance(dist);
                // Добавляем в коллекцию
                CollectionManager collectionManager = new CollectionManager();
                collectionManager.addToCollection(route);
                System.out.println("Добавлен в коллекцию!");
            } else {
                System.out.println("Некорректное расстояние");
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("Ошибка");
        }








    }


}
