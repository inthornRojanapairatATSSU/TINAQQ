package dlc_halloween;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Q10 extends game.Main {
	
	private static Button[] enemy = new Button[12];
	private static Button turret = new Button("");
	private static Button[] move = new Button[3];
	private static int enemies = 12;
	private static int spot = -1;

	//////////////////////////////////////////////////////////////////
	//																//
	//						  Space Invaders						//
	//																//
	// It is exactly what it is:									//
	// the player will be shooting (you won't be able to see		//
	// the projectile unfortunately) at the targets who will be		//
	// moving downwards with each shot.								//
	//																//
	// This mini-game is not too hard. Get rid of all the targets.	//
	//																//
	// The player only has up to one miss, so don't spam too hard.	//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 10 | Lives: " +lives +" | No skipping here!");
		
		// Setup
		//// Targets
		for(int i = 0; i < 6; i++) {
			enemy[i] = new Button("");
			enemy[i].setPrefSize(77, 34);
			enemy[i].setLayoutX(87 + (100 * i)); enemy[i].setLayoutY(74);
		} 
		for(int i = 6; i < 12; i++) {
			enemy[i] = new Button("");
			enemy[i].setPrefSize(77, 34);
			enemy[i].setLayoutX(87 + (100 * (i - 6))); enemy[i].setLayoutY(118);
		}
		
		//// Turret
		turret.setPrefSize(30, 80);
		turret.setLayoutX(360); turret.setLayoutY(446);
		
		//// Shoot/Directional Keys
		///// Shoot
		move[0] = new Button("S");
		move[0].setPrefSize(50, 50);
		move[0].setLayoutX(350); move[0].setLayoutY(616);
		move[0].setOnAction(e -> {
			switch(spot) {
				case 1:
					if(enemy[6].isVisible()) {
						enemy[6].setVisible(false);
						enemies--;
					} else if(enemy[0].isVisible()) {
						enemy[0].setVisible(false);
						enemies--;
					} break;
				case 2:
					if(enemy[7].isVisible()) {
						enemy[7].setVisible(false);
						enemies--;
					} else if(enemy[1].isVisible()) {
						enemy[1].setVisible(false);
						enemies--;
					} break;
				case 3:
					if(enemy[8].isVisible()) {
						enemy[8].setVisible(false);
						enemies--;
					} else if(enemy[2].isVisible()) {
						enemy[2].setVisible(false);
						enemies--;
					} break;
				case 4:
					if(enemy[9].isVisible()) {
						enemy[9].setVisible(false);
						enemies--;
					} else if(enemy[3].isVisible()) {
						enemy[3].setVisible(false);
						enemies--;
					} break;
				case 5:
					if(enemy[10].isVisible()) {
						enemy[10].setVisible(false);
						enemies--;
					} else if(enemy[4].isVisible()) {
						enemy[4].setVisible(false);
						enemies--;
					} break;
				case 6:
					if(enemy[11].isVisible()) {
						enemy[11].setVisible(false);
						enemies--;
					} else if(enemy[5].isVisible()) {
						enemy[5].setVisible(false);
						enemies--;
					} break;
				default:
					break;
			}
			if(spot != -1) {
				for(int i = 0; i < enemy.length; i++) {
					if(enemy[i].isVisible()) {
						enemy[i].setLayoutY(enemy[i].getLayoutY() + 23);
					}
					if(enemy[i].getLayoutY() > 397) {
						lives = 0;
						window.close();
						gameOver("Spooky!", "You failed to protect your base!");
						break;
					}
				}
			}
			if(enemies == 0) {
				window.close();
				skips++;
				questionNumber++;
				Q11.display();
			}
		});
		
		//// Left
		move[1] = new Button("L");
		move[1].setPrefSize(50, 50);
		move[1].setLayoutX(290); move[1].setLayoutY(616);
		move[1].setOnAction(e -> {
			switch(spot) {
				case -1:
					turret.setLayoutX(311);
					spot = 3; break;
				case 2: // Position 2
					turret.setLayoutX(111);
					spot = 1; break;
				case 3:
					turret.setLayoutX(211);
					spot = 2; break;
				case 4:
					turret.setLayoutX(311);
					spot = 3; break;
				case 5:
					turret.setLayoutX(411);
					spot = 4; break;
				case 6:
					turret.setLayoutX(511);
					spot = 5; break;
				default:
					break;
			}
		});
		
		//// Right
		move[2] = new Button("R");
		move[2].setPrefSize(50, 50);
		move[2].setLayoutX(410); move[2].setLayoutY(616);
		move[2].setOnAction(e -> {
			switch(spot) {
			case -1:
				turret.setLayoutX(411);
				spot = 4; break;
			case 1: // Position 2
				turret.setLayoutX(211);
				spot = 2; break;
			case 2:
				turret.setLayoutX(311);
				spot = 3; break;
			case 3:
				turret.setLayoutX(411);
				spot = 4; break;
			case 4:
				turret.setLayoutX(511);
				spot = 5; break;
			case 5:
				turret.setLayoutX(611);
				spot = 6; break;
			default:
				break;
		}
		});
		
		// AnchorPane
		AnchorPane anchorpane = new AnchorPane();
		anchorpane.setPrefSize(750, 698);
		anchorpane.getChildren().addAll(enemy);
		anchorpane.getChildren().addAll(turret);
		anchorpane.getChildren().addAll(move);
		
		// Scene
		Scene scene = new Scene(anchorpane, 750, 698);
		window.setScene(scene);
		window.show();
	}

}
