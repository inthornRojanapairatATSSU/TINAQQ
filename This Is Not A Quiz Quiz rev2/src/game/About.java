package game;

import java.awt.Desktop;
import java.net.URI;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.*;

public class About {

	//////////////////////////////////////////////////////////////////
	//																//
	//							About Page							//
	//																//
	// Added Since: 5/4/2021										//
	// 																//
	// A simple about page! It includes a simplified overview of	//
	// the project along with a link to open its GitHub project		//
	// page.														//
	//																//
	//////////////////////////////////////////////////////////////////
	
	protected static void about() {
		Stage window = new Stage();
		window.setTitle("About");
		window.initModality(Modality.APPLICATION_MODAL);
		
		// Labels and Control
		Label madeBy1 = new Label("Made by");
		madeBy1.setFont(Font.font(35));
		madeBy1.setLayoutX(82); madeBy1.setLayoutY(38);
		Label madeBy2 = new Label("Inthorn A. Rojanapairat");
		madeBy2.setFont(Font.font(15));
		madeBy2.setLayoutX(74); madeBy2.setLayoutY(98);
		
		Label inspiredBy1 = new Label("Inspired by");
		inspiredBy1.setFont(Font.font(35));
		inspiredBy1.setLayoutX(64); inspiredBy1.setLayoutY(148);
		Label inspiredBy2 = new Label("The Impossible Quiz by Splapp");
		inspiredBy2.setFont(Font.font(15));
		inspiredBy2.setLayoutX(42); inspiredBy2.setLayoutY(209);
		
		Label madeUsing1 = new Label("Made using");
		madeUsing1.setFont(Font.font(35));
		madeUsing1.setLayoutX(59); madeUsing1.setLayoutY(259);
		Label madeUsing2 = new Label("Eclipse, JavaFX, and SceneBuilder");
		madeUsing2.setFont(Font.font(15));
		madeUsing2.setLayoutX(41); madeUsing2.setLayoutY(320);
		
		Button close = new Button("Close");
		close.setFont(Font.font(20)); close.setPrefWidth(175);
		close.setLayoutX(64); close.setLayoutY(419);
		close.setOnAction(e -> window.close());
		
		Hyperlink hyperlink = new Hyperlink("My GitHub");
		hyperlink.setFont(Font.font(25));
		hyperlink.setLayoutX(83); hyperlink.setLayoutY(362);
		hyperlink.setOnAction(e -> {
			try {
				openLink();
			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("Link is either broken or the page has been deleted. :(");
			}
		});
		
		// Layout - About
		AnchorPane anchorpane1 = new AnchorPane();
		anchorpane1.getChildren().addAll(madeBy1, madeBy2, inspiredBy1, inspiredBy2, madeUsing1, madeUsing2, hyperlink, close);
		
		// Scenes
		Scene scene1 = new Scene(anchorpane1, 300, 500);
		window.setScene(scene1);
		window.showAndWait();
	}
	
	private static void openLink() throws Exception {
		Desktop desktop = Desktop.getDesktop();
		desktop.browse(new URI("https://github.com/inthornRojanapairatATSSU/TINAQQ"));
	}

}
