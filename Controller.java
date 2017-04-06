package sample;

import javafx.event.ActionEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.fxml.*;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private MediaView mediaView;
    private MediaPlayer mediaPlayer;
    private Media media;

    @FXML
    private MediaView mediaView2;
    private MediaPlayer mediaPlayer2;
    private Media media2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String path = new File("src/sample/videos/beijing.mp4").getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        String path2 = new File("src/sample/videos/rome.mp4").getAbsolutePath();
        media2 = new Media(new File(path2).toURI().toString());
        mediaPlayer2 = new MediaPlayer(media2);
        mediaView2.setMediaPlayer(mediaPlayer2);
    }

    public void play(ActionEvent e) throws IOException {
        mediaPlayer.play();
        mediaPlayer2.pause();
    }

    public void pause(ActionEvent e) throws IOException {
        mediaPlayer.pause();
    }

    public void play2(ActionEvent e) throws IOException {
        mediaPlayer2.play();
        mediaPlayer.pause();
    }

    public void pause2(ActionEvent e) throws IOException {
        mediaPlayer2.pause();
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



