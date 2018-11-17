package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.ItemImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemImageRepository extends JpaRepository<ItemImage, Long> {
}
