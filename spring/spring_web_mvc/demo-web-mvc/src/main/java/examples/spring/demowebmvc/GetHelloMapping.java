package examples.spring.demowebmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD) // 해당 어노테이션을 어디에서 사용할 수 있는지를 결정
// RUNTIME : Annotation 이 RUNTIME 때 까지 유지되기를 원한다.
@Retention(RetentionPolicy.RUNTIME)    // 해당 Annotation 정보를 언제까지 유지할 것인가를 설정할 수 있다.(기본값 class)
@RequestMapping(method = RequestMethod.GET, value = "hello")
public @interface GetHelloMapping {
}
