package ConsoleCommand;

import Util.ConsoleFactoryUtil;

import java.util.Scanner;

public class ConsoleCommands {

    private final Scanner scanner = ConsoleFactoryUtil.getScanner();

    public void add() {
        System.out.println("add");
    }

    public void del() {
        System.out.println("del");
    }

    public void list() {
        System.out.println("list");
    }
}
