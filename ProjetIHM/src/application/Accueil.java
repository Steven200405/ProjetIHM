package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Accueil extends Application {

    @Override
    public void start(Stage primaryStage) {
    	
    	
        // Barre de navigation
        BorderPane root = new BorderPane();
        HBox hbox = new HBox(10);
        root.setTop(hbox);
        ImageView imLogo = new ImageView(new Image(getClass().getResourceAsStream("/Photo/Logo.png")));
        imLogo.setFitHeight(90);
        imLogo.setFitWidth(200);
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS); 

        Button accueil = new Button("Accueil");        
        HBox.setMargin(accueil, new Insets(20, 0, 0, 0));
        accueil.setPrefSize(130, 50);

        MenuButton ressource = new MenuButton("Ressources élèves");
        HBox.setMargin(ressource, new Insets(20, 0, 0, 0));
        ressource.setPrefSize(130, 50);

        MenuButton outil = new MenuButton("Outils");
        HBox.setMargin(outil, new Insets(20, 0, 0, 0));
        outil.setPrefSize(130, 50);

        Button profil = new Button("Profil");
        HBox.setMargin(profil, new Insets(20, 0, 0, 0));
        profil.setPrefSize(130, 50);
        
        
        ImageView imContact = new ImageView(new Image(getClass().getResourceAsStream("/Photo/contact.png")));
        imContact.setFitWidth(20);
        imContact.setFitHeight(20);
        Button contact = new Button("Contact", imContact);
        HBox.setMargin(contact, new Insets(20, 0, 0, 0));
        contact.setPrefSize(130, 50);
        

        hbox.getChildren().addAll( spacer, accueil, outil, ressource, profil);

	
        // Contenu principal
    	
        VBox content = new VBox(20);
        content.setPadding(new Insets(20));
        content.setAlignment(Pos.CENTER);
        root.setCenter(content);

        // Colonne pour les Cours
        VBox coursCol = new VBox(10);
        coursCol.setAlignment(Pos.CENTER_LEFT);
        Label coursTitle = new Label("Cours");
        coursTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 16; -fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        Label coursItem1 = new Label("cahier de texte");
        coursItem1.setStyle("-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        Label coursItem2 = new Label("calcul mental");
        coursItem2.setStyle("-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        Label coursItem3 = new Label("belle figures");
        coursItem3.setStyle("-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        Label coursItem4 = new Label("géometrie");
        coursItem4.setStyle("-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        Label coursItem5 = new Label("tableau de numération");
        coursItem5.setStyle("-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        coursCol.getChildren().addAll(coursTitle, coursItem1, coursItem2, coursItem3, coursItem4, coursItem5);

        // Colonne pour les Jeux
        VBox jeuxCol = new VBox(10);
        jeuxCol.setAlignment(Pos.CENTER_LEFT);
        Label jeuxTitle = new Label("Jeux");
        jeuxTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 16; -fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        Label jeuxItem1 = new Label("Apprentissage du jeu d’échecs");
        jeuxItem1.setStyle("-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        Label jeuxItem2 = new Label("Cartes à jouer");
        jeuxItem2.setStyle("-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        Label jeuxItem3 = new Label("Paper Toys");
        jeuxItem3.setStyle("-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        jeuxCol.getChildren().addAll(jeuxTitle, jeuxItem1, jeuxItem2, jeuxItem3);

        // Colonne pour les Ressources externes
        VBox ressourcesCol = new VBox(10);
        ressourcesCol.setAlignment(Pos.CENTER_LEFT);
        Label ressourcesTitle = new Label("Ressources externes");
        ressourcesTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 16; -fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        Label ressourcesItem1 = new Label("Portail d’informations mathématiques");
        ressourcesItem1.setStyle("-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        Label ressourcesItem2 = new Label("Calcul Mental");
        ressourcesItem2.setStyle("-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        Label ressourcesItem3 = new Label("Algoblocs");
        ressourcesItem3.setStyle("-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        Label ressourcesItem4 = new Label("LaboMEP");
        ressourcesItem4.setStyle("-fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        ressourcesCol.getChildren().addAll(ressourcesTitle, ressourcesItem1, ressourcesItem2, ressourcesItem3, ressourcesItem4);

        HBox colonnes = new HBox(40, coursCol, jeuxCol, ressourcesCol);
        colonnes.setAlignment(Pos.CENTER);

        content.getChildren().add(colonnes);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Accueil");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
