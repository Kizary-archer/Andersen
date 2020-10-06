package Util;

import java.util.Scanner;

public class ConsoleFactoryUtil {
    private static Scanner scanner;

    private ConsoleFactoryUtil(){};
    public static Scanner getScanner() {
        if (scanner == null) {
            Scanner scanner = new Scanner(System.in);
        }
        return scanner;
    }
}