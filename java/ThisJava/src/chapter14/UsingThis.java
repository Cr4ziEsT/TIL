package chapter14;

public class UsingThis {
    public int outterField = 10;

    class Inner {
        int innerField = 20;

        void method() {
            MyFunctionalInterface04 fi = () -> {
                System.out.println("outterField: " + outterField);
                System.out.println("outterField: " + UsingThis.this.outterField + "\n"); // 바깥 객체의 참조를 얻기 위해서는 클래스명.this를 사용

                System.out.println("innerField: " + innerField);
                System.out.println("innerField: " + this.innerField + "\n"); // 람다식 내부에서 this는 Inner 객체를 참조
            };
            fi.method();

//            fi = new MyFunctionalInterface04() {
//                @Override
//                public void method() {
//                    System.out.println("outterField: " + outterField);
//                    System.out.println("outterField: " + UsingThis.this.outterField + "\n");
//
//                    System.out.println("innerField: " + innerField);
//                    System.out.println("innerField: " + this.innerField + "\n"); // TODO 익명 객체 내부에서의 this는 익명 객체의 참조이다.
//                }
//            };
//            fi.method();
        }
    }
}
