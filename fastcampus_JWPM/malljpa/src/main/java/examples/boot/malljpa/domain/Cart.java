package examples.boot.malljpa.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cart")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int count;
    private Date expiration;
    private int totalPrice;

    @OneToMany
    @JoinColumn(name = "goods_id")
    private Set<Goods> goods;

    @OneToMany(mappedBy = "cart")
    private Set<CartGoods> cartGoods;

    @OneToOne(mappedBy = "cart")
    private Member member;
}
