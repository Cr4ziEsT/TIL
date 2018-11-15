package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attention")
@Getter
@Setter
public class Attention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int count;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToMany
    @JoinTable(name = "attention_goods",
                joinColumns = @JoinColumn(name = "attention_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "goods_id", referencedColumnName = "id"))
    private Set<Goods> goods;
}
