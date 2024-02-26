package os.windows;

import controls.*;
import os.Factory;

public class windowsFactory implements Factory {

    @Override
    public Form createForm() {
        return new windowsForm();
//        return null;
    }

    @Override
    public Label createLabel() {
        return new windowsLabel();
//        return null;
    }

    @Override
    public TextBox createTextBox() {
        return new windowsTextBox();
//        return null;
    }

    @Override
    public ComboBox createComboBox() {
        return new windowsComboBox();
//        return null;
    }

    @Override
    public Button createButton() {
        return new windowsButton();
//        return null;
    }
}
