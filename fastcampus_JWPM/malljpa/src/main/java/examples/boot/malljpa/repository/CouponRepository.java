package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
