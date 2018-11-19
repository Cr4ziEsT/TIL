package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public List<Member> findMemberByEmail(String email);

}
