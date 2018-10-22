package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* ApplicationContext에 대한 API 알아보기
이것은 인터페이스이므로 인스턴스가 될 수 없으므로 인터페이스를 구현하고 있는 객체를 사용한다.
그 중에서 ClassPathXMLApplicationContext : ClassPath에서 XML을 찾아서 ApplicationContext로 읽어들인다.
        AnnotationConfigApplicationContext : Java Config를 이용해서 객체를 생성한다.
*/
public class SpringExam05 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DiceConfig.class);
    }
}
