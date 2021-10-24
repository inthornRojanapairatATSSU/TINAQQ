package questions;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.stage.*;

public class Shop extends Q12 {

	//////////////////////////////////////////////////////////////////
	//																//
	//						Cookie Clicker Shop						//
	//																//
	// A shop UI with buttons that increase how many more cookies	//
	// are gained per click.										//
	//																//
	// Upgrades require cookies to unlock.							//
	//																//
	// Getting the final upgrade closes the shop immediately.		//
	//																//
	//////////////////////////////////////////////////////////////////
	
	public static void store() {
		Stage stage = new Stage();
		stage.setTitle("WELCOME TO DA STORE");
		
		Button upgrade1 = new Button("+1 Cookie Click [10 Cookies]");
		upgrade1.setFont(Font.font(15));
		upgrade1.setOnAction(e -> {
			if(cookies >= 10 && upgrade == 0) {
				cookies -= 10;
				upgrade = 1;
				cookieCounter.setText(Integer.toString(cookies));
			}
		});
		Button upgrade2 = new Button("+5 Cookie Clicks [50 Cookies]");
		upgrade2.setFont(Font.font(15));
		upgrade2.setOnAction(e -> {
			if(cookies >= 50 && upgrade == 1) {
				cookies -= 50;
				upgrade = 2;
				cookieCounter.setText(Integer.toString(cookies));
			}
		});
		Button upgrade3 = new Button("+10 Cookie Clicks [200 Cookies]");
		upgrade3.setFont(Font.font(15));
		upgrade3.setOnAction(e -> {
			if(cookies >= 200 && upgrade == 2) {
				cookies -= 200;
				upgrade = 3;
				cookieCounter.setText(Integer.toString(cookies));
				stage.close();
			}
		});
		Button close = new Button("Close");
		close.setOnAction(e -> stage.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(upgrade1, upgrade2, upgrade3, close);
		layout.setAlignment(Pos.CENTER);
		
		stage.setScene(new Scene(layout, 300, 300));
		stage.show();
	}

}
