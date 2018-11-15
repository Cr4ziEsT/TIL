package examples.boot.malljpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member_coupon")
@IdClass(MemberCouponId.class)
@Getter
@Setter
public class MemberCoupon {
    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Id
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    private boolean availability;
}
