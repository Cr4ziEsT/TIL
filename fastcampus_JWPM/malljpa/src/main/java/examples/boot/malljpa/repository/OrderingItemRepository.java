package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.OrderingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderingItemRepository extends JpaRepository<OrderingItem, Long> {

}
