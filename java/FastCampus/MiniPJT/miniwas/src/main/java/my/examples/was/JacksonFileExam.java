package my.examples.was;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JacksonFileExam {
    public static void main(String[] args) throws Exception{
        MiniWasConfiguration miniWasConfiguration
                = new MiniWasConfiguration();
        miniWasConfiguration.setStaticDir("/java");
        miniWasConfiguration.setClassPath(".");

        // 객체를 파일에 json 형태로 저장한다.
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("/java/was.json"), miniWasConfiguration);

        // json 형태로 저장 된 파일을 읽는다.
        MiniWasConfiguration readObj =
                objectMapper.readValue(new File("/java/was.json"), MiniWasConfiguration.class);
        System.out.println(readObj.getClassPath());
        System.out.println(readObj.getStaticDir());
    }
}
