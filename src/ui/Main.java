package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	private PrimaryPageGUI primaryPage;
	
	public Main() throws IOException {
		primaryPage= new PrimaryPageGUI();
	}
	
	public static void main(String[] args) {
	launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		PrimaryPageGUI primaryPage= new PrimaryPageGUI();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("welcomePage.fxml"));
		fxmlLoader.setController(primaryPage);
		Parent parent = fxmlLoader.load();
	
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Bank Gestor");
		primaryStage.show();
	
	}
}
