public class Program{

    public static void main(String[] args) {

//        SimpsonMethod obj1 = new SimpsonMethod(Math.sin(x), 0, Math.PI, 10);
    }
}

abstract class IntegralCalc {
    private double func;
    private static double a, b; //нижний и верхний пределы
    private static int split; //разбиение
    public IntegralCalc(double func, double a, double b, int split){
        this.func=func;
        this.a=a;
        this.b=b;
        this.split=split;
    }
    public abstract double Calc(double func, double a, double b, int split);
}

class SimpsonMethod extends IntegralCalc{
    SimpsonMethod(double func, double a, double b, int split)
    {
        super(func, a, b, split);
    }

    @Override
    public double Calc(double func, double a, double b, int split) {
        return 0;
    }

}