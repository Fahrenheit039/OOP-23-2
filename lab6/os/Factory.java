package os;

import controls.*;

public interface Factory {
    Form createForm();
    Label createLabel();
    TextBox createTextBox();
    ComboBox createComboBox();
    Button createButton();
}

