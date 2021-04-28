package questions;

import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Q15 extends game.Main {
	
	private static TextField[] textField = new TextField[4];

	//////////////////////////////////////////////////////////////////
	//																//
	//					Remember the Colors?						//
	//																//
	// This idea came from the Impossible Quiz. The player must		//
	// remember the color order in certain questions throughout		//
	// the series.													//
	//																//
	// This uses TextField as well and it is combined with an		//
	// array and for loop to create those text fields. There is		//
	// no submit button this time, but the player can press enter	//
	// in any of the fields to submit.								//
	//																//
	// The answer ignores cases, so they can be uppercase,			//
	// lowercase, or mixed.											//
	//																//
	// Answer: Blue, Yellow, Orange, Purple							//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 15 | Lives: " +lives +" | No skipping here!");
		
		Label question = new Label("Do you remember?");
		question.setFont(Font.font(25));
		question.setLayoutX(119); question.setLayoutY(59);
		
		// TextField
		for(int i = 0; i < textField.length; i++) {
			textField[i] = new TextField();
			textField[i].setPrefWidth(200);
			textField[i].setLayoutX(127); textField[i].setLayoutY(121 + (65 * i));
			textField[i].setAlignment(Pos.CENTER);
			textField[i].setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent ke) {
					if(ke.getCode().equals(KeyCode.ENTER)) {
						if(textField[0].getText().equalsIgnoreCase("Blue") && textField[1].getText().equalsIgnoreCase("Yellow")
								&& textField[2].getText().equalsIgnoreCase("Orange") && textField[3].getText().equalsIgnoreCase("Purple")) {
							window.close();
							report.EndScreen.display();
						}
						else {
							lives--;
							if(lives > 0) {
								window.setTitle("Question 15 | Lives: " +lives +" | No skipping here!");
							}
							if(lives <= 0) {
								window.close();
								gameOver("So Close to the Finishing Line", "You did not remember");
							}
						}
					}
				}
			});
		}
		textField[3].setPromptText("Press Enter when you're done");
		
		AnchorPane layout = new AnchorPane();
		layout.getChildren().addAll(question, textField[0], textField[1], textField[2], textField[3]);
		window.setScene(new Scene(layout, 450, 400));
		window.show();
	}

}
