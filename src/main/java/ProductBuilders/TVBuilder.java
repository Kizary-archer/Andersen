package ProductBuilders;

import ProductEntityes.Interfaces.Smartphone;
import ProductEntityes.Interfaces.TV;

public class TVBuilder implements Builder<TV> {

    TV tv;
    String model;
    int price;

    public TVBuilder(TV tv) {
        this.tv = tv;
    }

    @Override
    public void setModel(String model) {

        tv.setModel(model);
    }

    @Override
    public void setPrise(int prise) {

        tv.setPrice(prise);
    }

    @Override
    public TV build() {
        return tv;
    }

}
