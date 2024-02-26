package os.macos;

import controls.TextBox;

public class macosTextBox extends TextBox {
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
    public String onValueChanged(){
        System.out.println(super.onValueChanged() + " у контрола " + getClass().getName().split("\\.")[2]);
        return null;
    }
}
