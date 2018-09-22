package my.examples.was;

public class WasConfigurationManagerTest {
    public static void main(String[] args){
        WasConfigurationManager wcm =
                WasConfigurationManager.getInstance();
        WasConfigurationManager wcm2 =
                WasConfigurationManager.getInstance();

        if(wcm == wcm2){
            System.out.println("같은 참조입니다.");
        }

        MiniWasConfiguration miniWasConfiguration =
                new MiniWasConfiguration();
        miniWasConfiguration.setStaticDir("/java");
        miniWasConfiguration.setClassPath(".");
        // 객체를 json 형태의 파일로 저장
        wcm.seveMiniWasConfiguration(miniWasConfiguration, "/java/m.json");
        // json 형태의 파일을 읽는다.
        MiniWasConfiguration mwc = wcm.getMiniWasConfiguration("/java/m.json");
        System.out.println(mwc.getStaticDir());
        System.out.println(mwc.getClassPath());
    }
}
