package exam.crazy.restapipractice.event;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Component
public class EventValidator {

    public void validate(EventDto eventDto, Errors errors) {
        if (eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() != 0) {
            errors.reject("wrongPrices", "Values fo price are wrong"); // Global Error
        }

        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        // 이벤트가 끝나는 날짜가 이벤트의 시작일, 접수종료일, 접수시작일 이전이면 안 됨
        if (endEventDateTime.isBefore(eventDto.getBeginEventDateTime()) ||
        endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime()) ||
        endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime())) {
            errors.rejectValue("endEventDateTime", "worngValue","EndEventDateTime is wrong");
        }

        // TODO BeginEventDateTime
        // TODO CloseEnrollmentDateTime
    }
}
