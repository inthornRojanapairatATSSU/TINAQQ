package questions;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Q16 extends game.Main {
	
	private static Button[] answers = new Button[4];
	private static int correctAnswer = 2;
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle(getTitle());
		
		// Control
		Label question = new Label("When did Adobe Flash discontinue?");
		question.setFont(Font.font(25)); question.setLayoutX(51); question.setLayoutY(50);

		answers[0] = new Button("January 1, 2021"); answers[1] = new Button("January 12, 2021"); answers[2] = new Button("December 31, 2020"); answers[3] = new Button("R.I.P Flash");
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
						window.setTitle(getTitle());
					}
					else {
						window.close();
						gameOver("Fake Flash Fan", "I thought you CoolMathGames");
					}
				});
			}
		}
		answers[correctAnswer].setOnAction(e -> {
			window.close();
			questionNumber++;
			Q17.display();
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
		Scene scene = new Scene(splitpane, 500, 350);
		scene.setOnKeyPressed(e -> {
			if(e.getCode().toString().equalsIgnoreCase("S")) {
				if(skips > 0) {
					skips--;
					window.close();
					questionNumber++;
					Q17.display();
				}
			}
		});
		window.setScene(scene);
		window.show();
	}

}
