package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_info")
@Getter
@Setter
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45, nullable = false)
    private String code;
    private Date date;
    @Column(nullable = false)
    private int price;
    private int discount;
    private int point;
    private int goodsCount;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
