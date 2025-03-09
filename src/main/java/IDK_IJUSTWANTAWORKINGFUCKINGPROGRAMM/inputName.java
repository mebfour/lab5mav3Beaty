package IDK_IJUSTWANTAWORKINGFUCKINGPROGRAMM;

import MyClasses.Coordinates;
import MyClasses.Location;
import MyClasses.Route;
import Service.CollectionManager;
import Service.CommandManager;


import javax.sound.midi.Soundbank;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.SortedMap;

import static Service.CollectionManager.routeList;

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

    public static void sthName(Route route){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название: ");
        route.setName(scanner.nextLine());
        CollectionManager collectionManager = new CollectionManager();
        System.out.println("");
        System.out.println("Введите координаты: ");
        Coordinates coordinates = new Coordinates();
        Location locationTo = new Location();
        Location locationFrom = new Location();

        while (true) {
            try {

                System.out.print("    Введите x: ");
                Long x = Long.parseLong(scanner.nextLine());    //такую же херню с интами

                if (x < -326) {
                    System.out.println("Слишком маленькое число");
                } else {
                    coordinates.setX(x);
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число.");
            }
        }


        while (true) {
            try {

                System.out.print("    Введите y: ");
                Integer y = Integer.parseInt(scanner.nextLine());    //такую же херню с интами

                if (y < -258) {
                    System.out.println("Слишком маленькое число");
                } else {
                    coordinates.setY(y);
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число.");
            }
        }
        route.setCoordinates(coordinates);

        System.out.println("Введите, куда вы хотите попасть: ");
        System.out.println("Введите название: ");
        locationTo.setName(scanner.nextLine());

        if (route.getKey() == null){
            route.setKey(route.getName());
        }


        while (true) {
            try {
                System.out.print("    Введите x: ");
                Float x = Float.parseFloat(scanner.nextLine());
                locationTo.setX(x);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести число.");
            }
        }

        while (true) {
            try {
                System.out.print("    Введите y: ");
                Integer y = Integer.parseInt(scanner.nextLine());    //такую же херню с интами
                locationTo.setY(y);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число.");
            }
        }

        while (true) {
            try {
                System.out.print("    Введите z: ");
                int z = Integer.parseInt(scanner.nextLine());    //такую же херню с интами
                locationTo.setZ(z);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число.");
            }
        }
        route.setTo(locationTo);
        //System.out.println("");


        System.out.println("Введите, откуда вы добираетесь: ");
        System.out.println("Введите название: ");
        locationFrom.setName(scanner.nextLine());
        while (true) {
            try {
                System.out.print("    Введите x: ");
                Float x = Float.parseFloat(scanner.nextLine());
                locationFrom.setX(x);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести число.");
            }
        }


        while (true) {
            try {
                System.out.print("    Введите y: ");
                Integer y = Integer.parseInt(scanner.nextLine());    //такую же херню с интами
                locationFrom.setY(y);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число.");
            }
        }
        while (true) {
            try {
                System.out.print("    Введите z: ");
                int z = Integer.parseInt(scanner.nextLine());    //такую же херню с интами
                locationFrom.setZ(z);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число.");
            }
        }

        route.setFrom(locationFrom);

        while (true) {
            try {
                System.out.print("    Введите расстояние: ");
                Double s = Double.parseDouble(scanner.nextLine());    //такую же херню с интами
                route.setDistance(s);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести число.");
            }
        }


        collectionManager.addToCollection(route);
        System.out.println("Добавлен в коллекцию!");





    }


}
