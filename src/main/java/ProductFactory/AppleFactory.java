package ProductFactory;

import ProductEntityes.AppleSmartphone;
import ProductEntityes.AppleTV;
import ProductEntityes.Interfaces.Smartphone;
import ProductEntityes.Interfaces.TV;

public class AppleFactory implements ProductFactory {
    @Override
    public Smartphone createSmartphone() {
        return new AppleSmartphone();
    }
    @Override
    public TV createTV() {
        return new AppleTV();
    }
}
