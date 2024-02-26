package controls;

public class TextBox extends Control {

    public TextBox(){
        super("TextBox");
    }

    public String setText(){ return "Вызван метод " + super.getMethodName(); }
    public String getText(){ return "Вызван метод " + super.getMethodName(); }
    public String onValueChanged(){ return "Вызван метод " + super.getMethodName(); }

}
