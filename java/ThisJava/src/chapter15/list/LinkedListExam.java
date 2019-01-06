package chapter15.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExam {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new LinkedList<String>();

        long startTime;
        long endTime;

        startTime = System.nanoTime();
        looping(list1);

        endTime = System.nanoTime();
        System.out.println("ArrayList 걸린시간 : " + (endTime-startTime) + " ns");

        startTime = System.nanoTime();
        looping(list2);

        endTime = System.nanoTime();
        System.out.println("LinkedList 걸린시간 : " + (endTime-startTime) + " ns");
    }

    private static void looping(List<String> list) {
        for (int i = 0; i < 10000; i++) {
            list.add(0, String.valueOf(i));
        }
    }
}
