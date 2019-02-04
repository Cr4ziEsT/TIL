package examples.spring.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String eventsForm(Model model) {
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent); // form backing object
        return "/events/form";
    }

    @PostMapping("/events")
    @ResponseBody
    public Event getEvent(@RequestParam String name,
                          @RequestParam Integer limit){
//    public Event getEvent(@RequestParam(required = false, defaultValue = "keesun") String name){
        Event event = new Event();
        event.setName(name);
        event.setLimit(limit);
        return event;
    }
}
