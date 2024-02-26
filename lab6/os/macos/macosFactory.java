package os.macos;

import controls.*;
import os.Factory;

public class macosFactory implements Factory {

    @Override
    public Form createForm() {
        return new macosForm();
//        return null;
    }

    @Override
    public Label createLabel() {
        return new macosLabel();
//        return null;
    }

    @Override
    public TextBox createTextBox() {
        return new macosTextBox();
//        return null;
    }

    @Override
    public ComboBox createComboBox() {
        return new macosComboBox();
//        return null;
    }

    @Override
    public Button createButton() {
        return new macosButton();
//        return null;
    }
}
