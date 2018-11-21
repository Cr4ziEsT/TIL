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

    /*
     // Spring Data JPA method query
    // select * from article_group where name like ? limit ?
    public Page<ArticleGroup> findByNameContaining(String name, Pageable pageable);

    // JPQL
    @Query(value = "select ag from ArticleGroup ag where ag.name like CONCAT('%',:name,'%')")
    public Page<ArticleGroup> findByNameContaining2(@Param("name")String name, Pageable pageable);

    // JPQL fetch join - 1 + N 문제를 해결, LAZY이지만 한꺼번에 데이터를 읽어올 수 있다.
    // fetch join + Pageable을 같이 사용할 경우엔 countQuery를 사용해야한다.
    @Query(value = "select ag from ArticleGroup ag join fetch ag.articleInfos where ag.name like CONCAT('%',:name,'%')",
            countQuery = "select count(ag) from ArticleGroup ag where ag.name like CONCAT('%',:name,'%')")
    public Page<ArticleGroup> findByNameContaining3(@Param("name")String name, Pageable pageable);

     */
}
