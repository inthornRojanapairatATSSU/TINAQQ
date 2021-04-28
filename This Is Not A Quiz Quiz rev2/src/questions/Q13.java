package questions;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.*;

public class Q13 extends game.Main {
	
	private static int game = 1, order = 1, randomNumber1 = rng(400, 499), randomNumber2 = rng(440, 460);
	static Scene scene1, scene2, scene3;
	static Button ulX = new Button("X"), submit = new Button("Submit"), confirm = new Button("LOCKED");

	//////////////////////////////////////////////////////////////////
	//																//
	//						Mini-Game Frenzy						//
	//																//
	// Yes, there's a lot to digest here. There are three			//
	// mini-games: Tic-Tac-Toe, Math Game (original, I know), and	//
	// adjuster. Scenes are switched if the player completes the	//
	// mini-game.													//
	//																//
	// Tic-Tac-Toe: The player will not be playing against a		//
	// bot. It is X-to-play. They'll have two turns to win.			//
	// Clicking the wrong spot will lose the player a life.			//
	//																//
	// Math Game: Click on the operators and numbers so the			//
	// equations are true.											//
	//																//
	// Adjuster: The player must guess. They can move onto the		//
	// next question if the button's text reads "CONFIRM."			//
	//																//
	// Answer:														//
	//		Tic-Tac-Toe												//
	//		Bottom left square, then top-right						//
	//																//
	//		Math Game												//
	//		4 + 24 = 28												//
	//		36 / 9 = 4												//
	//		7 * 8 = 56 (or 8 * 7 = 56)								//
	//																//
	//		Adjuster												//
	//		The correct number is randomly generated between		//
	//		440 and 460. Just mess around until the button			//
	//		says CONFIRM.											//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 13 | Lives: " +lives +" | No skipping here!");
		
		Label question = new Label("Win these mini-games!");
		question.setFont(Font.font(25)); question.setLayoutX(123); question.setLayoutY(80);
		
		// Tic-Tac-Toe
		ulX.setFont(Font.font(25)); ulX.setLayoutX(172); ulX.setLayoutY(165);
		Button topBlank = new Button("  "); topBlank.setFont(Font.font(25)); topBlank.setLayoutX(226); topBlank.setLayoutY(165);
		Button urBlank = new Button("  "); urBlank.setFont(Font.font(25)); urBlank.setLayoutX(283); urBlank.setLayoutY(165);
		Button mlO = new Button("O"); mlO.setFont(Font.font(25)); mlO.setLayoutX(170); mlO.setLayoutY(224);
		Button centerX = new Button("X"); centerX.setFont(Font.font(25)); centerX.setLayoutX(226); centerX.setLayoutY(224);
		Button mrX = new Button("X"); mrX.setFont(Font.font(25)); mrX.setLayoutX(282); mrX.setLayoutY(224); // not a Resident Evil reference
		Button blBlank = new Button("  "); blBlank.setFont(Font.font(25)); blBlank.setLayoutX(172); blBlank.setLayoutY(283);
		Button bottomO = new Button("O"); bottomO.setFont(Font.font(25)); bottomO.setLayoutX(224); bottomO.setLayoutY(283);
		Button brO = new Button("O"); brO.setFont(Font.font(25)); brO.setLayoutX(280); brO.setLayoutY(283);
		
		blBlank.setOnAction(e -> {
			if(order == 1) {
				blBlank.setText("X");
				topBlank.setText("O");
				order++;
			}
		});
		urBlank.setOnAction(e -> {
			if(order == 1) {
				loseALife();
			}
			else {
				window.setScene(scene2);
				game++;
			}
		});
		topBlank.setOnAction(e -> {
			if(order == 1) {
				loseALife();
			}
		});
		
		AnchorPane tictactoe = new AnchorPane();
		tictactoe.getChildren().addAll(question, ulX, topBlank, urBlank, mlO, centerX, mrX, blBlank, bottomO, brO);
		scene1 = new Scene(tictactoe, 500, 500);
		
		// Math Game
		Button operator1 = new Button("-"); operator1.setFont(Font.font(20)); operator1.setLayoutX(175); operator1.setLayoutY(127);
		operator1.setOnAction(e -> {
			switch(operator1.getText()) {
				case "+":
					operator1.setText("-"); break;
				case "-":
					operator1.setText("x"); break;
				case "x":
					operator1.setText("/"); break;
				case "/":
					operator1.setText("+"); break;
				default:
					operator1.setText("+"); break;
			}
		});
		
		Label top1 = new Label("4"); top1.setFont(Font.font(40)); top1.setLayoutX(139); top1.setLayoutY(120);
		Label top2 = new Label("24 = 28"); top2.setFont(Font.font(40)); top2.setLayoutX(225); top2.setLayoutY(120);
		
		Button operator2 = new Button("+"); operator2.setFont(Font.font(20)); operator2.setLayoutX(200); operator2.setLayoutY(199);
		operator2.setOnAction(e -> {
			switch(operator2.getText()) {
				case "+":
					operator2.setText("-"); break;
				case "-":
					operator2.setText("x"); break;
				case "x":
					operator2.setText("/"); break;
				case "/":
					operator2.setText("+"); break;
				default:
					operator2.setText("+"); break;
			}
		});
		Button number1 = new Button("1"); number1.setFont(Font.font(20)); number1.setLayoutX(245); number1.setLayoutY(199);
		number1.setOnAction(e -> {
			switch(Integer.parseInt(number1.getText())) {
				case 1:
					number1.setText("2"); break;
				case 2:
					number1.setText("3"); break;
				case 3:
					number1.setText("4"); break;
				case 4:
					number1.setText("5"); break;
				case 5:
					number1.setText("6"); break;
				case 6:
					number1.setText("7"); break;
				case 7:
					number1.setText("8"); break;
				case 8:
					number1.setText("9"); break;
				case 9:
					number1.setText("1"); break;
				default:
					number1.setText("1"); break;
			}
		});
		
		Label middle1 = new Label("36"); middle1.setFont(Font.font(40)); middle1.setLayoutX(145); middle1.setLayoutY(192);
		Label middle2 = new Label("= 4"); middle2.setFont(Font.font(40)); middle2.setLayoutX(296); middle2.setLayoutY(192);
		
		Button number2 = new Button("1"); number2.setFont(Font.font(20)); number2.setLayoutX(120); number2.setLayoutY(261);
		number2.setOnAction(e -> {
			switch(Integer.parseInt(number2.getText())) {
				case 1:
					number2.setText("2"); break;
				case 2:
					number2.setText("3"); break;
				case 3:
					number2.setText("4"); break;
				case 4:
					number2.setText("5"); break;
				case 5:
					number2.setText("6"); break;
				case 6:
					number2.setText("7"); break;
				case 7:
					number2.setText("8"); break;
				case 8:
					number2.setText("9"); break;
				case 9:
					number2.setText("1"); break;
				default:
					number2.setText("1"); break;
			}
		});
		Button operator3 = new Button("+"); operator3.setFont(Font.font(20)); operator3.setLayoutX(176); operator3.setLayoutY(261);
		operator3.setOnAction(e -> {
			switch(operator3.getText()) {
				case "+":
					operator3.setText("-"); break;
				case "-":
					operator3.setText("x"); break;
				case "x":
					operator3.setText("/"); break;
				case "/":
					operator3.setText("+"); break;
				default:
					operator3.setText("+"); break;
			}
		});
		Button number3 = new Button("1"); number3.setFont(Font.font(20)); number3.setLayoutX(226); number3.setLayoutY(261);
		number3.setOnAction(e -> {
			switch(Integer.parseInt(number3.getText())) {
				case 1:
					number3.setText("2"); break;
				case 2:
					number3.setText("3"); break;
				case 3:
					number3.setText("4"); break;
				case 4:
					number3.setText("5"); break;
				case 5:
					number3.setText("6"); break;
				case 6:
					number3.setText("7"); break;
				case 7:
					number3.setText("8"); break;
				case 8:
					number3.setText("9"); break;
				case 9:
					number3.setText("1"); break;
				default:
					number3.setText("1"); break;
			}
		});
		Button number4 = new Button("19"); number4.setFont(Font.font(20)); number4.setLayoutX(332); number4.setLayoutY(261);
		number4.setOnAction(e -> {
			switch(Integer.parseInt(number4.getText())) {
				case 19:
					number4.setText("31"); break;
				case 31:
					number4.setText("33"); break;
				case 33:
					number4.setText("50"); break;
				case 50:
					number4.setText("56"); break;
				case 56:
					number4.setText("62"); break;
				case 62:
					number4.setText("80"); break;
				case 80:
					number4.setText("92"); break;
				case 92:
					number4.setText("19"); break;
				default:
					number4.setText("19"); break;
			}
		});
		
		Label bottom = new Label("="); bottom.setFont(Font.font(40)); bottom.setLayoutX(286); bottom.setLayoutY(254);
		
		submit.setOnAction(e -> {
			if(operator1.getText() == "+" && operator2.getText() == "/" && number1.getText() == "9" && operator3.getText() == "x" && number4.getText() == "56") {
				if((number2.getText() == "7" && number3.getText() == "8") || (number2.getText() == "8" && number3.getText() == "7")) {
					window.setScene(scene3);
					game++;
				}
				else {
					loseALife();
				}
			}
			else {
				loseALife();
			}
		});
		submit.setFont(Font.font(25)); submit.setLayoutX(194); submit.setLayoutY(365);
		
		AnchorPane mathGame = new AnchorPane();
		mathGame.getChildren().addAll(operator1, top1, top2, operator2, number1, middle1, middle2, number2, operator3, number3, bottom, number4, submit);
		scene2 = new Scene(mathGame, 500, 500);
		
		// Adjuster
		Button addFour = new Button("+4"); addFour.setFont(Font.font(20)); addFour.setLayoutX(97); addFour.setLayoutY(141);
		Button addTwo = new Button("+2"); addTwo.setFont(Font.font(20)); addTwo.setLayoutX(97); addTwo.setLayoutY(199);
		Button minusOne = new Button("-1"); minusOne.setFont(Font.font(20)); minusOne.setLayoutX(100); minusOne.setLayoutY(257);
		Button minusThree = new Button("-3"); minusThree.setFont(Font.font(20)); minusThree.setLayoutX(100); minusThree.setLayoutY(315);
		confirm.setFont(Font.font(20)); confirm.setPrefWidth(150); confirm.setLayoutX(269); confirm.setLayoutY(261);
		
		Label counter = new Label(String.valueOf(randomNumber1)); counter.setFont(Font.font(50)); counter.setLayoutX(308); counter.setLayoutY(196);
		
		addFour.setOnAction(e -> {
			if((Integer.parseInt(counter.getText()) + 4) <= 499) {
				counter.setText(String.valueOf(Integer.parseInt(counter.getText()) + 4));
			}
			if(Integer.parseInt(counter.getText()) == randomNumber2) {
				confirm.setText("CONFIRM");
			}
			else {
				confirm.setText("LOCKED");
			}
		});
		addTwo.setOnAction(e -> {
			if((Integer.parseInt(counter.getText()) + 2) <= 499) {
				counter.setText(String.valueOf(Integer.parseInt(counter.getText()) + 2));
			}
			if(Integer.parseInt(counter.getText()) == randomNumber2) {
				confirm.setText("CONFIRM");
			}
			else {
				confirm.setText("LOCKED");
			}
		});
		minusOne.setOnAction(e -> {
			if((Integer.parseInt(counter.getText()) - 1) >= 400) {
				counter.setText(String.valueOf(Integer.parseInt(counter.getText()) - 1));
			}
			if(Integer.parseInt(counter.getText()) == randomNumber2) {
				confirm.setText("CONFIRM");
			}
			else {
				confirm.setText("LOCKED");
			}
		});
		minusThree.setOnAction(e -> {
			if((Integer.parseInt(counter.getText()) - 3) >= 400) {
				counter.setText(String.valueOf(Integer.parseInt(counter.getText()) - 3));
			}
			if(Integer.parseInt(counter.getText()) == randomNumber2) {
				confirm.setText("CONFIRM");
			}
			else {
				confirm.setText("LOCKED");
			}
		});
		confirm.setOnAction(e -> {
			if(confirm.getText() == "CONFIRM") {
				window.close();
				questionNumber++;
				Q14.display();
			}
			else {
				loseALife();
			}
		});
		
		
		AnchorPane adjuster = new AnchorPane();
		adjuster.getChildren().addAll(addFour, addTwo, minusOne, minusThree, counter, confirm);
		scene3 = new Scene(adjuster, 500, 500);
		
		window.setScene(scene1);
		window.show();
	}
	
	private static void loseALife() {
		lives--;
		if(lives > 0) {
			if(game == 1) {
				Stage stage = (Stage) ulX.getScene().getWindow();
				stage.setTitle("Question 13 | Lives: " +lives +" | No skipping here!");
			}
			else if(game == 2) {
				Stage stage = (Stage) submit.getScene().getWindow();
				stage.setTitle("Question 13 | Lives: " +lives +" | No skipping here!");
			}
			else {
				Stage stage = (Stage) confirm.getScene().getWindow();
				stage.setTitle("Question 13 | Lives: " +lives +" | No skipping here!");
			}
		}
		if(lives <= 0) {
			System.out.println("!!! GAME OVER !!!");
			if(game == 1) {
				Stage stage = (Stage) ulX.getScene().getWindow();
				stage.close();
				gameOver("Can't Always Be A Winner", "These mini-games might not be your thing");
			}
			else if(game == 2) {
				game = 1;
				Stage stage = (Stage) submit.getScene().getWindow();
				stage.close();
				gameOver("Can't Always Be A Winner", "These mini-games might not be your thing");
			}
			else {
				game = 1;
				Stage stage = (Stage) confirm.getScene().getWindow();
				stage.close();
				gameOver("Can't Always Be A Winner", "These mini-games might not be your thing");
			}
		}
	}

}
