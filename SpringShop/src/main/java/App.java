package main.java;


import main.java.app.Util.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = SpringConfig.getContext();
    }
}
