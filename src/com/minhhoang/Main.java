package com.minhhoang;
	
import java.io.IOException;

import com.minhhoang.view.ConvertOverviewController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("COSC Grader Helper");
		
		initRootLayout();
		
		showConvertOverview();
		
	}
	
	
	/**
     * Initializes the root layout.
     */
	private void initRootLayout() {
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

    /**
     * Shows the convert overview inside the root layout.
     */
	private void showConvertOverview() {
		try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/ConvertOverview.fxml"));
            AnchorPane convertOverview = (AnchorPane) loader.load();
            
            rootLayout.setCenter(convertOverview);
            
            // Give the controller access to the main app.
            ConvertOverviewController controller = loader.getController();
            controller.setMain(this);

            // Set person overview into the center of root layout.
            rootLayout.setCenter(convertOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
