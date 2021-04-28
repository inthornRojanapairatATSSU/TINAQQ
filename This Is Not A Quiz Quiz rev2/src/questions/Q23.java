package questions;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Q23 extends game.Main {
	
	private static Button[] pianoKey = new Button[6];
	private static String playOrder = "";

	//////////////////////////////////////////////////////////////////
	//																//
	//				Twinkle Twinkle Little Star Melody				//
	//																//
	// I was actually going to try and add piano keys to this, but	//
	// it would not work, so I settled with changing the window		//
	// title using String. The buttons are supposed to be piano		//
	// keys. The only way the player would figure this out is if	//
	// they look up a music sheet or they happen to know how to		//
	// play the melody.												//
	//																//
	// Answer: CCGGAAG												//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle(getTitle() +" |");
		
		Label question = new Label("Twinkle twinkle little star...");
		question.setFont(Font.font(25)); question.setLayoutX(51); question.setLayoutY(50);
		question.setTextAlignment(TextAlignment.CENTER);
		
		// Piano
		for(int i = 0; i < pianoKey.length; i++) {
			pianoKey[i] = new Button("");
			pianoKey[i].setPrefSize(52, 91);
			pianoKey[i].setLayoutY(31);
		}
		for(int i = 0; i < pianoKey.length; i++) {
			pianoKey[i].setLayoutX(28 + (78 * i));
		}
		pianoKey[0].setOnAction(e -> {
			if(playOrder.length() < 7) {
				playOrder += "C";
				window.setTitle(getTitle() +" | " +playOrder);
			}
		});
		pianoKey[1].setOnAction(e -> {
			if(playOrder.length() < 7) {
				playOrder += "D";
				window.setTitle(getTitle() +" | " +playOrder);
			}
		});
		pianoKey[2].setOnAction(e -> {
			if(playOrder.length() < 7) {
				playOrder += "E";
				window.setTitle(getTitle() +" | " +playOrder);
			}
		});
		pianoKey[3].setOnAction(e -> {
			if(playOrder.length() < 7) {
				playOrder += "F";
				window.setTitle(getTitle() +" | " +playOrder);
			}
		});
		pianoKey[4].setOnAction(e -> {
			if(playOrder.length() < 7) {
				playOrder += "G";
				window.setTitle(getTitle() +" | " +playOrder);
			}
		});
		pianoKey[5].setOnAction(e -> {
			if(playOrder.length() <= 7) {
				playOrder += "A";
				window.setTitle(getTitle() +" | " +playOrder);
			}
		});
		
		// Submit
		Button submit = new Button("How I wonder what you are...");
		submit.setPrefSize(179, 25);
		submit.setLayoutX(43); submit.setLayoutY(145);
		submit.setOnAction(e -> {
			if(playOrder.equalsIgnoreCase("CCGGAAG")) {
				window.close();
				skips++;
				questionNumber++;
				Q24.display();
			}
			else {
				lives--;
				window.close();
				gameOver("Not Enough Game Knowledge", "Haven't you planted saplings in your spare time?");
			}
		});
		
		// Reset
		Button reset = new Button("Reset");
		reset.setPrefSize(179, 25);
		reset.setLayoutX(277); reset.setLayoutY(145);
		reset.setOnAction(e -> {
			playOrder = "";
			window.setTitle(getTitle() +" |");
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
		anchorpane.getChildren().addAll(pianoKey[0], pianoKey[1], pianoKey[2], pianoKey[3], pianoKey[4], pianoKey[5], submit, reset);
		
		// Scene
		splitpane.getItems().addAll(vbox, anchorpane);
		Scene scene = new Scene(splitpane, 500, 350);
		scene.setOnKeyPressed(e -> {
			if(e.getCode().toString().equalsIgnoreCase("S")) {
				if(skips > 0) {
					skips--;
					window.close();
					questionNumber++;
					Q24.display();
				}
			}
		});
		window.setScene(scene);
		window.show();
	}

}
