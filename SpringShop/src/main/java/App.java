
import app.Entities.ManufactureEntity;

import app.config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ManufactureEntity manufactureEntity = context.getBean("manufactureEntity",ManufactureEntity.class);
        ManufactureEntity manufactureEntity2 = context.getBean("manufactureEntity",ManufactureEntity.class);
        manufactureEntity.setNamemanuf("111");
        System.out.println(manufactureEntity.getNamemanuf());
        manufactureEntity2.setNamemanuf("222");
        System.out.println(manufactureEntity.getNamemanuf());
        System.out.println(manufactureEntity2.getNamemanuf());
    }
}
