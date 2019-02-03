package examples.spring.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    // Json 요청만을 처리하는 핸들러
    @RequestMapping(
            value = "/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
