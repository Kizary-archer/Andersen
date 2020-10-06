package Factory;

import ProductEntityes.Product;
import ProductEntityes.Smartphone;

public class SmartphoneFactory extends ProductFactory {
    @Override
    public Product createProduct() {
        return new Smartphone();
    }
}
