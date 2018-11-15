package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cart_goods")
@IdClass(CartGoodsId.class)
@Getter
@Setter
public class CartGoods {
    @Id
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Id
    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    private int count;
}
