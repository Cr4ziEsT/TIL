package examples.spring.demowebmvc.quiz;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstQuizController {

    @GetMapping("/events")
    public String events() {
        return "events";
    }

    @GetMapping("/evnets/{id}")
    public String getAnEvents(@PathVariable Long id) {
        return "event";
    }

    @DeleteMapping("/events/{id}")
    public String deleteEvent(@PathVariable Long id) {
        return "event";
    }
}
