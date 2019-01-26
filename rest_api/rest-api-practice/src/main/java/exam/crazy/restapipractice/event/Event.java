package exam.crazy.restapipractice.event;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

// @Data 라는 어노테이션은 아래의 어노테이션들(@Getter, @Setter, @EqualsAndHashCode)을 구현하는데
// 이러면 엔티티 간에 상호 참조하는 관계가 되어 스택오버플로우가 발생할 여지가 있기 때문에 적어도 Entity 위에는 적어주지 않는 것이 바람직하다.

@Builder @AllArgsConstructor @NoArgsConstructor     // 기본 생성자와 모든 아규먼트를 가지고 있는 생성자를 만들기 위함
@Getter @Setter @EqualsAndHashCode(of = "id") // (of = {"id", "account"}) 이런식으로도 가능하다.
// Equals 와 HashCode 를 구현할 때 모든 필드를 다 사용한다.
// 그런데 객체 간에 연관관계가 있을 때 서로 상호 참조하는 관계가 돼버리면 Equals 와 HashCode 를 구현한 객체 안에서 스택오버플로우가 발생할 수 있다.
// 그래서 id의 값만 가지고 equals 와 hashcode 를 비교하도록 만든 것
@Entity
public class Event {

    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location; // (optional) 이게 없으면 온라인 모임
    private int basePrice; // (optional)
    private int maxPrice;  // (optional)
    private int limitOfEnrollment;
    private boolean offline;
    private boolean free;
    @Enumerated(EnumType.STRING)    // 권장
    private EventStatus eventStatus = EventStatus.DRAFT;
}
