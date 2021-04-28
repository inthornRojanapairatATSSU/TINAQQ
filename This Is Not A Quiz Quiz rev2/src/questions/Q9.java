package questions;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Q9 extends game.Main {
	
	private static Button[] answers = new Button[4];

	//////////////////////////////////////////////////////////////////
	//																//
	//						  Paying Respects						//
	//																//
	// If you've heard of this meme, you'll know.					//
	//																//
	// Uses the scene to perform an action upon pressing a key on	//
	// the keyboard.												//
	//																//
	// Answer: Press "F"											//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 9 | Lives: " +lives);
		
		// Control
		Label question = new Label("How do you pay respects?");
		question.setFont(Font.font(25)); question.setLayoutX(51); question.setLayoutY(50);

		answers[0] = new Button("Motivating Your Classmates"); answers[1] = new Button("Listening to Your Professors");
		answers[2] = new Button("Complementing Your Neighbors"); answers[3] = new Button("Tip the Waiter Service");
		
		answers[0].setLayoutX(41); answers[0].setLayoutY(65);
		answers[1].setLayoutX(257); answers[1].setLayoutY(65);
		answers[2].setLayoutX(41); answers[2].setLayoutY(110);
		answers[3].setLayoutX(257); answers[3].setLayoutY(110);
		for(int i = 0; i < answers.length; i++) {
			answers[i].setPrefWidth(200);
			answers[i].setOnAction(e -> {
				lives--;
				if(lives > 0) {
					window.setTitle("Question 9 | Lives: " +lives);
				}
				else {
					window.close();
					gameOver("Where's the Humanity?", "You are very inconsiderate. >:(");
				}
			});
		}
		
		// SplitPane
		SplitPane splitpane = new SplitPane();
		splitpane.setDividerPositions(0.4);
		splitpane.setOrientation(Orientation.VERTICAL);
		splitpane.setPrefSize(500, 350);
		
		// VBox
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(question);
		
		// AnchorPane
		AnchorPane anchorpane = new AnchorPane();
		anchorpane.setPrefSize(160, 100);
		anchorpane.getChildren().addAll(answers[0], answers[1], answers[2], answers[3]);
		
		// Scene
		splitpane.getItems().addAll(vbox, anchorpane);
		Scene scene = new Scene(splitpane, 500, 350);
		scene.setOnKeyPressed(e -> {
			if(e.getCode().toString().equalsIgnoreCase("F")) {
				window.close();
				Q10.display();
			}
		});
		window.setScene(scene);
		window.show();
	}

}
