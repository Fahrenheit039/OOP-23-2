import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static Vector[] checkInput(int level){
        Vector[] v = new Vector[level];
        Scanner in = new Scanner(System.in);
        double x=0.0, y=0.0, z=0.0;

        for ( int i = 0; i < level; i++ ){
            System.out.println("input: x y z");
            String inputLine = in.nextLine();
            String[] coordsString = inputLine.split(" ");
            try {
                x = Double.parseDouble(coordsString[0]);
                y = Double.parseDouble(coordsString[1]);
                z = Double.parseDouble(coordsString[2]);
                v[i] = new Vector(x, y, z);
            }
            catch (Exception e) {
                System.out.println("Exception: " + e);
                i--;
                System.out.println("try input again");
            }
        }

        return v;
    }

    public static void main(String[] args) {

        System.out.printf("\nWelcome to the Vectors Sandbox v1.0.0\n");

        Operations op = new Operations();
        op.initMenu();

        boolean progress = true;

        Scanner in;
        String inputLine;
        Vector[] v;

        while (progress) {

            System.out.println("\nСписок введенных векторов: ");
            op.printV();
            System.out.println("\nuse hot-keys to call needed function. command list:");
            op.printMenu();
            System.out.print("command : ");
            in = new Scanner(System.in);
            inputLine = in.nextLine();

            switch (inputLine){
//                # 1
                case "q":
                    v = checkInput(2);
                    op.sumVectors(v[0], v[1]);
                    break;
                case "w":
                    v = checkInput(2);
                    op.subtractVectors(v[0], v[1]);
                    break;
                case "e":
                    v = checkInput(1);
                    op.unitVector(v[0]);
                    break;
                case "r":
                    v = checkInput(1);
                    op.reverseVector(v[0]);
                    break;
                case "t":
                    v = checkInput(2);
//                    op.createVectorByCoords();
//                            vectorsArray.add(new Vector(new Point(x1, y1, z1), new Point(x2, y2, z2)));

                    op.vectorProductVectors(v[0], v[1]);
                    break;

//                # 2
                case "a":
                    v = checkInput(1);
                    System.out.println("length = "+op.lengthVector(v[0]));
                    break;
                case "s":
                    v = checkInput(2);
                    System.out.println("dot Product Vectors = "+op.dotProductVectors(v[0], v[1]));
                    break;
                case "d":
                    v = checkInput(3);
                    System.out.println("mixed Product Vectors = "+op.mixedProductVectors(v[0], v[1], v[2]));
                    break;
                case "f":
                    v = checkInput(2);
                    System.out.println("distance Between Vectors = "+op.distanceBetweenVectors(v[0], v[1]));
                    break;
                case "g":
                    v = checkInput(2);
                    System.out.println("angle = "+op.angleBetweenVectors(v[0], v[1]));
                    break;

//                # 2+
                case "j":
                    v = checkInput(2);
                    System.out.println("collinearity is "+op.collinearityVectors(v[0], v[1]));
                    break;
                case "k":
                    v = checkInput(3);
                    System.out.println("coplanarity is "+op.coplanarityVectors(v[0], v[1], v[2]));
                    break;

//                # 3
                case "z":
                    v = checkInput(2);
                    op.createVectorBy2P(v[0].i, v[0].j, v[0].k, v[1].i, v[1].j, v[1].k);
                    System.out.println("added");
                    break;
                case "x":
                    v = checkInput(1);
                    op.createVectorByCoords(v[0].i, v[0].j, v[0].k);
                    System.out.println("added");
                    break;

//                # exit
                case "exit":
                    System.out.println("Завершение программы");
                    in.close();
                    break;

                default:
                    System.out.println("что-то пошло не так. повторите попытку");
                    break;
            }

        }


    }
}
