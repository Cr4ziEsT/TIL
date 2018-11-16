package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class MemberRepositoryTest {
    @Autowired
    MemberRepositroy memberRepository;

    @Test
    public void test() {
        List<Member> members = memberRepository.findMemberByEmail("kim@fc.com");

        for(Member member : members){
            System.out.println(member.getName());
        }
    }
}
