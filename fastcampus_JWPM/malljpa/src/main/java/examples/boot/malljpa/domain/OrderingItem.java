package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ordering_item")
@Getter
@Setter
public class OrderingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int count;
    private int money;

    @OneToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;

    @ManyToOne
    @JoinColumn(name = "ordering_id")
    private Ordering ordering;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
