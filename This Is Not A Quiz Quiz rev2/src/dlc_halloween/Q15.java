package dlc_halloween;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Q15 extends game.Main {
	
	private static Button[] entity = new Button[2];
	private static Button[] action = new Button[4];
	private static int step = 1;
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 15 | Lives: " +lives +" | No skipping here! | KILL THE BAD GUY!");
		
		// Setup
		//// Player & Bad Guy
		entity[0] = new Button(">:)");
		entity[1] = new Button("):<");
		for(int i = 0; i < entity.length; i++) {
			entity[i].setPrefSize(69, 62);
			entity[i].setFont(Font.font(25));
		}
		entity[0].setLayoutX(80); entity[0].setLayoutY(257);
		entity[1].setLayoutX(425); entity[1].setLayoutY(54);
		
		//// GUI
		Label baddie = new Label("The Enemy");
		baddie.setFont(Font.font(17)); baddie.setLayoutX(231); baddie.setLayoutY(59);
		Label player = new Label("The Player");
		player.setFont(Font.font(17)); player.setLayoutX(337); player.setLayoutY(237);
		
		Label baddieHP = new Label("HP: 100");
		baddieHP.setFont(Font.font(17)); baddieHP.setLayoutX(244); baddieHP.setLayoutY(90);
		Label playerHP = new Label("HP: 100 | SP: 33");
		playerHP.setFont(Font.font(17)); playerHP.setLayoutX(318); playerHP.setLayoutY(263);
		
		action[0] = new Button("Punch");
		action[1] = new Button("Special");
		action[2] = new Button("Items");
		action[3] = new Button("Escape");
		for(int i = 0; i < action.length; i++) {
			action[i].setPrefSize(69, 25);
			action[i].setLayoutX(225 + (78 * i));
			action[i].setLayoutY(319);
		}
		action[2].setDisable(true);
		
		// Play
		action[3].setOnAction(e -> {
			lives = 0;
			window.close();
			gameOver("Spooky!", "You won zero gold and exp");
		});
		action[0].setOnAction(e -> {
			switch(step) {
				case 1:
					baddieHP.setText("HP: 68");
					playerHP.setText("HP: 73 | SP: 67");
					step = 2; break;
				case 2:
					baddieHP.setText("HP: 41");
					playerHP.setText("HP: 39 | SP: 100");
					playerHP.setFont(Font.font("System", FontWeight.BOLD, 17));
					step = 3; break;
				case 3:
					lives = 0;
					window.close();
					gameOver("Spooky!", "Oop, he critical hit you to death"); break;
			}
		});
		action[1].setOnAction(e -> {
			if(step == 3) {
				window.close();
				skips++;
				questionNumber++;
				FightWon.display();
				Q16.display();
			}
		});
		
		// AnchorPane
		AnchorPane anchorpane = new AnchorPane();
		anchorpane.setPrefSize(600, 400);
		anchorpane.getChildren().addAll(entity);
		anchorpane.getChildren().addAll(action);
		anchorpane.getChildren().addAll(baddie, baddieHP, player, playerHP);
		
		// Scene
		Scene scene = new Scene(anchorpane, 600, 400);
		window.setScene(scene);
		window.show();
	}

}
