//import ConsoleCommand.Command;
//import ConsoleCommand.ConsoleCommands;
//import ConsoleCommand.listCommand;
//import ProductBuilders.Builder;
//import ProductBuilders.SmartphoneBuilder;
//import ProductEntityes.Interfaces.Smartphone;
//import ProductFactory.*;
//
//public class Main {
//    public static void main(String[] args) {
//
//        Command command = new listCommand(new ConsoleCommands());
//        command.execute();
//        ProductFactory productFactory = new AppleFactory();
//        Smartphone smartphone = productFactory.createSmartphone();
//        Builder builder = new SmartphoneBuilder(smartphone);
//        builder.setModel("sdvv");
//        builder.setPrise(323);
//        builder.build();
//        smartphone.getModel();
//        smartphone.getPrice();
//    }
//}
