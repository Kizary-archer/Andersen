package ProductEntityes;

import ProductEntityes.Interfaces.Smartphone;

public class AppleSmartphone implements Smartphone {

    String model;
    int price;
    public AppleSmartphone(){};

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

    }
}
