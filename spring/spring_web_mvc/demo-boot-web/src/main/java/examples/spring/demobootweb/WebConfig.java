package examples.spring.demobootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        // 포매터와 컨버터를 추가할 수 있다.
//        // 컨버터는 포매터보다 좀 더 일반적인 용도로 문자열이 아닌 일반적인 자바 객체에서 또 다른 일반적인 자바 객체로 변환할 수 있는 인터페이스
////        registry.addConverter();
//        registry.addFormatter(new PersonFormatter());
//    }
}
