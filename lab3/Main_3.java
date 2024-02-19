import java.util.Arrays;
import java.util.Scanner;

public class Main_3 {

    public static void main(String[] args) {

        System.out.printf("\nArray3d\n");

        Array3d a3d = new Array3d(2, 3, 5);

        System.out.println( a3d.getOne(0,0,0) );
        System.out.println( a3d.getOne(0,0,1) );
        System.out.println( a3d.getOne(0,1,0) );
        System.out.println( a3d.getOne(1,1,1) );

        System.out.println( Arrays.toString(a3d.getValues01(1,1)) );
        System.out.println( Arrays.toString(a3d.getValues02(1,1)) );
        System.out.println( Arrays.toString(a3d.getValues12(1,1)) );

        System.out.println( Arrays.toString(a3d.getValues0(1)) );
        System.out.println( Arrays.toString(a3d.getValues1(1)) );
        System.out.println( Arrays.toString(a3d.getValues2(1)) );

//        a3d.setOne(1,1,1);
//        System.out.println( a3d.getOne(1,1,1) );

        a3d.setValues01(1,1);
//        a3d.setValues02(1,1);
//        a3d.setValues12(1,1);

        a3d.setValues0(1);
//        a3d.setValues1(1);
//        a3d.setValues2(1);

        a3d.fillWithOnes();
        a3d.fillWithZeros();
        a3d.fill(12);
    }
}
