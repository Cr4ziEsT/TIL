package examples.spring.demowebmvc.quiz;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,        // JSON 데이터를 받을거야
                produces = MediaType.APPLICATION_JSON_VALUE)        // JSON 데이터로 응답할래
public class FirstQuizUpdateController {

    @PostMapping("/events")
    public String createEvent() {
        return "event";
    }

    @PutMapping(value = "/events/{id}")
    public String putEvent(@PathVariable Long id) {
        return "evnet";
    }
}
