package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 DB에 맡긴다.
    private Long id;
    @Column(length = 45, nullable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 45, nullable = false, unique = true)
    private String alias;
    @Column(length = 45, nullable = false)
    private String password;
    @Column(length = 13, nullable = false)
    private String phoneNumber;
    @Column(length = 45, nullable = false)
    private String address;
    @Column(length = 45, nullable = false)
    private String postalCode;
    private Long height;
    private Long weight;
    @Column(nullable = false)
    private Date birthDate;
    private int point;

    @ManyToOne
    @JoinColumn(name = "rating_id")
    private Rating rating;

    @OneToMany(mappedBy = "member")
    private Set<MemberCoupon> memberCoupons;

    @OneToMany(mappedBy = "member")
    private Set<Attention> attentions;

    @OneToMany(mappedBy = "member")
    private Set<OrderInfo> orderInfos;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
