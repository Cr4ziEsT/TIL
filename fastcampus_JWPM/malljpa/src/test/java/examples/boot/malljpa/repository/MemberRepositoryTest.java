package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.Member;
import examples.boot.malljpa.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@Transactional
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 특정email사용자정보읽어들이기() throws Exception{
        Member member = memberRepository.getMember("crazy@fc.com");
        System.out.println(member.getNickname());
        System.out.println(member.getEmail());
        System.out.println("--------------");
        for(Role role : member.getRoles()) {
            System.out.println(role.getName());
        }
    }
}
