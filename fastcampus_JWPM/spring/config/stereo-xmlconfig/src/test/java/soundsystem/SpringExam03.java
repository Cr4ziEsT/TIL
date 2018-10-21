package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExam03 {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("diceplayer.xml");
        Game game = context.getBean(Game.class);
        game.play();
    }
}

// 새로운 프로젝트로 주사위 게임을 만들되 가장 높은 숫자가 나온 플레이어가 승자가 되도록 만든다.
