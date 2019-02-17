package examples.spring.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("event")
public class SampleController {

    @GetMapping("/events/form/name")
    public String eventsFormName(Model model) {
        model.addAttribute("event", new Event()); // form backing object
        return "/events/form-name";
    }

    @PostMapping("/events/form/name")
    public String eventsFormNameSubmit(@Validated @ModelAttribute Event event,
                              BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "/events/form-name";
        }
        return "redirect:/events/form/limit";
    }

    @GetMapping("/events/form/limit")
    public String eventsFormLimit(@ModelAttribute Event event, Model model) {
        model.addAttribute("event", event); // form backing object
        return "/events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String eventsFormLimitSubmit(@Validated @ModelAttribute Event event,
                                        BindingResult bindingResult,
                                        SessionStatus sessionStatus,
                                        RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "/events/form-limit";
        }

        sessionStatus.setComplete();
        attributes.addAttribute("name", event.getName());
        attributes.addAttribute("limit", event.getLimit());
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(@RequestParam String name,
                            @RequestParam Integer limit,
                            Model model,
                            @SessionAttribute LocalDateTime visitTime) {
        System.out.println(visitTime);

        Event newEvent = new Event();
        newEvent.setName("spring");
        newEvent.setLimit(10);

        List<Event> eventList = new ArrayList<>();
        Event event = new Event();
        eventList.add(event);
        eventList.add(newEvent);

        event.setName("spring");
        eventList.add(event);

        model.addAttribute(eventList);

        return "/events/list";
    }
}
