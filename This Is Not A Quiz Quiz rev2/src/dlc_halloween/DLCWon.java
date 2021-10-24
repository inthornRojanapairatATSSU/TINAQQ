package dlc_halloween;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DLCWon {
	
	public static void display() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("DLC complete!");
		
		Label top = new Label("DLC complete!");
		top.setFont(Font.font("System", FontWeight.BOLD, 35));
		top.setLayoutX(55); top.setLayoutY(37);
		
		Label bottom = new Label("Congrats. Now go away.");
		bottom.setFont(Font.font(20));
		bottom.setLayoutX(70); bottom.setLayoutY(95);
		
		Button close = new Button("I'M FREEEEE");
		close.setFont(Font.font(20));
		close.setLayoutX(109); close.setLayoutY(169);
		close.setOnAction(e -> window.close());
		
		AnchorPane layout = new AnchorPane();
		layout.getChildren().addAll(top, bottom, close);
		
		window.setScene(new Scene(layout, 350, 250));
		window.showAndWait();
	}

}
