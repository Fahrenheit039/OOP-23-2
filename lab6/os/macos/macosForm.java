package os.macos;

import controls.Form;

public class macosForm extends Form {
    @Override
    public String addControl(){
        System.out.println(super.addControl() + " у контрола " + getClass().getName().split("\\.")[2]);
        return null;
    }
}