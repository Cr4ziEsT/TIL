package chapter14;

public class MyFunctionalInterfaceExam01 {
    public static void main(String[] args) {
        MyFunctionalInterface01 fi;

        fi = new MyFunctionalInterface01() {
            @Override
            public void method() {
                String str = "method call1";
                System.out.println(str);
            }
        };
        fi.method();

        fi = () -> {
            String str = "method call2";
            System.out.println(str);
        };
        fi.method();

        fi = () -> { System.out.println("method call3"); };
        fi.method();

        // 실행문이 하나라면 중괄호는 생략 가능
        fi = () -> System.out.println("method call4");
        fi.method();

        fi = MyFunctionalInterfaceExam01::method;
        fi.method();


    }

    private static void method() {
        System.out.println("method call5");
    }
}
