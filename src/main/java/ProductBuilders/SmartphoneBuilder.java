package ProductBuilders;

import ProductEntityes.Interfaces.Smartphone;

public class SmartphoneBuilder implements Builder<Smartphone> {

    Smartphone smartphone;

    public SmartphoneBuilder(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    @Override
    public void setModel(String model) {
        smartphone.setModel(model);
    }

    @Override
    public void setPrise(int prise) {

        smartphone.setPrice(prise);

    }

    @Override
    public Smartphone build() {
        return smartphone;
    }

}
