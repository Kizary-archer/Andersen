package ProductEntityes;

import ProductEntityes.Interfaces.Smartphone;

public class SamsungSmartphone implements Smartphone {

    String model;
    int price;
    final String manufactory = "Samsung";

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getManufactory() {
        return manufactory;
    }
}
