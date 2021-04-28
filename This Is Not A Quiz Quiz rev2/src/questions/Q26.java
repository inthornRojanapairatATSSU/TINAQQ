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

	//////////////////////////////////////////////////////////////////
	//																//
	//					There's Too Many Buttons!					//
	//																//
	// GridPane helped create 80 buttons. The player would only		//
	// have 1.25% chance of clicking the right button if they		//
	// were to guess.												//
	//																//
	// Answer: Click the 30th button.								//
	// BR = bottom right											//
	// 2L = two left												//
	// 3U = three up												//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle(getTitle());
		
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
			questionNumber++;
			Q27.display();
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
		Scene scene = new Scene(splitpane, 800, 500);
		scene.setOnKeyPressed(e -> {
			if(e.getCode().toString().equalsIgnoreCase("S")) {
				if(skips > 0) {
					skips--;
					window.close();
					questionNumber++;
					Q27.display();
				}
			}
		});
		window.setScene(scene);
		window.show();
	}

}
