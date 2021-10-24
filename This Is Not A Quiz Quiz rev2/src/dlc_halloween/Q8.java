package dlc_halloween;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Q8 extends game.Main {
	
	private static Button[] answers = new Button[4];
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 8 | Lives: " +lives +" | No skipping here!");
		
		// Control
		Label question = new Label("Choose wisely...");
		question.setFont(Font.font(25)); question.setLayoutX(51); question.setLayoutY(50);

		answers[0] = new Button("Subway Tuna is not Fish"); answers[1] = new Button("Pineapple on Pizza"); answers[2] = new Button("Mustard on Watermelon"); answers[3] = new Button("Cereal in Water");
		answers[0].setLayoutX(41); answers[0].setLayoutY(65);
		answers[1].setLayoutX(257); answers[1].setLayoutY(65);
		answers[2].setLayoutX(41); answers[2].setLayoutY(110);
		answers[3].setLayoutX(257); answers[3].setLayoutY(110);
		for(int i = 0; i < answers.length; i++) {
			answers[i].setFont(Font.font(15));
			answers[i].setPrefWidth(200);
			answers[i].setOnAction(e -> {
				window.close();
				questionNumber++;
				Q9.display();
			});
		}
		
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
		window.setScene(scene);
		window.show();
	}

}
