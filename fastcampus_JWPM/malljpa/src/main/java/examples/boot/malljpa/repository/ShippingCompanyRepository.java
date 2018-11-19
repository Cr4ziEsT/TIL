package examples.boot.malljpa.repository;




import examples.boot.malljpa.domain.ShippingCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShippingCompanyRepository extends JpaRepository<ShippingCompany, Long> {


}
