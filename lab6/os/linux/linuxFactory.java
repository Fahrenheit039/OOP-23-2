package os.linux;

import controls.*;
import os.Factory;

public class linuxFactory implements Factory {

    @Override
    public Form createForm() {
        return new linuxForm();
//        return null;
    }

    @Override
    public Label createLabel() {
        return new linuxLabel();
//        return null;
    }

    @Override
    public TextBox createTextBox() {
        return new linuxTextBox();
//        return null;
    }

    @Override
    public ComboBox createComboBox() {
        return new linuxComboBox();
//        return null;
    }

    @Override
    public Button createButton() {
        return new linuxButton();
//        return null;
    }
}
