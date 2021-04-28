package report;

import java.io.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.*;

public class EndScreen extends game.Main {
	
	static String difficultyToString, performanceGrade, finalNotes;
	public static boolean hardPlus = false;
	
	public static void display() {
		generateReport();
		final String report = "THIS IS NOT A QUIZ QUIZ: GAME REPORT\n\n"
				+ "Difficulty: " +difficultyToString +"\n\n"
				+ "Lives: " +lives +"\n\n"
				+ "Skips: " +skips +"\n\n"
				+ "Secret: " +foundSecret +"\n\n"
				+ "Final Grade: " +performanceGrade +"\n\n"
				+ finalNotes;
		
		Stage window = new Stage();
		window.setTitle("Congratulations!");
		
		Label message = new Label("Congratulations!"); message.setFont(Font.font(30)); message.setLayoutX(140); message.setLayoutY(107);
		Button getReport = new Button("Get Report"); getReport.setFont(Font.font(25)); getReport.setPrefWidth(200); getReport.setLayoutX(150); getReport.setLayoutY(186);
		getReport.setOnAction(e -> {
			GetReport.getName();
			FileChooser fileChooser = new FileChooser();
			
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT Files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			
			File file = fileChooser.showSaveDialog(window);
			
			if(file != null) {
				saveToFile(report, file);
			}
		});
		Button hardPlusMode = new Button("I Want More!");
		hardPlusMode.setFont(Font.font(25)); hardPlusMode.setPrefWidth(200); hardPlusMode.setLayoutX(150); hardPlusMode.setLayoutY(264);
		if(difficulty == 3) {
			hardPlusMode.setOnAction(e -> {
				window.close();
				questionNumber = 16;
				questions.Q16.display();
				difficulty = 4;
			});
		} else {
			hardPlusMode.setDisable(true);
		}
		Button close = new Button("Close"); close.setFont(Font.font(25)); close.setPrefWidth(200); close.setLayoutX(150); close.setLayoutY(342);
		close.setOnAction(e -> window.close());
		
		AnchorPane layout = new AnchorPane();
		layout.getChildren().addAll(message, getReport, hardPlusMode, close);
		window.setScene(new Scene(layout, 500, 500));
		window.show();
	}
	
	private static void saveToFile(String content, File file) {
		try {
			PrintWriter writer = new PrintWriter(file);
			writer.println(content);
			writer.close();
		} catch(IOException ex) {
			System.out.println("Cannot write to text file: " +ex);
		}
	}
	
	private static void generateReport() {
		switch(difficulty) {
			case 1:
				difficultyToString = "Easy"; break;
			case 2:
				difficultyToString = "Normal"; break;
			case 3:
				difficultyToString = "Hard"; break;
			case 4:
				difficultyToString = "Hard Plus"; break;
			case 5:
				difficultyToString = "Impossible"; break;
			default:
				difficultyToString = "error"; break;
		}
		if(difficulty == 1) {
			finalNotes = "Final Notes: We all start somewhere.";
			switch(lives) {
				case 1:
					performanceGrade = "F"; break;
				case 2:
					performanceGrade = "D"; break;
				case 3:
					performanceGrade = "C"; break;
				case 4:
					performanceGrade = "B"; break;
				case 5:
					performanceGrade = "B+"; break;
				default:
					performanceGrade = "error"; break;
			}
		}
		else if(difficulty == 2) {
			finalNotes = "Final Notes: Try out hard mode!";
			switch(lives) {
				case 1:
					performanceGrade = "F"; break;
				case 2:
					performanceGrade = "C"; break;
				case 3:
					performanceGrade = "A"; break;
				default:
					performanceGrade = "error"; break;
			}
		}
		else if(difficulty == 4) {
			finalNotes = "Final Notes: If you find the secret, you unlock additional questions!";
			performanceGrade = "S";
		}
		else if(difficulty == 5) {
			finalNotes = "Final Notes: Congrats on 100% completion! Now what?";
			performanceGrade = "S+";
		}
		else {
			finalNotes = "Final Notes: Do you have what it takes to go even further beyond?";
			performanceGrade = "A+";
		}
	}

}
