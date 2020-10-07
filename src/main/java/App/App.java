package App;

import ConsoleCommand.*;
import Util.ScannerFactoryUtil;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ConsoleCommands cm = new ConsoleCommands();
        ConsoleRun console = new ConsoleRun(
                new addCommand(cm),
                new delCommand(cm),
                new listCommand(cm)
        );

            try (Scanner scanner = ScannerFactoryUtil.getScanner()) {
                while (true) {
                    System.out.println("Выберите действие:\n0)Завершить работу\n1)Добавить продукт\n2)Удалить продукт\n3)Список продуктов");
                    switch (scanner.nextInt()) {
                        case 0:
                            return;
                        case 1:
                            console.addProduct();
                            break;
                        case 2:
                            console.delProduct();
                            break;
                        case 3:
                            console.listProduct();
                            break;
                        default:
                            System.out.println("введённого продукта не существует");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

    }
}

