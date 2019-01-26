package exam.crazy.restapipractice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApiPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiPracticeApplication.class, args);
    }

    // `ModelMapper`는 공용으로 쓸 수 있는 객체이기 때문에 `Bean`으로 등록해준다
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

