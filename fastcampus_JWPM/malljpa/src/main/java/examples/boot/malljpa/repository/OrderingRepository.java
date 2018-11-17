package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderingRepository extends JpaRepository<Ordering, Long> {

}
