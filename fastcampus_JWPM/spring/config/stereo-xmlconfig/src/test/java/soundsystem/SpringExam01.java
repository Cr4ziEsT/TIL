package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam01 {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("exam01.xml");

        // Spring은 기본적으로 객체를 싱글턴으로 관리한다.
        // 실행 시 exam01.xml에 등록된 bean1, bean2가 먼저 객체로 생성되는 것을 알 수 있다.
        // 이렇게 생성된 객체를 getBean("id")를 통해서 요청해서 사용한다.
        MyBean bean1 = (MyBean)context.getBean("bean1");
        bean1.setName("홍길동");

        // 따라서 bean id가 bean1인 객체를 다른 변수로 요청해도 이미 생성된 객체를 참조하게 된다.
        // 그러므로 이전 bean1 변수가 참조하는 객체에 설정했던 이름("홍길동")을 얻어온 것을 확인할 수 있다.
        MyBean bean2 = (MyBean)context.getBean("bean1");
        System.out.println(bean2.getName());

        // MyBean 클래스 타입의 빈을 요청한다. 해당 클래스 타입의 빈이 1개일 경우에만 오류가 발생하지 않는다.
        // 오류 : NoUniqueBeanDefinitionException     -> exam01.xml 파일에서 MyBean 클래스가 가지고 있는 Bean을 1개로 만든다.
//        MyBean bean5 = context.getBean(MyBean.class);
//        System.out.println(bean5.getName());

        // bean id가 bean2인 빈을 요청한다.
        MyBean bean3 = (MyBean)context.getBean("bean2");
        System.out.println(bean3.getName());

        // bean3 라는 id의 빈은 설정되어 있지 않기 때문에 Exception이 발생한다.
        // NoSuchBeanDefinitionException
//        MyBean bean4 = (MyBean)context.getBean("bean3");
//        System.out.println(bean4.getName());
    }
}
