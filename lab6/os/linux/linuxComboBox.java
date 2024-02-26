package os.linux;

import controls.ComboBox;

public class linuxComboBox extends ComboBox {
    @Override
    public String setSelectedIndex(){
        System.out.println(super.setSelectedIndex() + " у контрола " + getClass().getName().split("\\.")[2]);
        return null;
    }
    @Override
    public String getSelectedIndex(){
        System.out.println(super.getSelectedIndex() + " у контрола " + getClass().getName().split("\\.")[2]);
        return null;
    }
    @Override
    public String setItems(){
        System.out.println(super.setItems() + " у контрола " + getClass().getName().split("\\.")[2]);
        return null;
    }
    @Override
    public String getItems(){
        System.out.println(super.getItems() + " у контрола " + getClass().getName().split("\\.")[2]);
        return null;
    }
}
