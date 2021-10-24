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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Q18 extends game.Main {
	
	private static Button[] answers = new Button[4];
	private static int correctAnswer = 0;
	private static int fix = 0;
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 18 | Lives: " +lives +" | No skipping here!");
		
		// Control
		Label question = new Label("Are any of these correct?");
		question.setFont(Font.font(25)); question.setLayoutX(51); question.setLayoutY(50);
		question.setTextAlignment(TextAlignment.CENTER);

		answers[0] = new Button(""); answers[1] = new Button("No"); answers[2] = new Button("Nope"); answers[3] = new Button("Not at all");
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
						window.setTitle("Question 18 | Lives: " +lives +" | No skipping here!");
					}
					else {
						window.close();
						gameOver("Spooky!", "It did say no...");
					}
				});
			}
		}
		answers[correctAnswer].setOnAction(e -> {
			switch(fix) {
				case 0:
					answers[0].setText("N");
					fix++; break;
				case 1:
					answers[0].setText("Na");
					fix++; break;
				case 2:
					answers[0].setText("Nay");
					fix++; break;
				case 3:
					answers[0].setText("Nay (");
					fix++; break;
				case 4:
					answers[0].setText("Nay (P");
					fix++; break;
				case 5:
					answers[0].setText("Nay (Pr");
					fix++; break;
				case 6:
					answers[0].setText("Nay (Pre");
					fix++; break;
				case 7:
					answers[0].setText("Nay (Pres");
					fix++; break;
				case 8:
					answers[0].setText("Nay (Press");
					fix++; break;
				case 9:
					answers[0].setText("Nay (Press Y)");
					fix++; break;
				case 10:
					lives--;
					if(lives > 0) {
						window.setTitle("Question 18 | Lives: " +lives +" | No skipping here!");
					}
					else {
						window.close();
						gameOver("Spooky!", "It did say no...");
					}
				default:
					break;
			}
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
			if(e.getCode().toString().equalsIgnoreCase("Y")) {
				window.close();
				questionNumber++;
				Q19.display();
			}
		});
		window.setScene(scene);
		window.show();
	}

}
