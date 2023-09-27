
abstract class IntegralCalc1 {
    protected double func(double x){
        return Math.sqrt(1 + 2*x*x - x*x*x); //Math.PI
//        return 1 / Math.log(x);
    }
    protected static double a, b, step; //нижний и верхний пределы
    protected int split; //разбиение
    private void setAB(double a, double b){
        if(b > a){
            this.b = b;
            this.a = a;
        }
        else {
            this.b = a;
            this.a = b;
        }
    }
    private void setSplit(double n){
        this.split = (int) Math.round(Math.abs(n));
    }
    protected IntegralCalc1(double a, double b, double split){
        setAB(a, b);
        setSplit(split);
        this.step = Math.abs(b - a) / split;
    }
    public abstract double Calc();
}

class TrapezoidalMethod1 extends IntegralCalc1{
    public TrapezoidalMethod1(double a, double b, double split)  {
        super(a, b, split);
    }

    @Override
    public double Calc() {
        double result = (super.func(a) + super.func(b)) / 2;
        for(double i = a+step; i <= b-step; i += step)
        {
            result += super.func(i);
        }
        return result * step;
    }
}

class SimpsonMethod1 extends IntegralCalc1{
    public SimpsonMethod1(double a, double b, double split)  {
        super(a, b, split);
    }

    @Override
    public double Calc() {
        step /= 2.0;
        double result = super.func(a) + super.func(b);
        double sumEven = 0, sumNotEven = 0;
        for(int i = 1; i <= 2*split - 1; i++) // a+step; i <= b-step; i += step*2)
        {
            if (i % 2 == 0) sumEven += super.func(a + i*step);
            else if (i % 2 == 1) sumNotEven += super.func(a + i*step);
        }
        result += 2*sumEven + 4*sumNotEven;
        return result * step / 3.0;
    }
}

public class Program1{

    public static void main(String[] args) {

        double a = 1.2, b = 2, split = 1000;
        IntegralCalc1 obj1, obj2;

        obj1 = new TrapezoidalMethod1(a, b, split); //Math.round(obj1.Calc() * 1000.0) / 1000.0
        System.out.println(obj1.Calc());

        System.out.println("==================");

        obj2 = new SimpsonMethod1(a, b, 4);
        System.out.println(obj2.Calc());
    }
}