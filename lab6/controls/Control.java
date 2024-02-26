package controls;


public abstract class Control {
    String name;
    Pos pos;

    class Pos {
        double x, y;
        public Pos(double x ,double y){
            this.x = x;
            this.y = y;
        }
    }

    public Control(String name){
        this.name = name;
        this.pos = new Pos(0,0);
    }

    void setPosition(double x, double y) {
        pos.x = x;
        pos.y = y;
    };

    Pos getPosition() {
        return pos;
    };

    public String getMethodName() { return Thread.currentThread().getStackTrace()[2].getMethodName(); }

}

