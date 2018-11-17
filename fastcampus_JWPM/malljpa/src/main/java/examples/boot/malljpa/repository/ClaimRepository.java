package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}
