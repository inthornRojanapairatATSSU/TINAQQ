package questions;

import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Q19 extends game.Main {
	
	private static Button[] answers = new Button[4];
	
	//////////////////////////////////////////////////////////////////
	//																//
	//								Chess							//
	//																//
	// Answer: Qg8+													//
	// The queen will check the king, then the rook is forced to	//
	// take that queen. White will play the knight to f7 to			//
	// checkmate the king since the black king is stuck with the	//
	// rook.														//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle(getTitle());
		
		// Control
		Label question = new Label("What's the best chess move? (White to play)");
		question.setFont(Font.font(25)); question.setLayoutX(51); question.setLayoutY(50);
		
		// Image
		ImageView chess = new ImageView(new Image(Q19.class.getResourceAsStream("imageQuestion19.png")));
		chess.setFitWidth(300); chess.setFitHeight(300);

		// Answers
		answers[0] = new Button("Flip the Board"); answers[1] = new Button("Qg8+"); answers[2] = new Button("Nf7#"); answers[3] = new Button("Pf4");
		answers[0].setLayoutX(66); answers[0].setLayoutY(20);
		answers[1].setLayoutX(282); answers[1].setLayoutY(20);
		answers[2].setLayoutX(66); answers[2].setLayoutY(65);
		answers[3].setLayoutX(282); answers[3].setLayoutY(65);
		for(int i = 0; i < answers.length; i++) {
			answers[i].setFont(Font.font(15));
			answers[i].setPrefWidth(200);
			if(i != 1) {
				answers[i].setOnAction(e -> {
					lives--;
					window.close();
					gameOver("Smooth Brain", "Sacrifices must be made!");
				});
			}
		}
		answers[1].setOnAction(e -> {
			window.close();
			questionNumber++;
			Q20.display();
		});
		
		// SplitPane
		SplitPane splitpane = new SplitPane();
		splitpane.setDividerPositions(0.4, 0.5);
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
		splitpane.getItems().addAll(vbox, chess, anchorpane);
		Scene scene = new Scene(splitpane, 549, 494);
		scene.setOnKeyPressed(e -> {
			if(e.getCode().toString().equalsIgnoreCase("S")) {
				if(skips > 0) {
					skips--;
					window.close();
					questionNumber++;
					Q20.display();
				}
			}
		});
		window.setScene(scene);
		window.show();
	}

}
