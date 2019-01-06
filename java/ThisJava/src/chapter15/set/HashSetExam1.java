package chapter15.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam1 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        // "Java"는 한 번만 저장됨
        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java");
        set.add("iBATIS");

        // 저장된 객체 수 얻기
        int size = set.size();
        System.out.println("총 객체 수 : " + size);

        Iterator<String> iterator = set.iterator(); // 반복자 얻기
        looping(iterator);

        set.remove("JDBC"); // 한 개의 객체 삭제
        set.remove("iBATIS"); // 한 개의 객체 삭제

        System.out.println("총 객체 수 : " + set.size()); // 저장된 객체 수 얻기

        iterator = set.iterator(); // 반복자 얻기
        looping(iterator);

        set.clear(); // 모든 객체를 제거하고 비움
        if(set.isEmpty())
            System.out.println("비어 있음");
    }


    private static void looping(Iterator<String> iterator) {
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("\t" + element);
        }
    }
}
