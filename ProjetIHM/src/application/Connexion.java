package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Connexion extends Application { 

    @Override
    public void start(Stage primaryStage) {
    	
        BorderPane conn = new BorderPane();

        HBox hbox = new HBox();
        // ajuster le hbox en haut du BorderPane 
        conn.setTop(hbox);

        // ajoute le logo en haut à gaute de l'interface 
        ImageView imLogo = new ImageView(new Image(getClass().getResourceAsStream("/Photo/Logo.png")));
        imLogo.setFitHeight(90);
        imLogo.setFitWidth(200);

        // creation d'un espace entre les éléments 
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS); // avec le setHgrow on assure que l'espace occupera toute la largeure disponible sur le hbox

        // ajoute l'image de contact 
        ImageView imContact = new ImageView(new Image(getClass().getResourceAsStream("/Photo/contact.png")));
        imContact.setFitWidth(20);
        imContact.setFitHeight(20);

        // creation d'un bouton contact 
        MenuButton contact = new MenuButton("Contact", imContact);
        contact.setPrefSize(130, 50);
        // l'element de menu avec l'email du prof 
        MenuItem prof = new MenuItem("Contact par courriel : mr.crespin@profmath.fr");
        contact.getItems().add(prof);


        hbox.setPadding(new Insets(10, 20, 10, 20));
        //on ajoute les elements au hbox
        hbox.getChildren().addAll(imLogo, spacer, contact);


        VBox root = new VBox(15);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER); //on positione au centre 
        root.setStyle("-fx-background-color: #F5F5F5;");

        // ajoute l'image de connexion 
        Image imageConn = new Image(getClass().getResourceAsStream("/Photo/LogoT.png"));
        ImageView image_connexion = new ImageView(imageConn);
        image_connexion.setFitWidth(240);
        image_connexion.setPreserveRatio(true); // elle permet de maintenir le ratio de l'image lors de son redimensionnement 

        // ajout du titre 
        Label titre = new Label("Se connecter");
        titre.setFont(Font.font("Calibri", 24));
        titre.setTextAlignment(TextAlignment.CENTER); //on positione au centre
        titre.setStyle("-fx-font-weight: bold; -fx-text-fill: #2233AA;-fx-font-size: 20px;");

        // ajout du sous-titre 
        Label sous_titre = new Label("Connectez-vous pour accéder à vos cours, ressources.");
        sous_titre.setFont(Font.font("Calibri", 14));
        sous_titre.setTextAlignment(TextAlignment.CENTER); //on positione au centre

        // ajout d'un label email
        Label email = new Label("Email");
        email.setStyle("-fx-font-weight: bold; -fx-text-fill: #2233AA; -fx-font-size: 16px;");
        // definit un champs pour saisir l'email
        TextField zonetext = new TextField();
        zonetext.setPromptText("exemple@exemple.com");
        zonetext.setMaxWidth(300);
        zonetext.setStyle("-fx-border-color: gray; -fx-border-radius: 3px; -fx-font-size: 19px;");

        // ajout d'un label mot de passe
        Label mot_de_passe = new Label("Mot de passe");
        mot_de_passe.setStyle("-fx-font-weight: bold; -fx-text-fill: #2233AA; -fx-font-size: 16px;");
        
        // definit un champ pour saisir le mot de passe
        PasswordField mdp = new PasswordField();
        mdp.setStyle("-fx-border-color: gray; -fx-border-radius: 3px; -fx-font-size: 19px;");
        mdp.setMaxWidth(300);

        // ajout d'un bouton pour se connecter
        Button se_connecter = new Button("Se connecter");
        se_connecter.setStyle("-fx-background-color: #d6d6ce; -fx-text-fill: #2233AA; -fx-font-size: 14px; -fx-font-weight: bold;");
        
        Label messageErr = new Label();
        messageErr.setStyle("-fx-text-fill: red;");
        //Evenement pour le bouton se connecter
        se_connecter.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		String mailText = zonetext.getText();
        		String mdpText = mdp.getText();
        
        		//afficher un message d'erreur  en dessoous 
        		if(mailText.isEmpty() || mdpText.isEmpty()) {
        			messageErr.setText("Veuillez remplir les champs .");
        		}
        		else {
        			// ici je redirection vers ma page d'accueil
        			Stage accueil = new Stage();
        			Accueil accueilPage = new Accueil();
        			try {
        				accueilPage.start(accueil);
        				
        			} catch (Exception e) {
        				e.printStackTrace();
        			}
        		}
        	}
        });

        // ajouts des itemps dans le root
        root.getChildren().addAll(image_connexion, titre, sous_titre, email, zonetext, mot_de_passe, mdp, se_connecter, messageErr);
        conn.setCenter(root);

        // configuration de scene
        Scene scene = new Scene(conn, 900, 800);
        scene.getStylesheets().add(getClass().getResource("connexionCss.css").toExternalForm());
        primaryStage.setTitle("Connexion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); 
    }
}
