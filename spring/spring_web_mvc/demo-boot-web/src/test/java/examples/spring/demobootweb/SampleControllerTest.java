package examples.spring.demobootweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ObjectMapper objectMapper; // `SpringBoot`는 이미 `ObjectMapper`가 `Bean`으로 등록이 되어 있다.

    @Test
    public void hello() throws Exception {
        Person person = new Person();
        person.setName("keesun");
        Person savedPerson = personRepository.save(person);

        this.mockMvc.perform(get("/hello")
                    .param("id", savedPerson.getId().toString()))
                .andDo(print())
                .andExpect(content().string("hello keesun"));
    }

    @Test
    public void helloStatic() throws Exception {
        this.mockMvc.perform(get("/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("hello index")))
        ;
    }

    @Test
    public void helloStatic2() throws Exception {
        this.mockMvc.perform(get("/mobile/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("Hello Mobile")))
                .andExpect(header().exists(HttpHeaders.CACHE_CONTROL))
        ;
    }

    @Test
    public void stringMessage() throws Exception {
        this.mockMvc.perform(get("/message")
                    .content("hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void jsonMessage() throws Exception {
        Person person = new Person();
        person.setId(2019L);
        person.setName("keesun");

        String jsonString = objectMapper.writeValueAsString(person);    // 만든 객체를 Json 문자열로 변경

        this.mockMvc.perform(get("/jsonMessage")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)   // 내가 본문에 보내는 정보가 어떠한 타입인지를 서버에 알려줌
                    .accept(MediaType.APPLICATION_JSON_UTF8)        // 요청에 대한 응답으로 어떠한 타입의 데이터를 원한다!!
                    .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk());
    }

}