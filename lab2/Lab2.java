import java.util.*;

class Point {
    public double x, y, z;
}

class Vector {
    public double i,j,k;
    public Vector(Point p1, Point p2)  {
        this.i = p2.x - p1.x;
        this.j = p2.y - p1.y;
        this.k = p2.z - p1.z;
    }
    public Vector(Vector v)  {
        this.i = v.i;
        this.j = v.j;
        this.k = v.k;
    }
    public Vector()  {
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }

    public Vector sumVectors(Vector v1, Vector v2){
        Vector v = new Vector();
        v.i = v1.i + v2.i;
        v.j = v1.j + v2.j;
        v.k = v1.k + v2.k;
        return v;
    }
    public Vector subtractVectors(Vector v1, Vector v2){
        Vector v = new Vector();
        v.i = v1.i - v2.i;
        v.j = v1.j - v2.j;
        v.k = v1.k - v2.k;
        return v;
    }
    public Vector reverseVector(Vector v){
        v.i = -1 * v.i;
        v.j = -1 * v.j;
        v.k = -1 * v.k;
        return v;
    }
    public double lengthVector(Vector v){
        return Math.sqrt(v.i*v.i + v.j*v.j + v.k*v.k);
    }
    public Vector unitVector(Vector v){
        double l = lengthVector(v);
        v.i = v.i / l;
        v.j = v.j / l;
        v.k = v.k / l;
        return v;
    }
    public double dotProductVectors(Vector v1, Vector v2){
        return lengthVector(v1) * lengthVector(v2) * ( (v1.i*v2.i + v1.j*v2.j + v1.k*v2.k) / (lengthVector(v1) * lengthVector(v2)) );
    }
    public Vector vectorProductVectors(Vector v1, Vector v2){
        Vector v = new Vector();
        v.i = v1.j*v2.k - v1.k*v2.j;
        v.j = v1.i*v2.k - v1.k*v2.i;
        v.k = v1.i*v2.j - v1.j*v2.i;
        return v;
    }
    public double mixedProductVectors(Vector v1, Vector v2, Vector v3){
        return v1.i*v2.j*v3.k + v2.i*v3.j*v1.k + v3.i*v1.j*v2.k - v3.i*v2.j*v1.k - v1.i*v3.j*v2.k - v2.i*v1.j*v3.k;
    }
    public boolean collinearityVectors(Vector v1, Vector v2){
        double k = v1.i / v2.i;
        if (v2.j * k != v1.j) return false;
        if (v2.k * k != v1.k) return false;
        return true;
    }
    public boolean coplanarityVectors(Vector v1, Vector v2, Vector v3){
        if( collinearityVectors(v1, v2) || collinearityVectors(v2, v3) ) return true;
        return false;
    }
    public double distanceBetweenVectors(Vector v1, Vector v2){
        return (v1.i-v2.i)*(v1.i-v2.i) + (v1.j-v2.j)*(v1.j-v2.j) + (v1.k-v2.k)*(v1.k-v2.k);
    }
    public double angleBetweenVectors(Vector v1, Vector v2){
        return Math.acos( (v1.i*v2.i + v1.j*v2.j + v1.k*v2.k) / (lengthVector(v1) * lengthVector(v2)) );
    }

}

public class Lab2 {

    public static void main(String[] args) {

        Vector obj = new Vector();
//        obj.printMap(vMethods);

    }
}