package questions;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Q18 extends game.Main {
	
	private static Button[] answers = new Button[4];

	//////////////////////////////////////////////////////////////////
	//																//
	//						What Does This Mean?					//
	//																//
	// This question uses a Caesar's Cipher and it shifts letters	//
	// by 3.														//
	//																//
	// Answer: Press "U" to proceed.								//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Question 18 | Lives: " +lives);
		
		// Control
		Label question = new Label("Suhvv X wr surfhhg");
		question.setFont(Font.font(25)); question.setLayoutX(51); question.setLayoutY(50);

		answers[0] = new Button("Ehdqv"); answers[1] = new Button("Zkdw grhv wklv phdq?"); answers[2] = new Button("Flskhu"); answers[3] = new Button("Iuhqfk Iulhv");
		answers[0].setLayoutX(41); answers[0].setLayoutY(65);
		answers[1].setLayoutX(257); answers[1].setLayoutY(65);
		answers[2].setLayoutX(41); answers[2].setLayoutY(110);
		answers[3].setLayoutX(257); answers[3].setLayoutY(110);
		for(int i = 0; i < answers.length; i++) {
			answers[i].setFont(Font.font(15));
			answers[i].setPrefWidth(200);
			answers[i].setOnAction(e -> {
				lives--;
				window.close();
				gameOver("Ohwwhu Vkliw", "Lw'v dv hdvb dv rqh, wzr, wkuhh!");
			});
		}
		
		// SplitPane
		SplitPane splitpane = new SplitPane();
		splitpane.setDividerPositions(0.4);
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
		splitpane.getItems().addAll(vbox, anchorpane);
		Scene scene = new Scene(splitpane, 500, 350);
		scene.setOnKeyPressed(e -> {
			if(e.getCode().toString().equalsIgnoreCase("U")) {
				window.close();
				Q19.display();
			}
		});
		window.setScene(scene);
		window.show();
	}

}
