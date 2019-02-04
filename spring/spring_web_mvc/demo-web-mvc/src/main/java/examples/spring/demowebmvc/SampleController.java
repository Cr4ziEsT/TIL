package examples.spring.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public String createEvent(@Validated @ModelAttribute Event event, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "/events/form";
        }

        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model) {
        List<Event> eventList = new ArrayList<>();
        Event event = new Event();
        event.setLimit(10);

        event.setName("spring");
        eventList.add(event);

        model.addAttribute(eventList);

        return "/events/list";
    }
}
