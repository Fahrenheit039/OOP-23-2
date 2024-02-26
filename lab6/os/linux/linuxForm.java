package os.linux;

import controls.Form;

public class linuxForm extends Form {
    @Override
    public String addControl(){
        System.out.println(super.addControl() + " у контрола " + getClass().getName().split("\\.")[2]);
        return null;
    }
}