

import javax.crypto.spec.PSource;
import java.io.InputStream;
import java.util.Scanner;

public class TestClass {

    int x;
    int y;

    public int mult(){
        return x*y;
    }

    private InputStream inputStream;
    public String[] readTerminal(){
        Scanner scanner = new Scanner(inputStream);
        String readline = scanner.nextLine();

        if (readline.contains(" ")){
            return readline.split(" ");
        }else {
            return new String[]{readline, ""};
        }
    }
    static TestClass testClass = new TestClass();
    static String[] readLine = testClass.readTerminal();

    public static void main(String[] args) {
        System.out.println(readLine[0]);
    }

}
