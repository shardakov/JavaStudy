package application;
	
import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	MenuBar menuBar;
	Menu fileMenu;
	MenuItem openItem;
	Player medPlayer;
	FileChooser mediaChooser;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			
			menuBar = new MenuBar();
			fileMenu = new Menu("File");
			openItem = new MenuItem("Open");
			mediaChooser = new FileChooser();
			
			primaryStage.widthProperty().addListener((obs,oldVal,newVal) -> {
				if(medPlayer != null)
				medPlayer.mediaView.setFitWidth(scene.getWidth());
			});
			
			root.setTop(menuBar);
			menuBar.getMenus().add(fileMenu);
			fileMenu.getItems().add(openItem);
			
			openItem.setOnAction((e) -> {
				try {
					File mediaFile = mediaChooser.showOpenDialog(primaryStage);
					if(medPlayer != null) {
						medPlayer.mediaPlayer.dispose();
					}
					medPlayer = new Player(mediaFile.toURI().toURL().toExternalForm());
					medPlayer.mediaView.setFitWidth(scene.getWidth());
					root.setCenter(medPlayer);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
			});
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
