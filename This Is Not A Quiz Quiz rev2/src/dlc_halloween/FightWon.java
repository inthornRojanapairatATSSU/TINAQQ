package dlc_halloween;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FightWon {
	
	public static void display() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Battle won!");
		
		Label top = new Label("You won!");
		top.setFont(Font.font("System", FontWeight.BOLD, 35));
		top.setLayoutX(102); top.setLayoutY(37);
		
		Label bottom = new Label("+1 Skip");
		bottom.setFont(Font.font(20));
		bottom.setLayoutX(142); bottom.setLayoutY(95);
		
		Button close = new Button("Great!");
		close.setFont(Font.font(20));
		close.setLayoutX(133); close.setLayoutY(169);
		close.setOnAction(e -> window.close());
		
		AnchorPane layout = new AnchorPane();
		layout.getChildren().addAll(top, bottom, close);
		
		window.setScene(new Scene(layout, 350, 250));
		window.showAndWait();
	}

}
