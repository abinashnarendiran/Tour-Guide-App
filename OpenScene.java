import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.PrintWriter;

public class OpenScene {

    private final PrintWriter writer ;

    public OpenScene(PrintWriter writer) {
        this.writer = writer ;
    }

    // doesn't need to be called "start" any more...
    public void start(Stage window) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/OpenScene.fxml"));
        Scene scene =  new Scene(root, 200 ,200);
        window.setScene(scene);
        window.show();
    }
}
/*
<Label text="Username:"
                                       GridPane.columnIndex="0"
                                       GridPane.rowIndex="0" />
                                <TextField fx:id="usernameField"
                                           promptText="Your desired username"
                                           GridPane.columnIndex="1"
                                           GridPane.rowIndex="0" />
                                <Label text="Password:"
                                       GridPane.columnIndex="0"
                                       GridPane.rowIndex="1" />
                                <PasswordField fx:id="passwordField"
                                               promptText="Your desired password"
                                               GridPane.columnIndex="1"
                                               GridPane.rowIndex="1" />
 */