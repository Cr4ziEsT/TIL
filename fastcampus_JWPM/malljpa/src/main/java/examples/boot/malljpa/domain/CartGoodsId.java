package examples.boot.malljpa.domain;

import java.io.Serializable;

public class CartGoodsId implements Serializable {
    private Long cart;
    private Long goods;

    public CartGoodsId(Long cart, Long goods){
        this.cart = cart;
        this.goods = goods;
    }
}
