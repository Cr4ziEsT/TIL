package my.examples.was;

import java.lang.reflect.Method;
import java.net.URL;

public class ClassLoaderTest01 {
    public static void main(String[] args) throws Exception{
        ClassLoaderSample s1 = new ClassLoaderSample();
        s1.print();
        s1.print("world");

     //   ClassLoader classLoader = ClassLoader.getSystemClassLoader();
     //   URL resource = classLoader.getResource("my.examples.was.Sample");

        // Class라는 타입은 클래스 정보를 가지는 객체
        // JVM은 클래스를 CLASSPATH에서 찾는다
        // JVM은 ClassLoader를 이용하여 클래스를 읽어들인다.
        Class clazz = Class.forName("my.examples.was.ClassLoaderSample");

        // Method는 메소드 정보를 가지는 클래스
        Method[] methods = clazz.getMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }
    }
}
