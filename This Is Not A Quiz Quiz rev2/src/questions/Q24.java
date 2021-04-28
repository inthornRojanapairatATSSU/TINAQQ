package questions;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Q24 extends game.Main {
	
	private static Button[] answers = new Button[5];
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle(getTitle());
		
		// Control
		Label question = new Label("What's the right button?");
		question.setFont(Font.font(25)); question.setLayoutX(51); question.setLayoutY(50);

		answers[0] = new Button("This one!"); answers[1] = new Button("Left of me!"); answers[2] = new Button("Right of me!"); answers[3] = new Button("Not me!"); answers[4] = new Button("Maybe me?");
		answers[0].setLayoutX(41); answers[0].setLayoutY(65);
		answers[1].setLayoutX(257); answers[1].setLayoutY(65);
		answers[2].setLayoutX(41); answers[2].setLayoutY(110);
		answers[3].setLayoutX(257); answers[3].setLayoutY(110);
		answers[4].setLayoutX(138); answers[4].setLayoutY(310);
		for(int i = 0; i < answers.length; i++) {
			answers[i].setFont(Font.font(15));
			answers[i].setPrefWidth(200);
			answers[i].setOnAction(e -> {
				lives--;
				window.close();
				gameOver("Wrong Button!", "You didn't click the right button");
			});
		}
		answers[1].setOnAction(e -> {
			if(answers[1].getText().equals("Definitely me!")) {
				window.close();
				questionNumber++;
				Q25.display();
			} else {
				lives--;
				window.close();
				gameOver("Wrong Button!", "You didn't click the right button");
			}
		});
		answers[4].setOnAction(e -> {
			answers[1].setText("Definitely me!");
			answers[4].setDisable(true);
		});
		
		// SplitPane
		SplitPane splitpane = new SplitPane();
		splitpane.setDividerPositions(0.4);
		splitpane.setOrientation(Orientation.VERTICAL);
		splitpane.setPrefSize(350, 500);
		
		// VBox
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(question);
		
		// ScrollPane
		ScrollPane scrollpane = new ScrollPane();
		scrollpane.setPrefSize(200, 200);
		
		// AnchorPane
		AnchorPane anchorpane = new AnchorPane();
		anchorpane.setPrefSize(477, 370);
		anchorpane.getChildren().addAll(answers[0], answers[1], answers[2], answers[3], answers[4]);
		scrollpane.setContent(anchorpane);
		
		// Scene
		splitpane.getItems().addAll(vbox, scrollpane);
		Scene scene = new Scene(splitpane, 500, 350);
		scene.setOnKeyPressed(e -> {
			if(e.getCode().toString().equalsIgnoreCase("S")) {
				if(skips > 0) {
					skips--;
					window.close();
					questionNumber++;
					Q25.display();
				}
			}
		});
		window.setScene(scene);
		window.show();
	}

}
