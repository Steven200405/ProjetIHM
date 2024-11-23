package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Figure {
    private final Stage stage;

    public Figure(Stage stage) {
        this.stage = stage;

    }

    public void afficher() {// Mettre le code d'affichage de Eleni ici
  
        StackPane root = new StackPane();
        Button button = new Button("Accueil");
        
        EventHandler <MouseEvent> allerAccueil = new EventHandler <MouseEvent> () {
			@Override
			public void handle (MouseEvent e) {
				Accueil cahierTexte= new Accueil(stage);
				cahierTexte.afficher(); // Naviguer vers Accueil
			}
		};
		button.addEventHandler(MouseEvent.MOUSE_CLICKED, allerAccueil);

        Scene scene = new Scene(root, 400, 300);
        root.getChildren().add(button);
        stage.setScene(scene);
        stage.setTitle("Belle Figure");
        stage.show();
    }
}
