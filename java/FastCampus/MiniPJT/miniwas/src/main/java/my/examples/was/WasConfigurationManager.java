package my.examples.was;

import com.fasterxml.jackson.databind.ObjectMapper;

// 싱글턴 패턴
public class WasConfigurationManager {
    private ObjectMapper objectMapper;

    // 2. 자기 자신을 참조하는 private static 변수를 선언한다.
    //    static 변수는 딱 한 번만 초기화되고, 메모리에 딱 한 번만 올라간다.
    private static WasConfigurationManager instance = new WasConfigurationManager();

    // 1. private 생성자를 만든다
    private WasConfigurationManager(){
        objectMapper = new ObjectMapper();
    }

    // 3. public static 메소드를 만든다. instance를 리턴하는..
    public static WasConfigurationManager getInstance(){
        return instance;
    }
    // WasConfigurationManager wasConfigurationManager = new WasConfigurationManager(); (X)
    // WasConfigurationManager wcm1 = WasConfigurationManager.getInstance();
    // WasConfigurationManager wcm2 = WasConfigurationManager.getInstance();
    // wcm1 과 wcm2 는 같은 객체를 참조한다.
    // static 변수는 딱 한 번만 초기화되기 때문에
    // WasConfigurationManager 생성자가 1번만 실행되어 객체가 1개만 만들어지기 때문이다.
}
