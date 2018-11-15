package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "event")
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45)
    private String name;
    @Column
    @CreationTimestamp
    private LocalDateTime startDate;
    @UpdateTimestamp
    private LocalDateTime endDate;
    private boolean status;

    @ManyToMany
    @JoinTable(name = "event_goods",
                joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "goods_id", referencedColumnName = "id"))
    private Set<Goods> goods;
}
