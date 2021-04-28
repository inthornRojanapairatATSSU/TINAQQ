package questions;

import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Q27 extends game.Main {
	
	private static Button[] answers = new Button[4];
	private static int correctAnswer = 3;

	//////////////////////////////////////////////////////////////////
	//																//
	//							Stupid Pun							//
	//																//
	// Answer: Clockwise											//
	// Guy's got a Nobel Prize.										//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle(getTitle());
		
		// Control
		Label question = new Label("What's this?");
		question.setFont(Font.font(25)); question.setLayoutX(51); question.setLayoutY(50);
		
		// Image
		ImageView image = new ImageView(new Image(Q27.class.getResourceAsStream("imageQuestion27.jpg")));
		image.setFitWidth(300); image.setFitHeight(300);

		// Answers
		answers[0] = new Button("Overclocked"); answers[1] = new Button("Nobel Caneman"); answers[2] = new Button("Old Timer"); answers[3] = new Button("Clockwise");
		answers[0].setLayoutX(66); answers[0].setLayoutY(20);
		answers[1].setLayoutX(282); answers[1].setLayoutY(20);
		answers[2].setLayoutX(66); answers[2].setLayoutY(65);
		answers[3].setLayoutX(282); answers[3].setLayoutY(65);
		for(int i = 0; i < answers.length; i++) {
			answers[i].setFont(Font.font(15));
			answers[i].setPrefWidth(200);
			if(i != correctAnswer) {
				answers[i].setOnAction(e -> {
					lives--;
					window.close();
					gameOver("Game Over!", "You failed the secret run!");
				});
			}
		}
		answers[correctAnswer].setOnAction(e -> {
			window.close();
			questionNumber++;
			Q28.display();
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
		splitpane.getItems().addAll(vbox, image, anchorpane);
		Scene scene = new Scene(splitpane, 549, 494);
		scene.setOnKeyPressed(e -> {
			if(e.getCode().toString().equalsIgnoreCase("S")) {
				if(skips > 0) {
					skips--;
					window.close();
					questionNumber++;
					Q28.display();
				}
			}
		});
		window.setScene(scene);
		window.show();
	}

}
