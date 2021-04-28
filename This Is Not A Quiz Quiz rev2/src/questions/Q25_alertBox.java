package questions;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Q25_alertBox extends game.Main {
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("A New Challenger Approaches!");
		window.initModality(Modality.APPLICATION_MODAL);
		
		Label alert = new Label("You unlocked a secret!\nHere comes some more questions!");
		alert.setTextAlignment(TextAlignment.CENTER);
		alert.setFont(Font.font(25));
		
		Button proceed = new Button("Oh god...");
		proceed.setFont(Font.font(15));
		proceed.setOnAction(e -> {
			window.close();
			questionNumber++;
			difficulty = 5;
			Q26.display();
		});
		
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(alert, proceed);
		window.setScene(new Scene(layout, 400, 200));
		window.showAndWait();
	}

}
