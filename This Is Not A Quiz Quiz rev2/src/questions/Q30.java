package questions;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Q30 extends game.Main {
	
	private static Button[] button = new Button[4];
	private static int reservedSkips = 0;
	
	//////////////////////////////////////////////////////////////////
	//																//
	//							Is It Over?							//
	//																//
	// The ending. Another question that was inspired by the		//
	// Impossible Quiz.												//
	//																//
	// Answer: Never use a single skip. Click on all four buttons	//
	// until they have an "S" on them. Click one of the squares		//
	// again to go back to the completion screen. A new report will	//
	// be generated.												//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle(getTitle());
		
		Label question = new Label("Do you have enough?");
		question.setFont(Font.font(25));
		
		for(int i = 0; i < button.length; i++) {
			button[i] = new Button();
			button[i].setPrefSize(101, 90);
			button[i].setLayoutX(18 + (120 * i)); button[i].setLayoutY(34);
			button[i].setFont(Font.font(15));
		}
		button[0].setOnAction(e -> {
			if(button[0].getText().equals("") && skips > 0) {
				button[0].setText("S");
				reservedSkips++; skips--;
				window.setTitle(getTitle());
			}
			else if(reservedSkips == 4) {
				window.close();
				report.EndScreen.display();
			}
		});
		button[1].setOnAction(e -> {
			if(button[1].getText().equals("") && skips > 0) {
				button[1].setText("S");
				reservedSkips++; skips--;
				window.setTitle(getTitle());
			}
			else if(reservedSkips == 4) {
				window.close();
				report.EndScreen.display();
			}
		});
		button[2].setOnAction(e -> {
			if(button[2].getText().equals("") && skips > 0) {
				button[2].setText("S");
				reservedSkips++; skips--;
				window.setTitle(getTitle());
			}
			else if(reservedSkips == 4) {
				window.close();
				report.EndScreen.display();
			}
		});
		button[3].setOnAction(e -> {
			if(button[3].getText().equals("") && skips > 0) {
				button[3].setText("S");
				reservedSkips++; skips--;
				window.setTitle(getTitle());
			}
			else if(reservedSkips == 4) {
				window.close();
				report.EndScreen.display();
			}
		});
		
		Button fail = new Button("I Don't...");
		fail.setLayoutX(223); fail.setLayoutY(147);
		fail.setOnAction(e -> {
			lives--;
			window.close();
			gameOver("Game Over!", "You failed the secret run!");
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
		anchorpane.getChildren().addAll(button[0], button[1], button[2], button[3], fail);
		
		// Scene
		splitpane.getItems().addAll(vbox, anchorpane);
		window.setScene(new Scene(splitpane, 500, 350));
		window.show();
	}

}
