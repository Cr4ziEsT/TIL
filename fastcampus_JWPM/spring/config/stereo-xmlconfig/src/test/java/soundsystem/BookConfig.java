package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "soundsystem.book")
// @ComponentScan : 특정 패키지 이하에서 @Component와 관련된 @이 붙어있는 클래스를 메모리에 빈으로 등록,
// JavaConfig 설정과 Xml 설정보다 편하다.(but 내가 만든 클래스에는 @Componet를 붙일 수 있지만 내가 만든 클래스가 아닌 것은 @Bean 으로 객체를 Bean으로 등록하는 행위가 필요하다.)
public class BookConfig {
}

/*
의존성 주입 방법에는 설정자 주입, 생성자 주입, 필드 주입이 있다.
-> 필드 주입 방법의 단점과 장점
-> 필드 주입 방법 vs 생성자 주입 방법점 어떤 것을 사용해야 하는가
-> 생성자 주입 방법과 설정자 주입 방법의 차이
 */
