package App;

import ConsoleCommand.*;
import ProductBuilders.Builder;
import ProductBuilders.SmartphoneBuilder;
import ProductEntityes.Interfaces.Smartphone;
import ProductFactory.*;

public class App {

    public static void main(String[] args) {
        ConsoleCommands cm = new ConsoleCommands();
        ConsoleRun console = new ConsoleRun(
                new addCommand(cm),
                new delCommand(cm),
                new listCommand(cm)
        );
        ProductFactory productFactory = new AppleFactory();
        Smartphone smartphone = productFactory.createSmartphone();
        Builder<Smartphone> builder = new SmartphoneBuilder(smartphone);
        builder.setModel("sdvv");
        builder.setPrise(323);
        builder.build();
        smartphone.getModel();
        smartphone.getPrice();
        console.addProduct();
    }
}
