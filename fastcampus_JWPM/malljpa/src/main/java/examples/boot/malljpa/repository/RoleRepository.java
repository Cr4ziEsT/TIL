package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
