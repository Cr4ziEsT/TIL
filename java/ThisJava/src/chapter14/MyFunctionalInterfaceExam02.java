package chapter14;

public class MyFunctionalInterfaceExam02 {
    public static void main(String[] args) {
        MyFunctionalInterface02 fi;

        fi = new MyFunctionalInterface02() {
            @Override
            public void method(int x) {
                int result = x * 5;
                System.out.println(result);
            }
        };
        fi.method(2);

        fi = (x) -> {
            int result = x * 5;
            System.out.println(result);
        };
        fi.method(2);

        fi = (x) -> {
            System.out.println(x * 5);
        };
        fi.method(2);

        // 매개 변수가 하나일 경우에는 괄호를 생략할 수 있다.
        fi = x -> System.out.println(x * 5);
        fi.method(2);

        fi = MyFunctionalInterfaceExam02::method;
        fi.method(2);
    }

    private static void method(int x) {
        System.out.println(x * 5);
    }
}
