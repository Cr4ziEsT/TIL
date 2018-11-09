package soundsystem.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    // 2. 필드 기반 의존성 주입 방법
    @Autowired
    private BookDao bookDao;

    // 1. 생성자 기반 의존성 주입 방법
//    private BookDao bookDao;
//
//    public BookService(BookDao bookDao){
//        this.bookDao = bookDao;
//        System.out.println("BookService()");
//    }

    public void service(){ bookDao.crud(); }
}
