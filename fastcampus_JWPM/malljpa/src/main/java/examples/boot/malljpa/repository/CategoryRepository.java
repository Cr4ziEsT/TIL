package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
