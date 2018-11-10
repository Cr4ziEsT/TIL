package examples.daoexam.dao;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.config.DBConfig;
import examples.daoexam.dto.Board;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
// JUnit Test(Readme3.txt)

//우리가 테스트 할 것은 스프링이 관리하는 Bean을 테스트 해야 한다. (Dao는 Bean으로 스프링이 생성해준다.) 따라서 아래와 같이 컨테이너를 만들어주어야 한다.
@RunWith(SpringJUnit4ClassRunner.class)     // @RunWith 는 JUnit 이 제공하는 애노테이션인데, 확장점을 제공한다(JUnit과 함께 쓸 수 있는 무언가를 제공해주는 것)
// SpringJUnit4ClassRunner 스프링이 JUnti을 확장할 수 있는 클래스를 제공해주고 있다.
@ContextConfiguration(classes = ApplicationConfig.class)    // 스프링이 제공, ApplicationConfig를 읽어서 Test에서 사용 할 Spring Container가 생성됨.
public class BoardDaoTest {     // 클래스를 테스트하면 모든 테스트 코드를 실행할 수 있다.
    @Autowired          // Bean을 주입
            BoardDao boardDao;  // 테스트할 대상.

    @Test       // 관련된 test는 하나의 테스트로 모아서 갖고 있는 것이 편하기 때문에 Junit이 제공해주는 애노테이션이다.
    public void init(){
        System.out.println("init");
//        if(1==1){
//            throw new RuntimeException("exception");
//        }     // test메소드를 실행하면 exception이 발생하므로 오류(빨간색)이 나옴을 알 수 있다.(고의적으로 오류를 냈음)
    }

    @Test
    public void getBoards() throws Exception{
        List<Board> boards = boardDao.getBoards();
        Assert.assertEquals(boards.size(), 5);  // board의 개수가 5개가 맞으면 성공!, 아니면 실패!
        for(Board board : boards){
            Assert.assertNotNull(board);    // board가 Null이 아니다!
        }
    }
}
/*
Test를 사람이 눈으로 확인하는 것이 아닌 자동으로 확인하게 하기!
코드가 변경되면 테스트가 자동으로 실행되게 할 수 있는데 이때 문제가 발생했는지 안했는지 알아야된다.
Assert.assertEquals(boards.size(), 5);
Assert.assertNotNull(board);
Assert 라는 메소드가 문제가 발생했는지 확인하는 메서드이다.
board의 개수가 5개가 맞으면 성공!, 아니면 실패!
board가 Null이 아니다!
를 테스트 할 수 있다.

테스트를 할 때 DB를 2개 만들어서 하나는 테스트용, 하나는 배포용으로 사용하면 확인하기 편리하다.
*/