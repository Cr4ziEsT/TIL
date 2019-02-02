package examples.spring.demobootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GreetingInterceptor()).order(0);
        registry.addInterceptor(new AnotherInterceptor())
                .addPathPatterns("/hi/**")
                .order(-1);
        // `order`를 설정하지 않으면 적은 순서대로 실행이 됨
        // `order`의 값은 낮을수록 우선순위가 높다.
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mobile/**")
                .addResourceLocations("classpath:/mobile/", "file:/Users/keesun/files/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES))
//                .resourceChain(true)    // 운영중이라면 true 개발중이라면 false 가 편할 것
                // Transformer / Resolver
                // Resolver : 어떤 요청에 해당하는 리소스를 찾는 것
                // Transformer : 응답으로 내보낼 그 리소스를 변경하는 방법
        ;
    }
}
