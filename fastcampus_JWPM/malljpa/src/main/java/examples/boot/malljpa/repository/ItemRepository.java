package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    public Page<Item> findAll(Pageable pageable);

    @Query("SELECT i FROM Item i WHERE i.id = :id")
    public Item getItem(@Param("id")Long id);
}
