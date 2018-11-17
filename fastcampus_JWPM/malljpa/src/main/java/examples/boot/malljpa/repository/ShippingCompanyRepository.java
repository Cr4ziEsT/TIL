package examples.boot.malljpa.repository;


// https://en.wikibooks.org/wiki/Java_Persistence?fbclid=IwAR13Gvni_MncOQ2hoOsns9vaS9ODSfHbMOx0Spm_UjPl7NBXznLh-t4NF_c
// JpaRepository : 저장, id에 해당하는 자료를 조회, 모든 데이터 조회, 삭제, 페이지단위로 읽어오는 기능.
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

import examples.boot.malljpa.domain.ShippingCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShippingCompanyRepository extends JpaRepository<ShippingCompany, Long> {

    // Spring Data JPA method query
    // select * from article_group where name like ? limit ?
    public Page<ShippingCompany> findByNameContaining(String name, Pageable pageable);

    // JPQL
    @Query(value = "select ag from ArticleGroup ag where ag.name like CONCAT('%',:name,'%')")
    public Page<ShippingCompany> findByNameContaining2(@Param("name")String name, Pageable pageable);

    // JPQL fetch join - 1 + N 문제를 해결, LAZY이지만 한꺼번에 데이터를 읽어올 수 있다.
    // fetch join + Pageable을 같이 사용할 경우엔 countQuery를 사용해야한다.
    @Query(value = "select ag from ArticleGroup ag join fetch ag.articleInfos where ag.name like CONCAT('%',:name,'%')",
            countQuery = "select count(ag) from ArticleGroup ag where ag.name like CONCAT('%',:name,'%')")
    public Page<ShippingCompany> findByNameContaining3(@Param("name")String name, Pageable pageable);
}
