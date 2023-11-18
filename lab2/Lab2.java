import java.util.*;

class Point {
    protected double x, y, z;
    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Vector {
    protected double i, j, k;
    public Vector(Point p1, Point p2) {
        this.i = p2.x - p1.x;
        this.j = p2.y - p1.y;
        this.k = p2.z - p1.z;
    }
    public Vector(double i, double j, double k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }
    public Vector() {
        this.i = 0.0;
        this.j = 0.0;
        this.k = 0.0;
    }
}

class Operations{
    private ArrayList<Vector> vectorsArray; // = new ArrayList<Vector>();
    private LinkedHashMap<String, String> vMethods; // = new LinkedHashMap<String, String>();

    {
        vectorsArray = new ArrayList<Vector>();
        vMethods = new LinkedHashMap<String, String>();
    }

    public Vector sumVectors(Vector a, Vector b){
        Vector v = new Vector();
        v.i = a.i + b.i;
        v.j = a.j + b.j;
        v.k = a.k + b.k;
        return v;
    }
    public Vector subtractVectors(Vector a, Vector b){
        Vector v = new Vector();
        v.i = a.i - b.i;
        v.j = a.j - b.j;
        v.k = a.k - b.k;
        return v;
    }
    public Vector reverseVector(Vector v){
        v.i = -1 * v.i;
        v.j = -1 * v.j;
        v.k = -1 * v.k;
        return v;
    } // todo мб сделать void . java не создает новый объект, а меняет переданный
    public double lengthVector(Vector v){
        return Math.sqrt(v.i*v.i + v.j*v.j + v.k*v.k);
    }
    public Vector unitVector(Vector v){
        double l = lengthVector(v);
        v.i = v.i / l;
        v.j = v.j / l;
        v.k = v.k / l;
        return v;
    } // todo void
    public double dotProductVectors(Vector a, Vector b){
        return lengthVector(a) * lengthVector(b) * ( (a.i*b.i + a.j*b.j + a.k*b.k) / (lengthVector(a) * lengthVector(b)) );
    } // cos a = a-> * b-> / a*b  \\ a-> * b-> = ax*bx + ay*by + az*bz \\ a*b = length(a)*(length(b)
    public Vector vectorProductVectors(Vector a, Vector b){
        Vector v = new Vector();
        v.i = a.j*b.k - a.k*b.j;
        v.j = a.k*b.i - a.i*b.k;
        v.k = a.i*b.j - a.j*b.i;
        return v;
    } // todo void
    public double mixedProductVectors(Vector a, Vector b, Vector c){
        return a.i*b.j*c.k + b.i*c.j*a.k + c.i*a.j*b.k - c.i*b.j*a.k - a.i*c.j*b.k - b.i*a.j*c.k;
    }
    public boolean collinearityVectors(Vector a, Vector b){
        double k;
        if (b.i != 0){
            k = a.i / b.i;
            if (b.j * k != a.j) return false;
            if (b.k * k != a.k) return false;
        }
        else if (b.j != 0){
            k = a.j / b.j;
            if (b.i * k != a.i) return false;
            if (b.k * k != a.k) return false;
        }
        else if (b.k != 0){
            k = a.k / b.k;
            if (b.i * k != a.i) return false;
            if (b.j * k != a.j) return false;
        }
        else if (a.i != 0){
            k = b.i / a.i;
            if (a.j * k != b.j) return false;
            if (a.k * k != b.k) return false;
        }
        else if (a.j != 0){
            k = b.j / a.j;
            if (a.i * k != b.i) return false;
            if (a.k * k != b.k) return false;
        }
        else if (a.k != 0){
            k = b.k / a.k;
            if (a.i * k != b.i) return false;
            if (a.j * k != b.j) return false;
        }
        return true;
    }
    public boolean coplanarityVectors(Vector a, Vector b, Vector c){
        if( collinearityVectors(a, b) || collinearityVectors(b, c) ) return true;
        return false;
    }
    public double distanceBetweenVectors(Vector a, Vector b){
        return Math.sqrt((a.i-b.i)*(a.i-b.i) + (a.j-b.j)*(a.j-b.j) + (a.k-b.k)*(a.k-b.k));
    }
    public double angleBetweenVectors(Vector a, Vector b){
        return Math.acos( (a.i*b.i + a.j*b.j + a.k*b.k) / (lengthVector(a) * lengthVector(b)) );
    }
    public void createVectorBy2P(double x1, double y1, double z1, double x2, double y2, double z2){
        vectorsArray.add(new Vector(new Point(x1, y1, z1), new Point(x2, y2, z2)));
    }
    public void createVectorByCoords(double i, double j, double k){
        vectorsArray.add(new Vector(i, j, k));
    }


    protected void initMenu () {
        vMethods.put("q", "sumVectors(Vector a, Vector b)");
        vMethods.put("w", "subtractVectors(Vector a, Vector b)");
        vMethods.put("e", "unitVector(Vector v)");
        vMethods.put("r", "reverseVector(Vector v)");
        vMethods.put("t", "vectorProductVectors(Vector a, Vector b)");
        vMethods.put(" ", " ");

        vMethods.put("a", "lengthVector(Vector v)");
        vMethods.put("s", "dotProductVectors(Vector a, Vector b)");
        vMethods.put("d", "mixedProductVectors(Vector a, Vector b, Vector c)");
        vMethods.put("f", "distanceBetweenVectors(Vector a, Vector b)");
        vMethods.put("g", "angleBetweenVectors(Vector a, Vector b)");
        vMethods.put("  ", " ");

        vMethods.put("j", "collinearityVectors(Vector a, Vector b)");
        vMethods.put("k", "coplanarityVectors(Vector a, Vector b, Vector c)");
        vMethods.put("   ", " ");

        vMethods.put("z", "createVectorBy2P(double x1, double y1, double z1, double x2, double y2, double z2)");
        vMethods.put("x", "createVectorByCoords(double i, double j, double k)");
        vMethods.put("    ", " ");

//        vMethods.put("i", "vectors list");
//        vMethods.put("m", "menu");
        vMethods.put("exit", "exit");
    }
    public void printMenu (){
        final Map<?, ?> map = this.vMethods;
        for (final Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    public void printV (){
        ArrayList <Vector> items = vectorsArray;
        int counter = 0;
        for(Vector item : items){
            System.out.println(counter+++") ("+item.i +" ; "+ item.j +" ; "+ item.k+")");
        }
    }



}

