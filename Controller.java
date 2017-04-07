package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
//Uses built in functions from MediaView and MediaPlayer
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.fxml.*;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private MediaView mediaView;
    private MediaPlayer mediaPlayer;
    private Media media;

    @FXML private MediaView mediaViewTwo;
    private MediaPlayer mediaPlayerTwo;
    private Media mediaTwo;

    @FXML private Button minSize;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //location of the video file.
        String path = new File("src/sample/videos/beijing.mp4").getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        //create a new media player.
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        String path2 = new File("src/sample/videos/rome.mp4").getAbsolutePath();
        mediaTwo = new Media(new File(path2).toURI().toString());
        mediaPlayerTwo = new MediaPlayer(mediaTwo);
        mediaViewTwo.setMediaPlayer(mediaPlayerTwo);
    }

    //function which plays the video when button is pressed.
    public void play(ActionEvent e) throws IOException {
        mediaPlayer.play();
        mediaPlayerTwo.pause();
    }

    //function which pauses the video when button is pressed.
    public void pause(ActionEvent e) throws IOException {
        mediaPlayer.pause();
    }

    public void play2(ActionEvent e) throws IOException {
        mediaPlayerTwo.play();
        mediaPlayer.pause();
    }

    public void pause2(ActionEvent e) throws IOException {
        mediaPlayerTwo.pause();
    }

    //Increases the size of the video.
    public void maxSize(ActionEvent e) throws IOException {
        mediaView.setLayoutX(200);
        mediaView.setLayoutY(125);

        //Sets the new size of the mediaView, by scaling up.
        mediaView.setScaleX(2.2);
        mediaView.setScaleY(2.2);

        mediaView.toFront();
        minSize.toFront();

        //Sets the minimize button to be visible.
        minSize.setVisible(true);
    }

    public void maxSizeTwo(ActionEvent e) throws IOException {
        mediaViewTwo.setLayoutX(200);
        mediaViewTwo.setLayoutY(125);

        mediaViewTwo.setScaleX(2.2);
        mediaViewTwo.setScaleY(2.2);

        mediaViewTwo.toFront();
        minSize.toFront();

        minSize.setVisible(true);
    }

    //Decreases the size of the video, once maximized.
    public void minSize(ActionEvent e) throws IOException {
        mediaView.setLayoutX(40);
        mediaView.setLayoutY(157);

        mediaView.setScaleX(1);
        mediaView.setScaleY(1);

        mediaViewTwo.setLayoutX(361);
        mediaViewTwo.setLayoutY(157);

        mediaViewTwo.setScaleX(1);
        mediaViewTwo.setScaleY(1);

        //Minimize button disappears.
        minSize.setVisible(false);
    }

    @FXML
    public void Logout(ActionEvent e) throws IOException {

    }


    public void Parks(ActionEvent e)throws IOException{

    }

    public void Gas(ActionEvent e)throws IOException{

    }

    public void Restaurants(ActionEvent e)throws IOException{

    }

    public void Hotels(ActionEvent e)throws IOException{

    }

    public void Bank(ActionEvent e)throws IOException{

    }

    public void Shopping(ActionEvent e)throws IOException{

    }
}



