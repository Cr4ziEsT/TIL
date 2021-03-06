package my.examples.was;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTest03 {
    public static void main(String[] args) throws Exception {
        ClassLoaderSample s1 = new ClassLoaderSample();
        s1.print();
        s1.print("world");

        addPath("/java/classes");

        Class clazz = Class.forName("my.MyData");
        Object obj = clazz.newInstance();
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
    }
    // 클래스를 동적으로 설정하기 위한 리플렉션 기술
    // https://stackoverflow.com/questions/7884393/can-a-directory-be-added-to-the-class-path-at-runtime
    public static void addPath(String s) throws Exception {
        File f = new File(s);
        URL u = f.toURI().toURL();
        URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        Class urlClass = URLClassLoader.class;
        Method method = urlClass.getDeclaredMethod("addURL", new Class[]{URL.class});
        method.setAccessible(true);
        method.invoke(urlClassLoader, new Object[]{u});
    }
}

/*
 1. /java/classes 경로에 아래의 파일을 작성.
package my;
public class MyData{
	private String name;
 	public void setName(String name){
		this.name = name;
	}
 	public String getName(){
		return name;
	}
}
 2. javac -d . MyData.java
컴파일이 되면 현재경로에 my라는 생성되고 my디렉토리에 MyData.class가 생성된다.
 3. classpath에 /java/classes  가 추가되야 MyData.java를 인식.
 */

