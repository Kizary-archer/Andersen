package ProductEntityes;

import ProductEntityes.Interfaces.TV;

public class AppleTV implements TV {

    String model;
    int price;

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
    public void setPrice(int price) {this.price = price;}
}
