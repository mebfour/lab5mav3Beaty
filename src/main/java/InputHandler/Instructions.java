package InputHandler;
import Service.CommandManager;
import java.util.Scanner;


public class Instructions {
    public static void greeting(String args){
        System.out.println("Добрый вечер!");
        System.out.println("Давайте же начнем это увлекательное и, надеюсь, успешное путешествие в мир моей 5й лабораторной");
        System.out.println("Данные загружены из файла " + args);
        System.out.println("Введите команду");
        System.out.println("P.S. Если Вы не знаете, какую команду ввести, наберите \"help\" ");

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите команду: ");
            String inputComm = scanner.nextLine();
            CommandManager.checkComm(inputComm);

        }
    }
}
