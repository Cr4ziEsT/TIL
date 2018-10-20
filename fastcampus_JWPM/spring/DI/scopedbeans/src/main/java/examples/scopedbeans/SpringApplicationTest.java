package examples.scopedbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationTest {
    public static void main(String[] args){
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("scoped-beans.xml");
        System.out.println("---------------");

        // xml에 설정해놓은 코드를 바탕으로 객체를 생성한다.
        Notepad notepad1 = applicationContext.getBean(Notepad.class);
        Notepad notepad2 = applicationContext.getBean(Notepad.class);

        System.out.println("---------------");

        UniqueThing uniqueThing1 = applicationContext.getBean(UniqueThing.class);
        UniqueThing uniqueThing2 = applicationContext.getBean(UniqueThing.class);
    }
}
