package exam.crazy.restapipractice.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;  // Mapping 잭슨, 제이슨이 의존성에 들어가 있으면 스프링부트에서 자동적으로 bean 으로 등록해줌

    @Test
    public void createEvent() throws Exception {
        EventDto event = EventDto.builder()
                .description("REST API Development with Spring")
                .beginEnrollmentDateTime(LocalDateTime.of(2018, 11, 23, 14, 21))
                .closeEnrollmentDateTime(LocalDateTime.of(2018, 11, 24, 14, 21))
                .beginEventDateTime(LocalDateTime.of(2018, 11, 25, 14, 21))
                .endEventDateTime(LocalDateTime.of(2018, 11, 26, 14, 21))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타텁 팩토리")
                .build();
//        Mockito.when(eventRepository.save(event)).thenReturn(event);    // Mock 객체이기 때문에 리턴되는 값이 전부 NULL 이다. 따라서 이와 같이 `Stubbing`을 해줘야 한다.
        // eventRepository 의 save 가 호출이 되면 event 를 리턴하라

        mockMvc.perform(post("/api/events/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)  // 요청의 본문에 JSON Data 를 담아서 보내고 있다.
                .accept(MediaTypes.HAL_JSON)                   // 응답으로는 HAL_JSON Data 를 받기를 원한다.
                .content(objectMapper.writeValueAsString(event))) // 데이터를 Json 으로 변경해줘야함
                .andDo(print())     // `Test`가 성공을 해도 결과를 확인하고 싶을 때 사용
                .andExpect(status().isCreated())                   // 201 응답이 나올거야!
                .andExpect(jsonPath("id").exists())    // id는 있어?
                .andExpect(header().exists(HttpHeaders.LOCATION))
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_UTF8_VALUE))
                .andExpect(jsonPath("id").value(Matchers.not(100)))     // 이 값은 들어오면 안 됨!
                .andExpect(jsonPath("free").value(Matchers.not(true)))  // 이 값은 들어오면 안 됨!
                .andExpect(jsonPath("eventStatus").value(EventStatus.DRAFT.name()))  // 처음 만드는 것은 DRAFT 임 .name()를 생략하면 `Test`가 깨짐
        ;
    }

    @Test
    public void createEvent_Bad_Request() throws Exception {
        Event event = Event.builder()
                .id(100)    // 이 입력값은 나오면 안됨!!
                .name("Spring")
                .description("REST API Development with Spring")
                .beginEnrollmentDateTime(LocalDateTime.of(2018, 11, 23, 14, 21))
                .closeEnrollmentDateTime(LocalDateTime.of(2018, 11, 24, 14, 21))
                .beginEventDateTime(LocalDateTime.of(2018, 11, 25, 14, 21))
                .endEventDateTime(LocalDateTime.of(2018, 11, 26, 14, 21))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타텁 팩토리")
                .free(true)     // 이 입력값은 나오면 안 됨!
                .offline(false) // 이 입력값은 나오면 안 됨!
                .eventStatus(EventStatus.PUBLISHED) // 이 입력값은 나오면 안 됨!
                .build();

        mockMvc.perform(post("/api/events/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)  // 요청의 본문에 JSON Data 를 담아서 보내고 있다.
                .accept(MediaTypes.HAL_JSON)                   // 응답으로는 HAL_JSON Data 를 받기를 원한다.
                .content(objectMapper.writeValueAsString(event))) // 데이터를 Json 으로 변경해줘야함
                .andDo(print())     // `Test`가 성공을 해도 결과를 확인하고 싶을 때 사용
                .andExpect(status().isBadRequest())                   // BadRequest(400) 응답이 나올거야!
        ;
    }

    @Test
    public void createEvent_Bad_Request_Empty_Input() throws Exception {
        EventDto eventDto = EventDto.builder()
                            .build();

        this.mockMvc.perform(post("/api/events")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)               // `JSON`으로 데이터를 보낸다.
                    .content(this.objectMapper.writeValueAsString(eventDto)))   // `eventDto Object`를 `JSON`으로 변환해서 `content`에 담는다.
                .andExpect(status().isBadRequest());
    }
}