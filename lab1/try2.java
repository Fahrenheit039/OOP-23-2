interface MyInterface {
    double count(double a, double b, double c);
}

public class try2 {
    public static void superMethodInterface(MyInterface method) {
        double a = 5, b = 10, c = 20;
        double result = method.count(a, b, c);
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        MyInterface count = new MyInterface() {
            @Override
            public double count(double a, double b, double c) {
                return a + b + c;
            }
        };
        superMethodInterface(count); // => 35
        superMethodInterface((a,b,c) -> Math.sin(a) * Math.cos(b) + c); // => 1000
        superMethodInterface((a,b,c) -> a + b - c); // => -5
    }
}