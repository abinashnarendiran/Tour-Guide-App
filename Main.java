package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxmlLoader.load();
        ((Controller) fxmlLoader.getController()).setStage(primaryStage);

        primaryStage.setTitle("Tour Guide App");
        primaryStage.setScene(new Scene(root, 690, 490));
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    public static void main(String[] args) {

        launch(args);
    }
}
