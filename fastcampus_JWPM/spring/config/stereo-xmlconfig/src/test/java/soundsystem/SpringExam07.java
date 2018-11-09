package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import soundsystem.book.BookService;

public class SpringExam07 {
    public static void main(String[] args) throws Exception{
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BookConfig.class);
        BookService bookService = applicationContext.getBean(BookService.class);    // BookService에 해당하는 클래스를 Bean으로 받는다.
        bookService.service();
    }
}
