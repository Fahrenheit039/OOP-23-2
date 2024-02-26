package controls;

public class Label extends Control {

    public Label(){
        super("Label");
    }

    public String setText(){ return "Вызван метод " + super.getMethodName(); }
    public String getText(){ return "Вызван метод " + super.getMethodName(); }

}
