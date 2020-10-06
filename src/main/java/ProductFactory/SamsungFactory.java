package ProductFactory;

import ProductEntityes.Interfaces.TV;
import ProductEntityes.SamsungSmartphone;
import ProductEntityes.Interfaces.Smartphone;
import ProductEntityes.SamsungTV;

public class SamsungFactory implements ProductFactory  {
    @Override
    public Smartphone createSmartphone() {

        return new SamsungSmartphone();
    }

    @Override
    public TV createTV() {
        return new SamsungTV();
    }
}
