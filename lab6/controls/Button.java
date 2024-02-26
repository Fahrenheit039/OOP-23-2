package controls;

public class Button extends Control {

    public Button(){
        super("Button");
    }

    public String setText(){ return "Вызван метод " + super.getMethodName(); }
    public String getText(){ return "Вызван метод " + super.getMethodName(); }
    public String click(){ return "Вызван метод " + super.getMethodName(); }

}
