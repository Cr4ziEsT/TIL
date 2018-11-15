package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "claim")
@Getter
@Setter
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45, nullable = false)
    private String type;
    @Column(length = 45, nullable = false)
    private String cause;

    @OneToOne(mappedBy = "claim")
    private OrderingItem orderingItem;
}
