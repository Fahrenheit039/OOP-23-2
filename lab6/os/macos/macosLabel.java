package os.macos;

import controls.Label;

public class macosLabel extends Label {
    @Override
    public String setText(){
        System.out.println(super.setText() + " у контрола " + getClass().getName().split("\\.")[2]);
        return null;
    }
    @Override
    public String getText(){
        System.out.println(super.setText() + " у контрола " + getClass().getName().split("\\.")[2]);
        return null;
    }
}
