package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "goods")
@Getter
@Setter
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int code;
    @Column(length = 45, nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    private int totalStock;
    @Lob
    private String information;
    private int maxPurchase;
    private int point;

    @OneToMany(mappedBy = "goods")
    private Set<CartGoods> cartGoods;

//    @ManyToMany(mappedBy = "goods")
//    private Set<Attention> attentions;

    @ManyToMany(mappedBy = "goods")
    private Set<Event> events;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "goods")
    private Set<GoodsImage> goodsImages;
}
