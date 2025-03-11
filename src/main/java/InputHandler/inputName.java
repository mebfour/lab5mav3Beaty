package InputHandler;

import MyClasses.Coordinates;
import MyClasses.Location;
import MyClasses.Route;
import Service.CollectionManager;


import java.util.Scanner;

public class inputName {


    public static void inputKey(Route route){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ключ: ");
        String key = scanner.nextLine();
        route.setKey(key);
    }
    public static void updateID(Route route){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите id: ");
                int id = Integer.parseInt(scanner.nextLine());
                route.setId(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число.");
            }
        }
    }

    public static void sthName(Route route, InputProvider inputProvider) {
        // Устанавливаем название
        route.setName(inputProvider.readString("Введите название:"));

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

        // Устанавливаем расстояние
        route.setDistance(inputProvider.readDouble("Введите расстояние:"));

        // Добавляем в коллекцию
        CollectionManager collectionManager = new CollectionManager();
        collectionManager.addToCollection(route);
        System.out.println("Добавлен в коллекцию!");
    }


}
