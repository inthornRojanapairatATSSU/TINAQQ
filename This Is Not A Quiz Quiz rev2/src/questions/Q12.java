package questions;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Q12 extends game.Main {
	
	public static int cookies = 0, upgrade = 0;
	protected static Label cookieCounter = new Label(Integer.toString(cookies));

	//////////////////////////////////////////////////////////////////
	//																//
	//							Cookie Clicker						//
	//																//
	// A class that attempts to recreate cookie clicker. Nothing	//
	// crazy about it though.										//
	//																//
	// Uses the "cookies" variable as a form of currency.			//
	//																//
	// Answer: Have at least 750 cookies to move onto the next		//
	// question. Upgrading is not required, but it will speed up	//
	// the process.													//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 12 | Lives: " +lives + " | No skipping here!");
		
		// Counter
		Label label = new Label("Cookies:");
		label.setFont(Font.font(25)); label.setLayoutX(205); label.setLayoutY(29);
		cookieCounter.setFont(Font.font(25)); cookieCounter.setLayoutX(205); cookieCounter.setLayoutY(71);
		
		Button addCookie = new Button("Click Me!");
		addCookie.setFont(Font.font(15)); addCookie.setLayoutX(213); addCookie.setLayoutY(117);
		addCookie.setOnAction(e -> {
			if(upgrade == 0) {
				cookies++;
				cookieCounter.setText(Integer.toString(cookies));
			}
			else if(upgrade == 1) {
				cookies += 2;
				cookieCounter.setText(Integer.toString(cookies));
			}
			else if(upgrade == 2) {
				cookies += 7;
				cookieCounter.setText(Integer.toString(cookies));
			}
			else {
				cookies += 17;
				cookieCounter.setText(Integer.toString(cookies));
			}
		});
		Button shop = new Button("Shop");
		shop.setFont(Font.font(15)); shop.setLayoutX(228); shop.setLayoutY(160);
		shop.setOnAction(e -> {
			if(upgrade != 3) {
				Shop.store();
			}
		});
		Button nextQuestion = new Button("Next Question (750+ Cookies)");
		nextQuestion.setLayoutX(172); nextQuestion.setLayoutY(203);
		nextQuestion.setOnAction(e -> {
			if(cookies < 750) {
				lives--;
				if(lives > 0) {
					window.setTitle("Question 12 | Lives: " +lives +" | No skipping here!");
				}
				else {
					cookies = 0;
					window.close();
					gameOver("Bakery Shutdown", "Did you really fail at Cookie Clicker?");
				}
			}
			else {
				cookies = 0; upgrade = 0;
				window.close();
				questionNumber++;
				skips++;
				Q13.display();
			}
		});
		
		AnchorPane layout = new AnchorPane();
		layout.getChildren().addAll(label, cookieCounter, addCookie, shop, nextQuestion);
		window.setScene(new Scene(layout, 511, 257));
		window.show();
	}

}
