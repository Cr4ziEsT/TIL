package examples.daoexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller     // 들어가보면 @component가 붙어있다. 따라서 ComponentScan에서 이 객체가 Bean으로 등록되고 메모리에 올라간다.
public class MainController {
    public MainController() {
        System.out.println("MainController()!");
    }

    //
    @RequestMapping("/")            // RequestMapping 이라고 붙어있는 애노테이션은
                                    // MainController 객체가 빈으로 만들어지고 DispatcherServlet이 @RequestMapping이 붙어있는 정보를 다 읽어들인다.(메소드마다 붙을 수 있다. 여러개 존재 가능)
    // 현재 이것은 / 에 대한 요청이 오면 index라는 viewname을 리턴해준다. (/ 요청은 이 메서드가 처리한다는 의미를 가지고 있음.)
    // / 에 대한 요청이란? -> http://localhost:8080

    public String main(ModelMap modelMap) {
//        Set<String> keys = modelMap.keySet();
//        for (String key : keys) {
//            System.out.println("key :" + key + ", value :" + modelMap.get(key));
//        }
        return "index";             // viewname을 리턴, 실제로는 /WEB-INF/views/index.jsp로 forward 한다는 뜻!
    }
}
