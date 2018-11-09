package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    UI ui() { return new UI(); }

    @Bean
    Control control(UI ui){
        Control control = new Control();
        control.setUI(ui);
        return control;
    }
}
