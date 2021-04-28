package questions;

import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Q6 extends game.Main {
	
	static Button submit = new Button("Submit");

	//////////////////////////////////////////////////////////////////
	//																//
	//						Enter the Alphabet						//
	//																//
	// This "question" uses a TextField, so the player can			//
	// respond to the following prompt.								//
	//																//
	// Answer: Literally type "the alphabet" with no quotations.	//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 6 | Lives: " +lives);
		
		Label question = new Label("Enter the alphabet");
		question.setFont(Font.font(25));
		
		TextField answer = new TextField();
		answer.setPrefSize(316, 31); answer.setFont(Font.font(15));
		answer.setLayoutX(91); answer.setLayoutY(58);
		answer.setAlignment(Pos.CENTER);
		
		submit.setPrefWidth(200); submit.setFont(Font.font(15));
		submit.setLayoutX(149); submit.setLayoutY(118);
		submit.setOnAction(e -> {
			if(answer.getText().equals("the alphabet")) {
				window.close();
				Q7.display();
			} else {
				lives --;
				if(lives > 0) {
					window.setTitle("Question 6 | Lives: " +lives);
				} else {
					window.close();
					gameOver("Failing Kindergarten", "Did you even learn your ABCs?");
				}
			}
		});
		
		//////////////////////////////////////////////////////////////////
		//																//
		//						Set on Key Pressed						//
		//																//
		// The player can submit their response by clicking the			//
		// "submit" button, but they can also press Enter on their		//
		// keyboard to submit as well.									//
		//																//
		//////////////////////////////////////////////////////////////////
		
		answer.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if(ke.getCode().equals(KeyCode.ENTER)) {
					if(answer.getText().equals("the alphabet")) {
						window.close();
						Q7.display();
					} else {
						lives--;
						if(lives > 0) {
							window.setTitle("Question 6 | Lives: " +lives);
						}
						else {
							window.close();
							gameOver("Failing Kindergarten", "Did you even learn your ABCs?");
						}
					}
				}
			}
		});
		
		SplitPane splitpane = new SplitPane();
		splitpane.setDividerPositions(0.4);
		splitpane.setOrientation(Orientation.VERTICAL);
		splitpane.setPrefSize(500, 350);
		
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(question);
		
		AnchorPane anchorpane = new AnchorPane();
		anchorpane.getChildren().addAll(answer, submit);
		
		splitpane.getItems().addAll(vbox, anchorpane);
		window.setScene(new Scene(splitpane, 500, 350));
		window.show();
	}

}
