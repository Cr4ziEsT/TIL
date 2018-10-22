package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

// Spring은 @Configuration 이 붙어 있는 클래스를 Java Config 로 인식한다.(스프링이 읽어들이는 자바 설정 파일 = XML파일과 동일한 역할)
@Configuration
public class DiceConfig {
    /*
    빈을 생성하는 메소드에는 @Bean 애노테이션이 붙는다.
    메소드 이름이 Id 값이 된다.
    <bean id="dice" class="soundsystem.Dice">
        <constructor-arg value="6"/>
    </bean>
     */

    @Bean
    public Dice dice(){     // Spring Application Context가 설정을 읽어서 해당 메소드를 자동으로 실행해준다.
        System.out.println("dice()----------------");
        return new Dice(6);     // 리턴해주는 객체를 Bean으로써 관리한다.
    }

    // 스프링 컨테이너가 kim 이란 메소드를 호출하는데 파라미터로 Dice 객체를 자동으로 넣어준다.
//    @Bean
//    public Player kim(){
//        System.out.println("kim()");
//        System.out.println(this.getClass().getName());
//        Player player = new Player();
//        player.setDice(dice());
//        player.setName("kim");
//        return player;
//    }
//
//    @Bean
//    public Player kang(){
//        System.out.println("kang()");
//        System.out.println(this.getClass().getName());
//        Player player = new Player();
//        player.setDice(dice());
//        player.setName("kang");
//        return player;
//    }
//
//    @Bean
//    public Player lee(){
//        System.out.println("lee()");
//        System.out.println(this.getClass().getName());
//        Player player = new Player();
//        player.setDice(dice());
//        player.setName("lee");
//        return player;
//    }
//
//    @Bean
//    public Game game(){
//        Game game = new Game();
//        List<Player> list = new ArrayList<>();
//        list.add(kim());
//        list.add(kang());
//        list.add(lee());
//        game.setPlayerList(list);
//        return game;
//    }
}
