package os.windows;

import controls.Form;

public class windowsForm extends Form {
    @Override
    public String addControl(){
        System.out.println(super.addControl() + " у контрола " + getClass().getName().split("\\.")[2]);
        return null;
    }
}