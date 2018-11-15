package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "goods_image")
@Getter
@Setter
public class GoodsImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45)
    private String fileName;
    private Long fileSize;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;
}
