package questions;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Q14 extends game.Main {
	
	private static Button[] answers = new Button[4];
	private static int correctAnswer = 0;
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 14 | Lives: " +lives);
		
		// Control
		Label question = new Label("Which answer was for Question 3?");
		question.setFont(Font.font(25)); question.setLayoutX(51); question.setLayoutY(50);

		answers[0] = new Button("This!"); answers[1] = new Button("This!"); answers[2] = new Button("This!"); answers[3] = new Button("This!");
		answers[0].setLayoutX(41); answers[0].setLayoutY(65);
		answers[1].setLayoutX(257); answers[1].setLayoutY(65);
		answers[2].setLayoutX(41); answers[2].setLayoutY(110);
		answers[3].setLayoutX(257); answers[3].setLayoutY(110);
		for(int i = 0; i < answers.length; i++) {
			answers[i].setFont(Font.font(15));
			answers[i].setPrefWidth(200);
			if(i != correctAnswer) {
				answers[i].setOnAction(e -> {
					lives--;
					if(lives > 0) {
						window.setTitle("Question 14 | Lives: " +lives);
					}
					else {
						window.close();
						gameOver("Didn't expect that did you?", "You got more things to remember than you think");
					}
				});
			}
		}
		answers[correctAnswer].setOnAction(e -> {
			window.close();
			Q15.display();
		});
		
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
		window.setScene(new Scene(splitpane, 500, 350));
		window.show();
	}

}
