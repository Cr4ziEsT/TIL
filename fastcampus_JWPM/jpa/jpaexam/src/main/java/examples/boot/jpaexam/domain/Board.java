package examples.boot.jpaexam.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sunny_board")
@Setter
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 20 not null
    @Column(nullable = false, length = 20)
    private String name;
    // 255 not null
    @Column(nullable = false, length = 255)
    private String title;
    // text not null
    @Lob
    private String content;
    private int readCount;
    // now()
    @Column
    @CreationTimestamp              // Entity에서 db에 있는 시간이 저장되게 하기 위함
    private LocalDateTime regDate;
    @Column
    @UpdateTimestamp
    private LocalDateTime updateDate;

    // WAS 안에 있는 시간이 저장된다.
//    public Board(){
//        regDate = LocalDateTime.now();
}

/*
@Entity
JPA에 있는 EntityManager에게 Board를 영속성(<->휘발성) 부여를 부탁받은 객체

영속성을 부여받은 객체는 @Entity, 클래스와 관계를 맺을 테이블에는 @Table(name = "sunny_board")
식별자 칼럼에는 @Id를 붙여준다.(자동으로 생성되게 하려면 @GeneratedValue(strategy = GenerationType.IDENTITY)

direlat
1차 캐시 -> JPA를 사용하면 성능이 좋은 이유, 같은 트랜잭션 안에서, 언제는 인설트가 바로 일어나고 언제는 끝날때 일어나고

게으른(레이직) 로딩 : 상속받고 있는 proxy 객체를 만들어서 proxy 객체를 리턴해준다

- 레이지 로딩 공부하기
- Entity 와 Entity 의 연관 관계(1:1, 1:m, m:n)
- 같은 트랜잭션 안에서의 1차 캐시, 스냅샷
 */