package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String code;
    @Column(length = 50, nullable = false)
    private String paymentType;
    @Column
    @CreationTimestamp
    private LocalDateTime paymentDate;

    @OneToOne(mappedBy = "payment")
    private Ordering ordering;
}
