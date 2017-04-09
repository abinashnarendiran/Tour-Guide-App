package sample;
import com.sun.javafx.scene.control.skin.TextFieldSkin;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import com.sun.javafx.scene.control.behavior.PasswordFieldBehavior;

/**
 * Password field skin.
 * This is the class used to mask the password into bullets
 */
public class PasswordSkin extends TextFieldSkin {
    public static final char BULLET = '\u2022';

    public PasswordSkin(PasswordField passwordField) {
        super(passwordField, new PasswordFieldBehavior(passwordField));
    }

    @Override protected String maskText(String txt) {
        TextField textField = getSkinnable();

        int n = textField.getLength();
        StringBuilder passwordBuilder = new StringBuilder(n);
        for (int i=0; i<n; i++) {
            passwordBuilder.append(BULLET);
        }

        return passwordBuilder.toString();
    }
}

