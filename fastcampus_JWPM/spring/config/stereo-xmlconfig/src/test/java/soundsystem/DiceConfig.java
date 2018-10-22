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

    // 스프링 컨테이너가 kim 이란 메소드를 호출하는데 파라미터로 Dice 객체를 자동으로 넣어준다.(메소드의 위치는 상관이 없다.)
    @Bean
    public Player kim(){
        System.out.println("kim()");
        System.out.println(this.getClass().getName());
        Player player = new Player();
        player.setDice(dice());     // kim()메소드에서 dice()메소드를 사용하고 있기 때문에 Dice 객체가 먼저 생성이 된다.
        player.setName("kim");
        return player;
    }
    /* 스프링 컨테이너는 똑같은 객체를 여러개 갖지 않고 1개만 가질 수 있도록 한다.(default) why? 관리하기 힘들다
    프로토 타입을 적어주기 전에는 메모리에 객체가 하나만 생성된다.
    @Bean 이라고 붙어진 config 도 메모리에 객체가 한 개만 생성되어야 한다.

    그런데 dice() 라는 메소드가 new Dice(6)을 생성하고 kim() 이라는 메소드 안에서 dice()메소드를 호출하여 새로운 Dice를 생성한다.
    이 경우 자신의 클래스 안에서 자신의 메소드를 실행하여, new Dice(6)이 여러번 실행되어 여러개의 객체가 리턴된다.(-> 자바 문법 상 문제가 없다.)
    하지만 이럴 경우 인스턴스가 여러개 만들어지게 된다.
    그래서 Spring 개발자는 Java Config 설정을 읽어들이면 해당 설정을 상속받고 있는 객체가 메모리에 자동으로 만들어지도록 했다.

    이 객체를 Proxy 객체라고 하며, 해당 객체는 Config 설정의 메소드들을 오버라이딩 한다.
    그리고 메소드가 최초로 호출되었을때에는 super.dice() 를 호출하고 생성된 Dice 객체를 리턴해준다.
    2번째 이후로 호출 될 경우 최초로 호출되었을 때 super.dice() 로 생성한 객체 Dice 를
                        ApplicationContext가 보관하고 있다가 이미 생성되어진 해당 Dice 객체를 리턴해준다.
     */

    @Bean
    public Player kang(){
        System.out.println("kang()");
        System.out.println(this.getClass().getName());
        Player player = new Player();
        player.setDice(dice());
        player.setName("kang");
        return player;
    }

    @Bean
    public Player lee(){
        System.out.println("lee()");
        System.out.println(this.getClass().getName());
        Player player = new Player();
        player.setDice(dice());
        player.setName("lee");
        return player;
    }

    @Bean
    public Game game(){
        Game game = new Game();
        List<Player> list = new ArrayList<>();
        list.add(kim());
        list.add(kang());
        list.add(lee());
        game.setPlayerList(list);
        return game;
    }
}
