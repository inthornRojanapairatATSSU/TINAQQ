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

public class Q3 extends game.Main {
	
	private static Button[] answers = new Button[4];
	private static int correctAnswer = 3;
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle(getTitle());
		
		// Control
		Label question = new Label("What is red and smells like a blue moon?");
		question.setFont(Font.font(25)); question.setLayoutX(51); question.setLayoutY(50);

		answers[0] = new Button("Red Beer Can"); answers[1] = new Button("Paint"); answers[2] = new Button("Rising Sun"); answers[3] = new Button("Red Moon");
		answers[0].setLayoutX(41); answers[0].setLayoutY(65);
		answers[1].setLayoutX(257); answers[1].setLayoutY(65);
		answers[2].setLayoutX(41); answers[2].setLayoutY(110);
		answers[3].setLayoutX(257); answers[3].setLayoutY(110);
		for(int i = 0; i < answers.length; i++) {
			answers[i].setFont(Font.font(15));
			answers[i].setPrefWidth(200);
			if(i != correctAnswer) {
				answers[i].setOnAction(e -> {
					lives--;
					if(lives > 0) {
						window.setTitle(getTitle());
					}
					else {
						window.close();
						gameOver("Spooky!", "Winning on the first try is once in a blue moon");
					}
				});
			}
		}
		answers[correctAnswer].setOnAction(e -> {
			window.close();
			questionNumber++;
			Q4.display();
		});
		
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
		scene.setOnKeyPressed(e -> {
			if(e.getCode().toString().equalsIgnoreCase("S")) {
				if(skips > 0) {
					skips--;
					window.close();
					questionNumber++;
					Q4.display();
				}
			}
		});
		window.setScene(scene);
		window.show();
	}

}
