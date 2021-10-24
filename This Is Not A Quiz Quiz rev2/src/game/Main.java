package game;
	
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class Main extends Application {
	
	/*
	 * THIS IS NOT A QUIZ QUIZ: BEHIND THE SCENES AND OVERVIEW
	 * 
	 * A game inspired by the Impossible Quiz (2007), created
	 * by the user Splapp.
	 * 
	 * This game consists of a total 30 questions, but the player
	 * has access to half of that amount if they choose to select
	 * Easy and Normal.
	 * 
	 * Questions will contain answers, explanations, summary,
	 * and sometimes commentary.
	 * 
	 * If this is the player's first time in running this program,
	 * DO NOT OPEN THE QUESTIONS' CLASSES! You can tell yourself
	 * how stupid this game was after you completed it.
	 * 
	 * This is the second and completely revisioned build.
	 * 												- Inthorn R.
	 * 
	 */
	
	private Button[] difficultyButton = new Button[3];
	public static int lives, difficulty, skips = 0, questionNumber = 1, dlcMode = 0;
	public static boolean foundSecret = false;
	public static String title;
	private boolean warning = false;
	
	//////////////////////////////////////////////////////////////////
	//																//
	// 							Main Menu							//
	//																//
	// Includes a title image with three buttons that only			//
	// change the number of lives the player has.					//
	//																//
	// A secret button that unlocks five additional questions is	//
	// intended to appear outside the window.						//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("This Is Not a Quiz Quiz");
		
		// ImageView
		ImageView title = new ImageView(new Image(this.getClass().getResourceAsStream("title_halloweenupdate.jpg")));
		title.setFitWidth(400); title.setFitHeight(400);
		title.setLayoutX(33); title.setLayoutY(31);
		
		// Control
		Label newGame = new Label("Select difficulty level:");
		newGame.setFont(Font.font(26));
		newGame.setLayoutX(508); newGame.setLayoutY(56);
		
		// Choose Difficulty Buttons
		for(int i = 0; i < difficultyButton.length; i++) {
			switch(i) {
				case 0:
					difficultyButton[0] = new Button("Easy");
					difficultyButton[0].setOnAction(e -> {
						lives = 5; difficulty = 1;
						primaryStage.close();
						questions.Q1.display();
					});
				case 1:
					difficultyButton[1] = new Button("Normal");
					difficultyButton[1].setOnAction(e -> {
						lives = 3; difficulty = 2;
						primaryStage.close();
						questions.Q1.display();
					});
				case 2:
					difficultyButton[2] = new Button("Hard");
					difficultyButton[2].setOnAction(e -> {
						if(warning == false) {
							difficultyButton[2].setText("Are you sure?");
							warning = true;
						} else {
							lives = 1; difficulty = 3;
							primaryStage.close();
							questions.Q1.display();
						}
					});
			}
			difficultyButton[i].setFont(Font.font(20));
			difficultyButton[i].setPrefSize(239, 50);
			difficultyButton[i].setLayoutX(508); difficultyButton[i].setLayoutY(105 + (71 * i));
		}
		
		// "About" Button
		Button about = new Button("About");
		about.setPrefSize(114, 50); about.setFont(Font.font("System", FontWeight.BOLD, 20));
		about.setTextFill(Color.web("#15b91b"));
		about.setLayoutX(508); about.setLayoutY(354);
		about.setOnAction(e -> About.about());
		
		// "DLC" Button
		Button dlc = new Button("DLC");
		dlc.setPrefSize(114, 50); dlc.setFont(Font.font("System", FontWeight.BOLD, 20));
		dlc.setTextFill(Color.web("#ee8f2a"));
		dlc.setLayoutX(633); dlc.setLayoutY(354);
		dlc.setOnAction(e -> {
			lives = 3; difficulty = 2; dlcMode = 1;
			primaryStage.close();
			dlc_halloween.Q1.display();
		});
		
		// Secret Button
		Button secretButton = new Button("SECRET");
		secretButton.setPrefSize(132, 25);
		secretButton.setLayoutX(998); secretButton.setLayoutY(244);
		secretButton.setOnAction(e -> {
			foundSecret = true;
			secretButton.setText("Found secret!");
		});
		
		// AnchorPane
		AnchorPane layout = new AnchorPane();
		layout.getChildren().addAll(title, newGame, difficultyButton[0], difficultyButton[1], difficultyButton[2], about, dlc, secretButton);
		
		// Scene
		primaryStage.setScene(new Scene(layout, 822, 460));
		primaryStage.show();
	}
	
	//////////////////////////////////////////////////////////////////
	//																//
	//						   Get Variables						//
	//																//
	// If necessary, get methods will be used.						//
	// Otherwise, use public variables that are extended to			//
	// other classes.												//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static int getDifficulty() {
		return difficulty;
	}
	
	public static int getLives() {
		return lives;
	}
	
	public static boolean getSecret() {
		return foundSecret;
	}
	
	public static String getTitle() {
		title = ("Question " +questionNumber +" | Lives: " +lives +" | Skips: " +skips);
		return title;
	}
	
	public static int rng(int min, int max) {
		return (int)((Math.random() * (max - min)) + min);
	}

	//////////////////////////////////////////////////////////////////
	//																//
	//						Game Over Screen						//
	//																//
	// A game over screen will simply consist of a game over		//
	// message and two buttons that will allow the player to either //
	// try again from the start or close the game.					//
	//																//
	// If the player chooses to try again, the difficulty they		//
	// have selected beforehand is carried over.					//
	//																//
	// There are ten exit messages, though some of their labels		//
	// may be questionable.											//
	//																//
	//////////////////////////////////////////////////////////////////

	public static void gameOver(String title, String message) {
		final int randomNumber = rng(1, 10);
		Stage window = new Stage();
		
		window.setTitle(title);
		window.setMinWidth(500);
		window.setMinHeight(300);
		
		Label loser = new Label(message);
		loser.setFont(Font.font(25));
		Button tryAgain = new Button("Try Again");
		tryAgain.setFont(Font.font(15));
		tryAgain.setOnAction(e -> {
			switch(difficulty) {
				case 1:
					lives = 5; break;
				case 2:
					lives = 3; break;
				case 3:
					lives = 1; break;
			}
			
			if(dlcMode == 0) {
				window.close();
				questionNumber = 1;
				skips = 0;
				questions.Q1.display();
				
				// reset data
				questions.Q13.game = 1; questions.Q13.order = 1; questions.Q13.randomNumber1 = rng(400, 499); questions.Q13.randomNumber2 = rng(440, 460);
				questions.Q13.blBlank.setText("  "); questions.Q13.topBlank.setText("  ");
			} else {
				window.close();
				questionNumber = 1;
				skips = 0;
				dlc_halloween.Q1.display();
			}
		});
		
		Button exit = new Button();
		exit.setFont(Font.font(15));
		exit.setOnAction(e -> window.close());
		switch(randomNumber) {
			case 1:
				exit.setText("Exit"); break;
			case 2:
				exit.setText("Better luck next time"); break;
			case 3:
				exit.setText("Wow, that sucks"); break;
			case 4:
				exit.setText("I could've done better than that"); break;
			case 5:
				exit.setText("I believe in you!"); break;
			case 6:
				exit.setText("Absolutely terrible"); break;
			case 7:
				exit.setText("Go outside then come back in later"); break;
			case 8:
				exit.setText("This game is not sponsored"); break;
			case 9:
				exit.setText("Never gonna give you up"); break;
			case 10:
				exit.setText("Behind you"); break;
			default:
				exit.setText(" ");
		}
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(loser, tryAgain, exit);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
	}
	
}
