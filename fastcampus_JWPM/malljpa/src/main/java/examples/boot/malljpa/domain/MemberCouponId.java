package examples.boot.malljpa.domain;

import java.io.Serializable;

public class MemberCouponId implements Serializable {
    private Long member;
    private Long coupon;

    public MemberCouponId(Long memberId, Long couponId){
        this.member = member;
        this.coupon = coupon;
    }
}
