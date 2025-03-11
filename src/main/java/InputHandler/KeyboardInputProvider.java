package InputHandler;

import java.util.Scanner;

public class KeyboardInputProvider implements InputProvider {
    private final Scanner scanner = new Scanner(System.in);

    public KeyboardInputProvider() {}

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    @Override
    public int readInt(String prompt, int minValue) {
        while (true) {
            try {
                System.out.println(prompt);
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value < minValue) {
                    System.out.println("Значение должно быть не меньше " + minValue);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число.");
            }
        }
    }

    @Override
    public long readLong(String prompt, long minValue) {
        while (true) {
            try {
                System.out.println(prompt);
                long value = Long.parseLong(scanner.nextLine().trim());
                if (value < minValue) {
                    System.out.println("Значение должно быть не меньше " + minValue);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число.");
            }
        }
    }

    @Override
    public float readFloat(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return Float.parseFloat(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести число.");
            }
        }
    }

    @Override
    public double readDouble(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести число.");
            }
        }
    }
}