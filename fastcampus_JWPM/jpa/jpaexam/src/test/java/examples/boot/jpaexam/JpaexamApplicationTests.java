package examples.boot.jpaexam;

import examples.boot.jpaexam.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaexamApplicationTests {
	@Autowired
	BoardService boardService;
	@Test
	public void contextLoads() {
		// 해당 메소드가 실행될 때 문제가 없다는 것은 모든 설정이 잘되어 있다.
	}
	@Test
	public void saveBoard() throws Exception{
		boardService.test();
	}
}
