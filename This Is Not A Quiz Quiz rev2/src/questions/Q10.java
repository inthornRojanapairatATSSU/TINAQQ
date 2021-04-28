package questions;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Q10 extends game.Main {
	
	private static Button[] answers = new Button[4];
	private static int correctAnswer = 1;
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 10 | Lives: " +lives);
		
		// ImageView
		ImageView image = new ImageView(new Image(Q10.class.getResourceAsStream("imageQuestion10.jpg")));
		image.setFitWidth(300); image.setFitHeight(300);
		image.setPreserveRatio(true);

		answers[0] = new Button("Square Root of Life"); answers[1] = new Button("6.48"); answers[2] = new Button("Happiness"); answers[3] = new Button("42");
		answers[0].setLayoutX(66); answers[0].setLayoutY(45);
		answers[1].setLayoutX(282); answers[1].setLayoutY(45);
		answers[2].setLayoutX(66); answers[2].setLayoutY(90);
		answers[3].setLayoutX(282); answers[3].setLayoutY(90);
		for(int i = 0; i < answers.length; i++) {
			answers[i].setFont(Font.font(15));
			answers[i].setPrefWidth(200);
			if(i != correctAnswer) {
				answers[i].setOnAction(e -> {
					lives--;
					if(lives > 0) {
						window.setTitle("Question 10 | Lives: " +lives);
					}
					else {
						window.close();
						gameOver("Universal Miscalculation", "We get it, you're not good at math");
					}
				});
			}
		}
		answers[correctAnswer].setOnAction(e -> {
			window.close();
			Q11.display();
		});
		
		// SplitPane
		SplitPane splitpane = new SplitPane();
		splitpane.setDividerPositions(0.4);
		splitpane.setOrientation(Orientation.VERTICAL);
		splitpane.setPrefSize(549, 304);
		
		// AnchorPane
		AnchorPane anchorpane = new AnchorPane();
		anchorpane.setPrefSize(160, 100);
		anchorpane.getChildren().addAll(answers[0], answers[1], answers[2], answers[3]);
		
		// Scene
		splitpane.getItems().addAll(image, anchorpane);
		window.setScene(new Scene(splitpane, 549, 304));
		window.show();
	}

}
