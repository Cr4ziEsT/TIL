package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
