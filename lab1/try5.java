import java.lang.reflect.Method;

// вызов с передачей методов
public class try5 {
    public static void main(String[] args) throws Exception {
        // передадим стандартный метод
        Method method = Integer.class.getDeclaredMethod("max", int.class, int.class);
        superMethodReflection(0, method); // => 20
        method = Integer.class.getDeclaredMethod("sum", int.class, int.class);
        superMethodReflection(0, method); // => 30
        // передадим собственный метод
        method = try5.class.getDeclaredMethod("concate", int.class, int.class);
        superMethodReflection(new try5(), method); // => 1020
    }
    public static void superMethodReflection(Object object, Method method) throws Exception {
        int a = 10;
        int b = 20;
        int result = (int) method.invoke(object, a, b);
        System.out.println(result);
    }
    public static int concate(int a, int b) {
        return Integer.parseInt("" + a + b);
    }
}