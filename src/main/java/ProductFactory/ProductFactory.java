package ProductFactory;

import ProductEntityes.Interfaces.Smartphone;
import ProductEntityes.Interfaces.TV;

public interface ProductFactory {

    Smartphone createSmartphone();
    TV createTV();
}
