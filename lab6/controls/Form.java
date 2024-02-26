package controls;

public class Form extends Control {

    public Form(){
        super("Form");
    }

    public String addControl(){
//        System.out.println("Вызван метод addControl у контрола " + this.name);
//        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
//        String methodName = new Exception().getStackTrace()[0].getMethodName();
//        System.out.println("Вызван метод " + methodName + " у контрола " + this.name);
//        System.out.println("Вызван метод " + super.getMethodName());// + " у контрола " + this.name);
        return "Вызван метод " + super.getMethodName();
    }

}
