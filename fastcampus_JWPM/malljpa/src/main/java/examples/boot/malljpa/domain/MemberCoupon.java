package examples.boot.malljpa.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member_coupon")
@IdClass(MemberCouponId.class)
@Getter
@Setter
public class MemberCoupon {
    private int count;

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Id
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
}
