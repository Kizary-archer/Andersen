package ProductBuilders;

import ProductEntityes.Smartphone;

public class SmartphoneBuilder implements Builder<Smartphone> {

    Smartphone smartphone;

    public SmartphoneBuilder(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    @Override
    public void setManufactore(String manufacture) {
        smartphone.setManufacture(manufacture);
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
    public void setDiagonal(Integer diagonal) {
        smartphone.setDiagonal(diagonal);
    }

}
