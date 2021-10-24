package dlc_halloween;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Q5 extends game.Main {
	
	private static Button[] answers = new Button[4];
	private static int correctAnswer = 0;

	//////////////////////////////////////////////////////////////////
	//																//
	//						Stupid Pun II							//
	//																//
	// Answer: Can these corn.										//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle(getTitle());
		
		// Control
		Label question = new Label("What's this?");
		question.setFont(Font.font(25)); question.setLayoutX(51); question.setLayoutY(50);
		
		// Image
		ImageView image = new ImageView(new Image(Q5.class.getResourceAsStream("dlcHalloweenImageQuestion5.jpg")));
		image.setFitWidth(300); image.setFitHeight(300);

		// Answers
		answers[0] = new Button("Candies Corn"); answers[1] = new Button("Trash Candy"); answers[2] = new Button("Trick or Treat"); answers[3] = new Button("Say No to Sugar");
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
					if(lives > 0) {
						window.setTitle(getTitle());
					}
					else {
						window.close();
						gameOver("Spooky!", "CANDY CANDY CANDYYYYYY");
					}
				});
			}
		}
		answers[correctAnswer].setOnAction(e -> {
			window.close();
			skips++;
			questionNumber++;
			game.SkipAlert.display();
			Q6.display();
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
					Q6.display();
				}
			}
		});
		window.setScene(scene);
		window.show();
	}

}
