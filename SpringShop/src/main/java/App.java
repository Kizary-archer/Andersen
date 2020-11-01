package main.java;

import main.java.app.Entities.ManufactureEntity;
import main.java.app.Util.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = SpringConfig.getContext();
        ManufactureEntity manufactureEntity = context.getBean("manufactureEntity",ManufactureEntity.class);
        ManufactureEntity manufactureEntity2 = context.getBean("manufactureEntity",ManufactureEntity.class);
        manufactureEntity.setNamemanuf("111");
        System.out.println(manufactureEntity.getNamemanuf());
        manufactureEntity2.setNamemanuf("222");
        System.out.println(manufactureEntity.getNamemanuf());
        System.out.println(manufactureEntity2.getNamemanuf());
    }
}