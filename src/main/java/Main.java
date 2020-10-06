import Factory.ProductFactory;
import Factory.SmartphoneFactory;
import ProductEntityes.Microphone;
import ProductEntityes.Product;

public class Main {
    public static void main(String[] args) {

        ProductFactory productFactory = new SmartphoneFactory();
        productFactory.createProduct();
        Product product = productFactory.createProduct();
        product.setManufacture("dvdvsdv");
        System.out.println(product.getManufacture());
    }
}
