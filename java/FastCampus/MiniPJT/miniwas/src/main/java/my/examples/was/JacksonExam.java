package my.examples.was;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExam {
    public static void main(String[] args) throws Exception{
        MiniWasConfiguration miniWasConfiguration =
                new MiniWasConfiguration();
        miniWasConfiguration.setStaticDir("/java");     // 폴더의 위치를 설정한다.
        miniWasConfiguration.setClassPath(".");         // 클래스의 경로를 설정한다.
                                                        // 기본 CLASSPATH 는 해당 프로젝트 패키지의 경로가 된다.
                                                        // (클래스를 다른 프로젝트에서 불러올 때에는 불러올 클래스의 패키지 폴더를 설정해야 한다.)
        // 객체를 json 메시지로 변환한다. (`직렬화`한다.)
        ObjectMapper objectMapper = new ObjectMapper(); // ObjectMapper에 대해 공부하기
            // ObjectMapper는 생성할때 비용이 많이 든다.
            // 따라서 메모리에 한 번만 올리도록 설계하는 것이 좋다.(싱글톤 패턴을 이용)
        String jsonConfiguration =
                objectMapper.writeValueAsString(miniWasConfiguration);  // 객체를 메세지로 변환하여 저장
        System.out.println(jsonConfiguration);  // 변환된 내용을 출력

        // 직렬화 된 것을 역으로 직렬화하여 객체로 만듦(역직렬화)
        String jsonData = "{\"staticDir\":\"/java\",\"classPath\":\".\"}";
        MiniWasConfiguration readObj =
                objectMapper.readValue(jsonData, MiniWasConfiguration.class);
        System.out.println(readObj.getClassPath());
        System.out.println(readObj.getStaticDir());
        System.out.println(MiniWasConfiguration.class);

    }
}
