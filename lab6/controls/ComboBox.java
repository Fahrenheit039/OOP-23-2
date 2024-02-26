package controls;

public class ComboBox extends Control {

    public ComboBox(){
        super("ComboBox");
    }

    public String setSelectedIndex(){ return "Вызван метод " + super.getMethodName(); }
    public String getSelectedIndex(){ return "Вызван метод " + super.getMethodName(); }
    public String setItems(){ return "Вызван метод " + super.getMethodName(); }
    public String getItems(){ return "Вызван метод " + super.getMethodName(); }

}
