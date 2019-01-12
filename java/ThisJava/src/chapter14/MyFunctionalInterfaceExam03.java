package chapter14;

public class MyFunctionalInterfaceExam03 {
    public static void main(String[] args) {
        MyFunctionalInterface03 fi;

        fi = new MyFunctionalInterface03() {
            @Override
            public int method(int x, int y) {
                int result = x + y;
                return result;
            }
        };
        System.out.println(fi.method(2, 5));

        fi = (x, y) -> {
            int result = x + y;
            return result;
        };
        System.out.println(fi.method(2, 5));

        fi = (x, y) -> { return x + y; };
        System.out.println(fi.method(2, 5));

        // return문만 있을 경우 중괄호와 return문 생략 가능
        fi = (x, y) -> x + y;
        System.out.println(fi.method(2, 5));

        fi = (x, y) -> sum(x, y);
        System.out.println(fi.method(2, 5));

        fi = MyFunctionalInterfaceExam03::method;
        System.out.println(fi.method(2, 5));
    }

    public static int sum(int x, int y){
        return (x + y);
    }

    private static int method(int x, int y) {
        return x + y;
    }
}
