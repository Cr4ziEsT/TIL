package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "ordering")
@Getter
@Setter
public class Ordering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String code;
    private int money;
    private int discountMoney;
    private int point;
    private int count;
    @Column
    @CreationTimestamp
    private LocalDateTime orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "ordering")
    private Set<OrderingItem> orderingItems;

    @OneToOne
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
