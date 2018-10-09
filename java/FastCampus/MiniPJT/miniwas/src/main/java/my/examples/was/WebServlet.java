package my.examples.was;

import java.lang.annotation.*;

// 어노테이션 : 3.0 이전 버전에서는 web.xml에 서블릿에 대한 정보를 설정했는데 3.0 이상 버전부터는 클래스명 위에 설정할수 있게 되었다.
// 결국 어노테이션은 설정을 말하게 되는데 이렇게 설정한 정보를 was에서 읽어

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebServlet {
    String name() default "";

    String value() default "";

}
