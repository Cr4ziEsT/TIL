package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}
