package examples.daoexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    public MainController() {
        System.out.println("MainController()!");
    }

    // http://localhost:8080    <-  / 에 대한 요청
    @RequestMapping("/")            // 빈으로 만들어지고 이 Dispatcher Servlet 는 이것을 가지고 있는 에노테이션 정보를 다 읽어들인다.
                                    // 현재 이것은 / 에 대한 요청은 이 메서드가 다 처리한다는 의미를 가지고 있음.
    public String main() {
        return "index";             // view name을 리턴, /WEB-INF/views/index.jsp로 forward 한다는 뜻!
    }
}
