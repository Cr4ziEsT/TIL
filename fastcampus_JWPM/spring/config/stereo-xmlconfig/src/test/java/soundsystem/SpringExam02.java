package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam02 {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("exam02.xml");
        System.out.println("ApplicationContext 생성 이후");

        // MyBean 클래스 타입의 bean id가 bean1 인 Bean을 요청한다.(이 방법이 더 정확한 Bean을 얻어올 수 있다.)
        MyBean bean1 = context.getBean("bean1", MyBean.class);
        System.out.println(bean1.getName());
        System.out.println(bean1.getCount());

        MyBean bean2 = context.getBean("bean1", MyBean.class);

        if(bean1 == bean2){     // 같은 객체를 참조하고 있는지 확인
            System.out.println("bean1 == bean2");
        }else{                  // scope이 prototype일 경우에는 매번 인스턴스를 생성한다.(default : 싱글턴)
            System.out.println("bean1 != bean2");
        }

        MyBean bean3 = context.getBean("bean2", MyBean.class);
        System.out.println(bean3.getName() + ", " + bean3.getCount());

        MyBean bean4 = context.getBean("bean3", MyBean.class);
        System.out.println(bean4.getValue("a1"));
    }
}
