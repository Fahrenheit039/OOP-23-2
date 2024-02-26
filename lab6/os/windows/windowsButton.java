package os.windows;

import controls.Button;

public class windowsButton extends Button {
    @Override
    public String setText(){
        System.out.println(super.setText() + " у контрола " + getClass().getName().split("\\.")[2]);
        return null;
    }
    @Override
    public String getText(){
        System.out.println(super.getText() + " у контрола " + getClass().getName().split("\\.")[2]);
        return null;
    }
    @Override
    public String click(){
        System.out.println(super.click() + " у контрола " + getClass().getName().split("\\.")[2]);
        return null;
    }
}