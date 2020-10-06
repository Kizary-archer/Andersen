package Factory;

import ProductEntityes.Microphone;
import ProductEntityes.Product;

public class MicrophoneFactory extends ProductFactory {
    @Override
    public Product createProduct() {
        return new Microphone();
    }
}
