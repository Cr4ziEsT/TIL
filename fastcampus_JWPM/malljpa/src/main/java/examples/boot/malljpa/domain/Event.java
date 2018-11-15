package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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
    @Column(length = 45, nullable = false)
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean isProgress;

    @ManyToMany(mappedBy = "events")
    private Set<Item> items;
}
