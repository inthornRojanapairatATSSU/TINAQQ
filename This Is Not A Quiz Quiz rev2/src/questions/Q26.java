package questions;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Q26 extends game.Main {
	
	static Button[] button = new Button[80];
	private static int number = 0;
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 26 | Lives: 1");
		
		Label question = new Label("BR-2L3U");
		question.setFont(Font.font(25));
		
		// Button Grid
		for(int i = 0; i < button.length; i++) {
			button[i] = new Button();
			button[i].setPrefSize(30, 30);
			button[i].setOnAction(e -> {
				lives--;
				window.close();
				gameOver("There's Too Many!","Find the right button");
			});
		}
		button[29].setOnAction(e -> {
			window.close();
		});
		
		// SplitPane
		SplitPane splitpane = new SplitPane();
		splitpane.setDividerPositions(0.2);
		splitpane.setOrientation(Orientation.VERTICAL);
		splitpane.setPrefSize(800, 500);
		
		// VBox
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(question);
		
		// GridPane
		GridPane gridpane = new GridPane();
		gridpane.setHgap(10); gridpane.setVgap(10);
		gridpane.setAlignment(Pos.CENTER);
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 16; j++) {
				gridpane.add(button[number], j, i);
				number++;
			}
		}
		
		// Scene
		splitpane.getItems().addAll(vbox, gridpane);
		window.setScene(new Scene(splitpane, 800, 500));
		window.show();
	}

}
