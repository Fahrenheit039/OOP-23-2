interface kindOfMethod4 {
    double functionToCalc3(double a, double b, double c);
}

public class try4 {
    public static void superMethodInterface(kindOfMethod4 method) {
        double result = method.functionToCalc3(1,2,3);
    }

    public static void main(String[] args) {

        kindOfMethod4 kom4 = new kindOfMethod4() {
            @Override
            public double functionToCalc3(double a, double b, double c) {
                return a+b+c;//return Calc();
            }
        };

        Operationable op = new Operationable(){

            public double functionToCalc3(double x){

                return Math.sin(x);
            }
        };
        double z = op.functionToCalc3(Math.PI / 2);
        System.out.println(z);

    }

}