package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Accueil extends Application {

    @Override
    public void start(Stage primaryStage) {
      
    	//héritage de la barre de navigation 
    	BarreNavigation barreNavigation = new BarreNavigation();
    	BorderPane root = barreNavigation.getBorderPane();

        
        // Contenu principal
        VBox content = new VBox(20);
        content.setPadding(new Insets(20));
        content.setAlignment(Pos.CENTER);
        root.setCenter(content);

        // Colonne pour les Cours
        VBox coursCol = new VBox(10);
        coursCol.setAlignment(Pos.TOP_LEFT); //on positione les éléments au centre 
        Label coursTitle = new Label("Cours");
        coursTitle.setStyle(" -fx-font-size: 16; -fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
     // definir un id "pas de css" afin d'exclure le coursTitle du css
        coursTitle.setId("pasdeCss");
        VBox.setMargin(coursTitle, new Insets(0, 0, 20, 0));
        
        // Ajouts des Items avec les Evénements 
        Label coursItem1 = new Label("Cahier de texte");
        
        //Evenement : 
        EventHandler<MouseEvent> cahierDeTexte = new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent e) {
        		CahierTexte cahiertextePage = new CahierTexte(primaryStage);
        		cahiertextePage.afficher();
        	}
        };
        
        coursItem1.addEventHandler(MouseEvent.MOUSE_CLICKED , cahierDeTexte);
       
        coursItem1.setStyle("-fx-font-weight: bold;-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        Label coursItem2 = new Label("Calcul mental");
        coursItem2.setStyle("-fx-font-weight: bold;-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
      //Evenement : 
        EventHandler<MouseEvent> calculMental = new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent e) {
        		CalculMental calculmentalPage = new CalculMental(primaryStage);
        		calculmentalPage.afficher();
        	}
        };
        coursItem2.addEventHandler(MouseEvent.MOUSE_CLICKED , calculMental);

        Label coursItem3 = new Label("Belle figures");
        coursItem3.setStyle("-fx-font-weight: bold;-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
      //Evenement : 
        EventHandler<MouseEvent> figureGeometrique = new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent e) {
        		Figure figureGeometriquePage = new Figure(primaryStage);
        		figureGeometriquePage.afficher();
        	}
        };
        coursItem3.addEventHandler(MouseEvent.MOUSE_CLICKED , figureGeometrique);
        

        Label coursItem4 = new Label("Géométrie");
        coursItem4.setStyle("-fx-font-weight: bold;-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
      //Evenement : 
        EventHandler<MouseEvent> geometrie = new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent e) {
        		Geometrie geometriePage = new Geometrie(primaryStage);
        		geometriePage.afficher();
        	}
        };
        coursItem4.addEventHandler(MouseEvent.MOUSE_CLICKED , geometrie);
        
        Label coursItem5 = new Label("Tableau de numération");
        coursItem5.setStyle("-fx-font-weight: bold;-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
        //Evenement : 
            EventHandler<MouseEvent> tableauNumeration = new EventHandler<MouseEvent>() {
            	@Override
            	public void handle(MouseEvent e) {
            		TableauNumeration numerationPage = new TableauNumeration(primaryStage);
            		numerationPage.afficher();
            	}
            };
            coursItem5.addEventHandler(MouseEvent.MOUSE_CLICKED , tableauNumeration);
        
        // Ajouts des elements à la colonne Cours
        coursCol.getChildren().addAll(coursTitle, coursItem1, coursItem2, coursItem3, coursItem4, coursItem5);

        // Colonne pour les Jeux
        VBox jeuxCol = new VBox(10);
        jeuxCol.setAlignment(Pos.TOP_LEFT);
        Label jeuxTitle = new Label("Jeux");
        VBox.setMargin(jeuxTitle, new Insets(0, 0, 20, 0));
        jeuxTitle.setStyle(" -fx-font-size: 16; -fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
        // definir un id "pas de css" afin d'exclure le jeuxTitle du css
        jeuxTitle.setId("pasdeCss");
        
        // Ajout des Items avec les Evénements 
        Label jeuxItem1 = new Label("Apprentissage du jeu d’échecs");
        
      //Evenement : 
        EventHandler<MouseEvent> echecs = new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent e) {
        		Echecs echecsPage = new Echecs (primaryStage);
        		echecsPage.afficher();
        	}
        };
        jeuxItem1.addEventHandler(MouseEvent.MOUSE_CLICKED , echecs);
        
        
        jeuxItem1.setStyle("-fx-font-weight: bold;-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        Label jeuxItem2 = new Label("Cartes à jouer");
        jeuxItem2.setStyle("-fx-font-weight: bold;-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
        
      //Evenement : 
        EventHandler<MouseEvent> cartes = new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent e) {
        		Carte cartesPage = new Carte (primaryStage);
        		cartesPage.afficher();
        	}
        };
        jeuxItem2.addEventHandler(MouseEvent.MOUSE_CLICKED , cartes);
        
        Label jeuxItem3 = new Label("Paper Toys");
        jeuxItem3.setStyle("-fx-font-weight: bold;-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
      //Evenement : 
        EventHandler<MouseEvent> paperToys = new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent e) {
        		PaperToys paperToysPage = new PaperToys (primaryStage);
        		paperToysPage.afficher();
        	}
        };
        jeuxItem3.addEventHandler(MouseEvent.MOUSE_CLICKED , paperToys);
        
        // Ajouts des elements à la colonne jeux
        jeuxCol.getChildren().addAll(jeuxTitle, jeuxItem1, jeuxItem2, jeuxItem3);

        
        // Colonne pour les Ressources externes
        VBox ressourcesCol = new VBox(10);
        ressourcesCol.setAlignment(Pos.TOP_LEFT);
        Label ressourcesTitle = new Label("Ressources externes");
        VBox.setMargin(ressourcesTitle, new Insets(0, 0, 20, 0));
        ressourcesTitle.setStyle("-fx-font-size: 16; -fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
        // definir un id "pas de css" afin d'exclure le ressourcesTitle du css
        ressourcesTitle.setId("pasdeCss");
        
       // Ajout des Items avec les Evénements 
        Label ressourcesItem1 = new Label("Portail d’informations mathématiques");
        ressourcesItem1.setStyle("-fx-font-weight: bold;-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
      //Evenement : 
        EventHandler<MouseEvent> ressourcesExternes = new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent e) {
        		RessourcesExternes ressourcesExternesPage = new RessourcesExternes (primaryStage);
        		ressourcesExternesPage.afficher();
        	}
        };
        ressourcesItem1.addEventHandler(MouseEvent.MOUSE_CLICKED , ressourcesExternes);
        
        
        
        Label ressourcesItem2 = new Label("Calculatrice");
        ressourcesItem2.setStyle("-fx-font-weight: bold;-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
      //Evenement : 
        EventHandler<MouseEvent> calculatrice = new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent e) {
        		Calculatrice calculatricePage = new Calculatrice (primaryStage);
        		calculatricePage.afficher();
        	}
        };
        ressourcesItem2.addEventHandler(MouseEvent.MOUSE_CLICKED , calculatrice);
        
        
        Label ressourcesItem3 = new Label("Algoblocs");
        ressourcesItem3.setStyle("-fx-font-weight: bold;-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
      //Evenement : 
        EventHandler<MouseEvent> algoblocs = new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent e) {
        		AlgoBlocs algoblocsPage = new AlgoBlocs (primaryStage);
        		algoblocsPage.afficher();
        	}
        };
        ressourcesItem3.addEventHandler(MouseEvent.MOUSE_CLICKED , algoblocs);
        
        
        
        Label ressourcesItem4 = new Label("LaboMEP");
        ressourcesItem4.setStyle("-fx-font-weight: bold;-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
      //Evenement : 
        EventHandler<MouseEvent> laboMEP = new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent e) {
        		LaboMEP laboMEPPage = new LaboMEP (primaryStage);
        		laboMEPPage.afficher();
        	}
        };
        ressourcesItem4.addEventHandler(MouseEvent.MOUSE_CLICKED , laboMEP);
        
        // Ajouts des elements à la colonne ressources
        ressourcesCol.getChildren().addAll(ressourcesTitle, ressourcesItem1, ressourcesItem2, ressourcesItem3, ressourcesItem4);

        HBox colonnes = new HBox(170, coursCol, jeuxCol, ressourcesCol);
        
        //ici j'ai utilisé le setHgrow sur mon Hbox afin d'ajuster mon interface en fonction de la taille de la fenetre 
        HBox.setHgrow(coursCol, Priority.ALWAYS);
        HBox.setHgrow(jeuxCol, Priority.ALWAYS);
        HBox.setHgrow(ressourcesCol, Priority.ALWAYS);
        
        colonnes.setAlignment(Pos.CENTER);
        
        content.getChildren().add(colonnes);

        // configuration de scene
        Scene scene = new Scene(root, 900, 600);
        // ajout du Css pour personnaliser notre interface
        scene.getStylesheets().add(getClass().getResource("Accueilstyle.css").toExternalForm());
        primaryStage.setTitle("Accueil");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
