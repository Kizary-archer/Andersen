package Util;

import ProductEntityes.Product;

import java.util.HashMap;

public class ProductList { //синглтон
    private static HashMap<String, Product> productList;//список продуктов
    private ProductList(){}; //запрещаем создание экземпляра класса
    public static HashMap<String, Product> getProductList() {
        if (productList == null) {
            productList = new HashMap<>();
        }
        return productList;
    }
}
