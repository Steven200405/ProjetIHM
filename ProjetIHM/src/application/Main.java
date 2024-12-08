package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
    	try {
            primaryStage.setTitle("Cahier de textes");
            new CahierTexte(primaryStage);
            primaryStage.show();
			

    	} catch (Exception e) {
    			e.printStackTrace();
    	}

    }

    public static void main(String[] args) {
        launch(args);
    }
}

