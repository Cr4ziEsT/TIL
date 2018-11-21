package examples.boot.malljpa.repository;

import examples.boot.malljpa.domain.Item;
import examples.boot.malljpa.domain.Member;
import examples.boot.malljpa.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 특정email사용자정보읽어들이기() throws Exception{
        Member member = memberRepository.getMember("root@fc.com");
        System.out.println(member.getNickname());
        System.out.println(member.getEmail());
        System.out.println("--------------");
        for(Role role : member.getRoles()) {
            System.out.println(role.getName());
        }
    }

    @Test
    public void 위랑_비교() throws Exception{
        Member member = memberRepository.findMemberByEmail("root@fc.com");
        System.out.println("--------------------");
        System.out.println(member.getEmail());
        for(Role role : member.getRoles()){
            System.out.println(role.getName());
        }
    }

    @Test
    public void 리스트페이징처리() throws Exception{
        Pageable pageable = PageRequest.of(0, 3);
        Page<Item> items = itemRepository.findAll(pageable);

        for(Item item : items){
            System.out.println(item.getName());
        }
    }
}
