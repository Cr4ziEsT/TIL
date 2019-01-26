package exam.crazy.restapipractice.event;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.Errors;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Controller
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_UTF8_VALUE)   // 해당 클래스 안에 있는 모든 핸들러들은 HAL_JSON_UTF8_VALUE 응답을 보내게 됨
public class EventController {

    private final EventRepository eventRepository;

    private final ModelMapper modelMapper;

    public EventController(EventRepository eventRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity createEvent(@RequestBody @Valid EventDto eventDto, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        // `Entity`와 `DTO`를 분리시켰을 때 `DTO`로 받아온 값을 `Entity`로 옮겨줘야 한다.
//        Event event = Event.builder().name(eventDto.getName()).description().....build();

        // 위와 같은 방법을 생략할 수 있는 방법이 `ModelMapper`를 사용하는 것이다.
        // 이때 리플렉션이 발생하여 직접 일일이 작성하는 것보다는 성능이 떨어지지만 자바 성능이 올라갈수록 성능이 좋아졌기때문에 크게 우려할 점은 아니다.
        Event event = modelMapper.map(eventDto, Event.class);

        Event newEvent = this.eventRepository.save(event);

        URI createUri = linkTo(EventController.class).slash(newEvent.getId()).toUri();
        return ResponseEntity.created(createUri).body(event);
    }
}
