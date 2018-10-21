package my.examples.studentmanagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("stdmanage.xml");
        MainController mainController = context.getBean( MainController.class);
        mainController.controller();
    }
}
