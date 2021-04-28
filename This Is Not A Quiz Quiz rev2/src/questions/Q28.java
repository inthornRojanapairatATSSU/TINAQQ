package questions;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Q28 extends game.Main {
	
	static Button[] button = new Button[8];
	private static int good = rng(0, 7), bad = rng(0, 7), seeker = rng(0, 7);

	//////////////////////////////////////////////////////////////////
	//																//
	//					Pretty Much a Coin Flipper					//
	//																//
	// Oh boy, this one could anger some people if they're unlucky.	//
	// In this mini-game, there are 8 buttons.						//
	// One button will have the player proceed to the next question.//
	// One button will fail the player.								//
	// However, there is also one button that can expose the		//
	// fail button and it will have an exclamation mark.			//
	//																//
	// If the player doesn't feel confident or the buttons			//
	// happen to be stuck in each other, they can click the Reset	//
	// button to randomly position all of the buttons.				//
	//																//
	// I considered having three levels, meaning the player will	//
	// have to do this three times before they move onto the next	//
	// question, but I figured that this game is hellish than it	//
	// already is, so I left that out.								//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		while((good == seeker) || (seeker == bad) || (good == bad)) {
			good = rng(0, 7);
			bad = rng(0, 7);
			seeker = rng(0, 7);
		}
		
		Stage window = new Stage();
		window.setTitle(getTitle());
		
		Label question = new Label("Catch the button");
		question.setFont(Font.font(25));
		
		// Don't Click the Wrong Button!
		for(int i = 0; i < button.length; i++) {
			button[i] = new Button();
			button[i].setPrefSize(30, 30);
			button[i].setLayoutX(rng(14, 454)); button[i].setLayoutY(rng(14, 162));
		}
		button[good].setOnAction(e -> {
			window.close();
			questionNumber++;
			Q29.display();
		});
		button[seeker].setOnAction(e -> {
			button[bad].setText("!");
		});
		button[bad].setOnAction(e -> {
			lives--;
			window.close();
			gameOver("Game Over!", "You failed the secret run!");
		});
		
		// Reset
		Button reset = new Button("Reset");
		reset.setFont(Font.font(15));
		reset.setOnAction(e -> {
			button[bad].setText("");
			for(int i = 0; i < button.length; i++) {
				button[i].setLayoutX(rng(14, 454)); button[i].setLayoutY(rng(14, 162));
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
		vbox.getChildren().addAll(question, reset);
		
		// AnchorPane
		AnchorPane anchorpane = new AnchorPane();
		anchorpane.setPrefSize(160, 100);
		anchorpane.getChildren().addAll(button);
		
		// Scene
		splitpane.getItems().addAll(vbox, anchorpane);
		Scene scene = new Scene(splitpane, 500, 350);
		scene.setOnKeyPressed(e -> {
			if(e.getCode().toString().equalsIgnoreCase("S")) {
				if(skips > 0) {
					skips--;
					window.close();
					questionNumber++;
					Q29.display();
				}
			}
		});
		window.setScene(scene);
		window.show();
	}

}
