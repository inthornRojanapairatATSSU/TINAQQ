package questions;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Q25 extends game.Main {
	
	private static Button[] answers = new Button[4];
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 25 | Lives: 1 | No skipping here!");
		
		// Control
		Label question = new Label("How many triangles?");
		question.setFont(Font.font(25)); question.setLayoutX(51); question.setLayoutY(50);
		
		// Image
		ImageView triangles = new ImageView(new Image(Q24.class.getResourceAsStream("imageQuestion24.jpg")));
		triangles.setFitWidth(300); triangles.setFitHeight(300);

		// Answers
		answers[0] = new Button("3"); answers[1] = new Button("V"); answers[2] = new Button("Se7en"); answers[3] = new Button("Ate");
		answers[0].setLayoutX(66); answers[0].setLayoutY(21);
		answers[1].setLayoutX(282); answers[1].setLayoutY(21);
		answers[2].setLayoutX(66); answers[2].setLayoutY(66);
		answers[3].setLayoutX(282); answers[3].setLayoutY(66);
		for(int i = 0; i < answers.length; i++) {
			answers[i].setFont(Font.font(15));
			answers[i].setPrefWidth(200);
			if(i != 2) {
				answers[i].setOnAction(e -> {
					lives--;
					window.close();
					gameOver("Merging Polygonal Error", "Tbh, this question shouldn't THAT hard");
				});
			}
		}
		answers[2].setOnAction(e -> {
			if(foundSecret == true) {
				Q25_alertBox.display();
				window.close();
				
			} else {
				window.close();
				report.EndScreen.display();
			}
		});
		
		// SplitPane
		SplitPane splitpane = new SplitPane();
		splitpane.setDividerPositions(0.4, 0.5);
		splitpane.setOrientation(Orientation.VERTICAL);
		splitpane.setPrefSize(350, 500);
		
		// VBox
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(question);
		
		// AnchorPane
		AnchorPane anchorpane = new AnchorPane();
		anchorpane.setPrefSize(160, 100);
		anchorpane.getChildren().addAll(answers[0], answers[1], answers[2], answers[3]);
		
		// Scene
		splitpane.getItems().addAll(vbox, triangles, anchorpane);
		Scene scene = new Scene(splitpane, 549, 494);
		window.setScene(scene);
		window.show();
	}

}
