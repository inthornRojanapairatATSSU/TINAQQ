package dlc_halloween;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Q20 extends game.Main {
	
	private static TextField[] color = new TextField[8];
	private static Button[] skipCount = new Button[4];
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 20 | Lives: " +lives +" | Skips: " +skips +" | No skipping here!");
		
		// Label
		Label question = new Label("Do you remember EVERYTHING?");
		question.setFont(Font.font("System", FontWeight.BOLD, 25)); question.setLayoutX(169); question.setLayoutY(35);
		
		// TextFields
		for(int i = 0; i < 4; i++) {
			color[i] = new TextField("");
			color[i].setPrefSize(149, 25);
			color[i].setLayoutX(42 + (156 * i));
			color[i].setLayoutY(98);
			color[i].setAlignment(Pos.CENTER);
		}  for(int i = 4; i < 8; i++) {
			color[i] = new TextField("");
			color[i].setPrefSize(149, 25);
			color[i].setLayoutX(42 + (156 * (i - 4)));
			color[i].setLayoutY(132);
			color[i].setAlignment(Pos.CENTER);
		}
		color[0].setPromptText("Enter");
		color[1].setPromptText("everything");
		color[2].setPromptText("from");
		color[3].setPromptText("the");
		color[4].setPromptText("beginning");
		color[5].setPromptText("to");
		color[6].setPromptText("the");
		color[7].setPromptText("end");
		
		// Skip Buttons
		for(int i = 0; i < 3; i++) {
			skipCount[i] = new Button("");
			skipCount[i].setPrefSize(106, 109);
			skipCount[i].setLayoutX(157 + (141 * i)); skipCount[i].setLayoutY(210);
			skipCount[i].setFont(Font.font(40));
		}
		skipCount[0].setOnAction(e -> {
			if(skipCount[0].getText().equals("") && skips > 0) {
				skips--;
				skipCount[0].setText("S");
				window.setTitle("Question 20 | Lives: " +lives +" | Skips: " +skips +" | No skipping here!");
			}
		});
		skipCount[1].setOnAction(e -> {
			if(skipCount[1].getText().equals("") && skips > 0) {
				skips--;
				skipCount[1].setText("S");
				window.setTitle("Question 20 | Lives: " +lives +" | Skips: " +skips +" | No skipping here!");
			}
		});
		skipCount[2].setOnAction(e -> {
			if(skipCount[2].getText().equals("") && skips > 0) {
				skips--;
				skipCount[2].setText("S");
				window.setTitle("Question 20 | Lives: " +lives +" | Skips: " +skips +" | No skipping here!");
			}
		});
		skipCount[3] = new Button("No skips");
		skipCount[3].setLayoutX(320); skipCount[3].setLayoutY(341);
		skipCount[3].setOnAction(e -> {
			lives = 0;
			window.close();
			gameOver("Spooky!", "You were on the path to greatness-not-really...");
		});

		// Enter
		for(int i = 0; i < color.length; i++) {
			color[i].setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent ke) {
					if(ke.getCode().equals(KeyCode.ENTER)) {
						if(color[0].getText().equalsIgnoreCase("Blue") && color[1].getText().equalsIgnoreCase("Yellow") && color[2].getText().equalsIgnoreCase("Orange") &&
								color[3].getText().equalsIgnoreCase("Purple") && color[4].getText().equalsIgnoreCase("Maroon") && color[5].getText().equalsIgnoreCase("Teal") &&
								color[6].getText().equalsIgnoreCase("Sepia") && color[7].getText().equalsIgnoreCase("Lavender")) {
							window.close();
							DLCWon.display();
						} else {
							lives--;
							if(lives > 0) {
								window.setTitle("Question 20 | Lives: " +lives +" | Skips: " +skips +" | No skipping here!");
							}
							else {
								window.close();
								gameOver("Spooky!", "You were on the path to greatness-not-really...");
							}
						}
					}
				}
			});
		}

		// AnchorPane
		AnchorPane anchorpane = new AnchorPane();
		anchorpane.setPrefSize(700, 400);
		anchorpane.getChildren().addAll(color);
		anchorpane.getChildren().addAll(skipCount);
		anchorpane.getChildren().addAll(question);
		
		// Scene
		Scene scene = new Scene(anchorpane, 700, 400);
		window.setScene(scene);
		window.show();
	}

}
