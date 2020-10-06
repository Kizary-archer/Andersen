package Util;

import java.util.HashMap;
import java.util.Scanner;

public class ProductsList {
    private static HashMap<Integer,> productList = new HashMap();

    private ProductsList(){

    };
    public static Scanner getScanner() {
        if (scanner == null) {
            Scanner scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
