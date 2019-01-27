package exam.crazy.restapipractice.event;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/* 방법 2
* Resource<T> 에 @JsonUnwrapped 가 이미 붙어 있어 아래와 같이 만들면 간편하게 할 수 있다.
* */
public class EventResource extends Resource<Event> {

    public EventResource(Event event, Link... links) {
        super(event, links);
//        add(new Link("http://localhost:8080/api/events/" + event.getId()));  --> TypeSafe 하지 않음
        add(linkTo(EventController.class).slash(event.getId()).withSelfRel());
    }
}

/* 방법 1
// `EventResource`를 `ObjectMapper`가 컨버팅을 함, `ObjectMapper`가 이것을 `Serializer`을 할 때 `BeanSerializer`를 사용한다.
public class EventResource extends ResourceSupport {
    // `BeanSerializer`는 기본적으로 필드 이름을 사용하는데 `Event`는 다른 필드들을 여러 개 갖고 있는 `Composite` 객체이기 때문에 `event` 필드명 안에 모두 넣어준다.
    // 따라서 `event`에 감싸져서 나오지 않도록 하기 위해 `@JsonUnwrapped`를 사용한다.
    @JsonUnwrapped
    private Event event;

    public EventResource(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }
}
*/