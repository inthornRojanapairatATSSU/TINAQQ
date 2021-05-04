package game;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.*;
import javafx.stage.*;

public class SkipAlert {
	
	public static void display() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("You got something!");
		
		Label top = new Label("Skip get!");
		top.setFont(Font.font("System", FontWeight.BOLD, 35));
		top.setLayoutX(102); top.setLayoutY(37);
		
		Label bottom = new Label("Press 'S' to use it in times of need!");
		bottom.setFont(Font.font(20));
		bottom.setLayoutX(21); bottom.setLayoutY(95);
		
		Button close = new Button("Sweet!");
		close.setFont(Font.font(20));
		close.setLayoutX(133); close.setLayoutY(169);
		close.setOnAction(e -> window.close());
		
		AnchorPane layout = new AnchorPane();
		layout.getChildren().addAll(top, bottom, close);
		
		window.setScene(new Scene(layout, 350, 250));
		window.showAndWait();
	}

}
