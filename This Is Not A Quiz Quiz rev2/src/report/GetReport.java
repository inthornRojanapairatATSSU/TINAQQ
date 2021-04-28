package report;

import java.sql.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.stage.*;

public class GetReport {

	static TextField firstName = new TextField();
	static TextField lastName = new TextField();
	static Statement statement;
	static Connection conn;
	
	public static void getName() {
		Stage window = new Stage();
		window.setTitle("Get names");
		window.initModality(Modality.APPLICATION_MODAL);
		
		////////////////////////////////////////// Connection to Database //////////////////////////////////////////
		connectToDB();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		firstName.setPromptText("First Name");
		lastName.setPromptText("Last Name");
		
		Button submit = new Button("Submit");
		submit.setOnAction(e -> {
			insertIntoDB();
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(firstName, lastName, submit);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout, 300, 300);
		window.setScene(scene);
		window.showAndWait();
	}
	
	public static void connectToDB() {
		System.out.println("Attempting connection to database");
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GUI_DB1", "inRojanapairat", "ssuCSC/tinaqq2021");
			System.out.println("Database is connected");
			statement = conn.createStatement();
		} catch(SQLException e) {
			System.out.println("Connection failed: " +e);
		}
	}
	
	public static void insertIntoDB() {
		try {
			String QueryDB = "insert into GUI_DB1.dbo.users(firstName, lastName) values ('" +firstName.getText() +"', '" +lastName.getText() +"')";
			statement.executeQuery(QueryDB);
			System.out.println("Data inserted");
		} catch(Exception e) {
			System.out.println("Data not inserted: " +e);
		}
	}

}
