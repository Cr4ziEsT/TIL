package examples.spring.demobootweb;

import org.springframework.web.bind.annotation.*;

@RestController     // @RestController : 모든 핸들러 메서드에 @ResponseBody 가 자동으로 붙게 됨
public class SampleController {
    // 핸들러 인터셉터
    // preHandle 1
    // preHandle 2
    // 요청 처리
    // postHandler 2
    // postHandler 1
    // 뷰 랜더링
    // afterCompletion 2
    // afterCompletion 1

    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person) {
        return "hello " + person.getName();
    }

    @GetMapping("/message")
//    @ResponseBody     // @ResponseBody : 리턴 값을 응답의 본문으로 넣어준다. RestController 가 있다면 생략 가능
    public String message(@RequestBody String body) {
        // @RequestBody : 요청 본문에 들어있는 메세지를 HTTP Message 컨버터를 사용해서 컨버젼한다.
        return body;
    }

    @GetMapping("/jsonMessage")
    public Person jsonMessage(@RequestBody Person person) {
        return person;
    }
}
