package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m join fetch m.roles WHERE m.email = :email")
    public Member getMember(@Param("email")String email);
}
