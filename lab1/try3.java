interface Operationable {
    double functionToCalc3(double x);
}

public class try3 {

    public static void main(String[] args) {

        Operationable op = new Operationable(){

            public double functionToCalc3(double x){

                return Math.sin(x);
            }
        };
        double z = op.functionToCalc3(Math.PI / 2);
        System.out.println(z);

    }

}