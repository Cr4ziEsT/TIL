package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "coupon")
@Getter
@Setter
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45, nullable = false)
    private String name;
    private int discount;
    private Long discountRate;
    @Column(nullable = false)
    private Date expiration;

    @OneToMany(mappedBy = "coupon")
    private Set<MemberCoupon> memberCoupons;
}
