import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;


class Array3d {

    static final int NINE = 9;
    private Scanner in;
    private static int n, m, k;
    private int[] arr3d;

    public Array3d(int dim0, int dim1, int dim2){
        this.in = new Scanner(System.in);

        this.n = dim0;
        this.m = dim1;
        this.k = dim2;
//        this.arr3d = new int[this.n][this.m][this.k];
        this.arr3d = new int[this.n * this.m * this.k];

//        long now = new Date().getTime();
//        IntStream streamRand = rnd.ints(this.n * this.m * this.k, -5, 5);
//        OptionalInt streamRand2 = rnd.ints(this.n * this.m * this.k);
//        rnd.ints(this.n * this.m * this.k, -5, 5).forEach(System.out::println);
//        System.out.println( rnd.ints(this.n * this.m * this.k, -5, 5) );
//        System.out.println( Arrays.toString( rnd.ints(this.n * this.m * this.k, -5, 5).toArray() ) );
        Random rnd = new Random();
        int[] arrRand = rnd.ints(this.n * this.m * this.k, -9, 9).toArray();
        for (int i = 0; i < this.n; i++){
            for (int j = 0; j < this.m; j++){
                for (int k = 0; k < this.k; k++){
                    this.arr3d[i*this.m*this.k + j*this.k + k] = arrRand[i*this.m*this.k + j*this.k + k];
//                    System.out.printf("%d ", this.arr3d[i*this.m*this.k + j*this.k + k]);
                }
//                System.out.println();
            }
//            System.out.println();
        }

        print3d();
    }

    public void print3d() {
        for (int i = 0; i < this.n; i++){
            for (int j = 0; j < this.m; j++){
                for (int k = 0; k < this.k; k++){
                    System.out.printf("%d ", this.arr3d[i*this.m*this.k + j*this.k + k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    //get section
    public int getOne(int i, int j, int k) {
        return this.arr3d[i*this.m*this.k + j*this.k + k];
    }

    public int[] getValues01(int i, int j) {
        int[] tmp = new int[this.k];
        int counter = 0;
        for (int k=0; k < this.k; k++)
            tmp[counter++] = arr3d[i*this.m*this.k + j*this.k + k];
        return tmp;
    }
    public int[] getValues02(int i, int k) {
        int[] tmp = new int[this.m];
        int counter = 0;
        for (int j=0; j < this.m; j++)
            tmp[counter++] = arr3d[i*this.m*this.k + j*this.k + k];
        return tmp;
    }
    public int[] getValues12(int j, int k) {
        int[] tmp = new int[this.n];
        int counter = 0;
        for (int i=0; i < this.n; i++)
            tmp[counter++] = arr3d[i*this.m*this.k + j*this.k + k];
        return tmp;
    }

    public int[] getValues0(int i) {
        int[] tmp = new int[this.m * this.k];
        int counter = 0;
        for (int j = 0; j < this.m; j++)
            for (int k = 0; k < this.k; k++)
                tmp[counter++] = arr3d[i*this.m*this.k + j*this.k + k];
        return tmp;
    }
    public int[] getValues1(int j) {
        int[] tmp = new int[this.n * this.k];
        int counter = 0;
        for (int i = 0; i < this.n; i++)
            for (int k = 0; k < this.k; k++)
                tmp[counter++] = arr3d[i*this.m*this.k + j*this.k + k];
        return tmp;
    }
    public int[] getValues2(int k) {
        int[] tmp = new int[this.n * this.m];
        int counter = 0;
        for (int i = 0; i < this.n; i++)
            for (int j = 0; j < this.m; j++)
                tmp[counter++] = arr3d[i*this.m*this.k + j*this.k + k];
        return tmp;
    }

    // set section
    public boolean setOne(int i, int j, int k) {
        while(true) {
            try {
                arr3d[i*this.m*this.k + j*this.k + k] = in.nextInt();
                return true;
            }
            catch (Exception e) {
                System.out.println("Exception: " + e.getMessage() + "\ntry input again");
            }
        }
    }

    private int[] newValues(int size){
        System.out.println("Enter " + size + " numbers");
        int[] tmp = new int[size];

        while(true){
            try {
                in = new Scanner(System.in);
                String[] values = in.nextLine().split(" ");
                while (values.length != size) {
                    in = new Scanner(System.in);
                    values = in.nextLine().split(" ");
                }

                for (int i = 0; i < size; i++)
                    tmp[i] = Integer.parseInt(values[i]);

                return tmp;
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage() + "\ntry input again");
            }
        }
    }

    public boolean setValues01(int i, int j) {
        while(true) {
            try {
                int[] row = newValues(this.k);
                for (int k = 0; k < this.k; k++)
                    arr3d[i*this.m*this.k + j*this.k + k] = row[k];
                return true;
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage() + "\ntry input again");
            }
        }
    }
    public boolean setValues02(int i, int k) {
        while(true) {
            try {
                int[] row = newValues(this.m);
                for (int j = 0; j < this.m; j++)
                    arr3d[i*this.m*this.k + j*this.k + k] = row[j];
                return true;
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage() + "\ntry input again");
            }
        }
    }
    public boolean setValues12(int j, int k) {
        while(true) {
            try {
                int[] row = newValues(this.n);
                for (int i = 0; i < this.n; i++)
                    arr3d[i*this.m*this.k + j*this.k + k] = row[i];
                return true;
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage() + "\ntry input again");
            }
        }
    }

    public boolean setValues0(int i) {
        while(true) {
            try {
                int[] layer = newValues(this.m * this.k);
                int counter = 0;
                for (int j = 0; j < this.m; j++)
                    for (int k = 0; k < this.k; k++)
                        arr3d[i*this.m*this.k + j*this.k + k] = layer[counter++];
                return true;
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage() + "\ntry input again");
            }
        }
    }
    public boolean setValues1(int j) {
        while(true) {
            try {
                int[] layer = newValues(this.n * this.k);
                int counter = 0;
                for (int i = 0; i < this.n; i++)
                    for (int k = 0; k < this.k; k++)
                        arr3d[i*this.m*this.k + j*this.k + k] = layer[counter++];
                return true;
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage() + "\ntry input again");
            }
        }
    }
    public boolean setValues2(int k) {
        while(true) {
            try {
                int[] layer = newValues(this.n * this.m);
                int counter = 0;
                for (int i = 0; i < this.n; i++)
                    for (int j = 0; j < this.m; j++)
                        arr3d[i*this.m*this.k + j*this.k + k] = layer[counter++];
                return true;
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage() + "\ntry input again");
            }
        }
    }

    // fill section
    public boolean fillWithOnes(){
        while(true) {
            try {
                for (int i = 0; i < this.n; i++)
                    for (int j = 0; j < this.m; j++)
                        for (int k = 0; k < this.k; k++)
                            arr3d[i*this.m*this.k + j*this.k + k] = 1;
                return true;
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage() + "\ntry input again");
            }
        }
    }
    public boolean fillWithZeros(){
        while(true) {
            try {
                for (int i = 0; i < this.n; i++)
                    for (int j = 0; j < this.m; j++)
                        for (int k = 0; k < this.k; k++)
                            arr3d[i*this.m*this.k + j*this.k + k] = 0;
                return true;
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage() + "\ntry input again");
            }
        }
    }
    public boolean fill(int x){
        while(true) {
            try {
                for (int i = 0; i < this.n; i++)
                    for (int j = 0; j < this.m; j++)
                        for (int k = 0; k < this.k; k++)
                            arr3d[i*this.m*this.k + j*this.k + k] = x;
                return true;
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage() + "\ntry input again");
            }
        }
    }

}









