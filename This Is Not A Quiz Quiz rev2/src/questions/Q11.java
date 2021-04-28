package questions;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class Q11 extends game.Main {

	//////////////////////////////////////////////////////////////////
	//																//
	//					  Check All That Apply						//
	//																//
	// Uses CheckBoxes. That's it. If I was doing an application	//
	// for mobile ordering, I would probably go more into it.		//
	//																//
	// Answer: Literally check "all that apply." Do not check		//
	// anything else.												//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 11 | Lives: " +lives);
		
		// Question
		Label question = new Label("Check");
		question.setFont(Font.font(25));
		question.setLayoutX(51); question.setLayoutY(59);
		
		// Checkboxes
		CheckBox box1 = new CheckBox("all that apply");
		box1.setFont(Font.font(25)); box1.setLayoutX(128); box1.setLayoutY(59);
		
		CheckBox box2 = new CheckBox("Anxiety");
		box2.setFont(Font.font(15)); box2.setLayoutX(88); box2.setLayoutY(129);
		
		CheckBox box3 = new CheckBox("Coughing");
		box3.setFont(Font.font(15)); box3.setLayoutX(187); box3.setLayoutY(129);
		
		CheckBox box4 = new CheckBox("Sleepy");
		box4.setFont(Font.font(15)); box4.setLayoutX(88); box4.setLayoutY(166);
		
		CheckBox box5 = new CheckBox("Wealthy");
		box5.setFont(Font.font(15)); box5.setLayoutX(187); box5.setLayoutY(166);
		
		// Submit Button
		Button button = new Button("Done!");
		button.setFont(Font.font(15)); button.setLayoutX(154); button.setLayoutY(204);
		button.setOnAction(e -> {
			if((!box1.isSelected()) || (box2.isSelected() == true) || (box3.isSelected() == true) || (box4.isSelected() == true) || (box5.isSelected() == true)) {
				lives--;
				if(lives > 0) {
					window.setTitle("Question 11 | Lives: " +lives);
				}
				if(lives <= 0) {
					window.close();
					gameOver("Skewed Results", "The survey seems inaccurate");
				}
			}
			else {
				window.close();
				Q12.display();
			}
		});
		
		// Layout
		AnchorPane layout = new AnchorPane();
		layout.getChildren().addAll(question, box1, box2, box3, box4, box5, button);
		
		window.setScene(new Scene(layout, 367, 258));
		window.show();
	}

}
