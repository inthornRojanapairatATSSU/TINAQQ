package questions;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Q21 extends game.Main {
	
	private static Button[] answers = new Button[4];
	private static int correctAnswer = 0;

	//////////////////////////////////////////////////////////////////
	//																//
	//							Movie Trivia						//
	//																//
	// Answer: 11/13/09												//
	// The movie, 2012, was released on November 13, 2009.			//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle(getTitle());
		
		// Control
		Label question = new Label("When was 2012?");
		question.setFont(Font.font(25)); question.setLayoutX(51); question.setLayoutY(50);

		answers[0] = new Button("11/13/09"); answers[1] = new Button("In 2012, duh"); answers[2] = new Button("21st Century"); answers[3] = new Button("That was 9 years ago?");
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
					window.close();
					gameOver("The Mayans Were Definitiely Wrong", "It was such a cataclysmic event, you should've seen it");
				});
			}
		}
		answers[correctAnswer].setOnAction(e -> {
			window.close();
			questionNumber++;
			Q22.display();
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
					Q22.display();
				}
			}
		});
		window.setScene(scene);
		window.show();
	}

}
