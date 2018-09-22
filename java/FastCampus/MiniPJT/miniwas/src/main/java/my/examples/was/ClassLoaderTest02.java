package my.examples.was;

public class ClassLoaderTest02 {
    public static void main(String[] args) throws Exception{
        ClassLoaderSample s1 = new ClassLoaderSample();
        s1.print();
        s1.print("world");

        Class clazz = Class.forName("my.examples.was.ClassLoaderSample");
        ClassLoaderSample sample = (ClassLoaderSample)clazz.newInstance();

        sample.print();
        sample.print("world");
    }
}
