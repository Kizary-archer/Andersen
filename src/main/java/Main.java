import ProductBuilders.Builder;
import ProductBuilders.TVBuilder;
import ProductEntityes.Interfaces.TV;
import ProductFactory.ProductFactory;
import ProductFactory.AppleFactory;

public class Main {
    public static void main(String[] args) {

       ProductFactory productFactory = new AppleFactory();
       TV tv = productFactory.createTV();
        Builder builder = new TVBuilder(tv);
        builder.setPrise(500);
        builder.setModel("sasasa");
        builder.build();
        tv.getModel();
        System.out.println(tv.getModel() + tv.getPrice());
    }
}
