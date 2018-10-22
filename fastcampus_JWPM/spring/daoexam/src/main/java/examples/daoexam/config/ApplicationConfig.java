package examples.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration  // 해당 클래스가 Java Config 임을 나타낸다.
@ComponentScan(basePackages = {"examples.daoexam.dao"})     // " " 패키지 이하에서 @Component 가 붙은 객체를 찾아 메모리에 올린다.

@Import({ DBConfig.class })     // 다른 Java Config 를 포함해서 읽어 들이겠다!!
                                // config 설정을 나누는 이유는 무엇에 대한 설정인지 구분지어 관리를 편하게 하기 위함!
public class ApplicationConfig {
}
