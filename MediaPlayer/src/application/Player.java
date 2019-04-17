package application;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane {
	Media media;
	MediaPlayer mediaPlayer;
	MediaView mediaView;
	Pane mPane;
	
	MediaBar mediaBar;
	
	public Player(String file) {
		media = new Media(file);
		mediaPlayer = new MediaPlayer(media);
		mediaView = new MediaView(mediaPlayer);
		mPane = new Pane();
		mediaBar = new MediaBar(mediaPlayer);
		
		mPane.getChildren().add(mediaView);
		setCenter(mPane);
		setBottom(mediaBar);
		mediaPlayer.play();
		
	}
}
