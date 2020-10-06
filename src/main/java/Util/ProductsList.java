package Util;

import ProductEntityes.Product;

import java.util.HashMap;
import java.util.Scanner;

public class ProductsList { //синголтон
    private static HashMap<Integer, Product> productList;//список продуктов
    private ProductsList(){}; //запрещаем создание экземпляра класса
    public static HashMap<Integer, Product> getScanner() {
        if (productList == null) {
            productList = new HashMap<>();
        }
        return productList;
    }
}
