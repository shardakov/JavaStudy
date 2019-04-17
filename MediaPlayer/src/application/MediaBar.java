package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class MediaBar extends HBox {
	
	Slider time;
	Slider voll;
	
	Button pause;
	Label volumeLBL;
	
	MediaPlayer player;
	
	public MediaBar(MediaPlayer play) {
		player = play;
		
		voll = new Slider();
		time = new Slider();
		pause = new Button("||");
		volumeLBL = new Label("Volume :");
		
		setPadding(new Insets(10,10,10,10));
		setAlignment(Pos.CENTER);
		setStyle("-fx-background-color:white");
		
		getChildren().add(pause);
		getChildren().add(time);
		getChildren().add(volumeLBL);
		getChildren().add(voll);
		
		
		voll.prefWidth(70);
		voll.setMinWidth(30);
		voll.setValue(100);
		
		pause.setOnAction((e) -> {
			Status status = player.getStatus();
			
			if(status == Status.PLAYING) {
				player.pause();
				pause.setText(">");
			} else if(status == Status.PAUSED) {
				player.play();
				pause.setText("||");
			}
		});
		
		player.currentTimeProperty().addListener((o) -> {
			time.setValue(player.getCurrentTime().toMillis() / player.getTotalDuration().toMillis()*100);
		});
		
		voll.valueProperty().addListener((o) -> {
			player.setVolume(voll.getValue()/100);
		});
		
		time.valueProperty().addListener((o) -> {
			if(time.isPressed())
				player.seek(player.getMedia().getDuration().multiply(time.getValue()/100));
		});
		
	}

}
