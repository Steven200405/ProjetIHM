package application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
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
    
    public void start(Stage primaryStage) {
    	// enelever heritage 
    	BarreNavigation barreNavigation = new BarreNavigation();
    	BorderPane conn = barreNavigation.getBorderPane();
    	
    	
    	//garder contact 
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        
        //contenu : 
    	VBox root = new VBox(15);
    	
    	root.setPadding(new Insets(30));
    	root.setAlignment(Pos.CENTER);
    	root.setStyle("-fx-background-color: #F5F5F5;");
    	

    	// inserer une image (celle sur canva ) 
    	Image imageConn = new Image(getClass().getResourceAsStream("/Photo/LogoT.png"));
    	ImageView image_connexion = new ImageView(imageConn);
    	image_connexion.setFitWidth(240);
    	image_connexion.setPreserveRatio(true);
    	
        Label titre = new Label("Se connecter");
        titre.setFont(Font.font("Calibri",24));
        titre.setTextAlignment(TextAlignment.CENTER);
        titre.setStyle("-fx-font-weight: bold; -fx-font-size: 16; -fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");

        
        Label sous_titre = new Label ("Connectez-vous pour accéder à vos cours, ressources.");
        sous_titre.setFont(Font.font("Calibri", 14));
        sous_titre.setTextAlignment(TextAlignment.CENTER);
        
        
        Label email = new Label ("Email");
        email.setFont(Font.font("Calibri", 12));
        email.setStyle("-fx-font-weight: bold; -fx-font-size: 16; -fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
        TextField zonetext = new TextField();
        zonetext.setPromptText("exemple@exemple.com");
        zonetext.setMaxWidth(250);  
        
        
        Label mot_de_passe =   new Label ("Mot de passe");
        mot_de_passe.setFont(Font.font("Calibri", 12));
        mot_de_passe.setStyle("-fx-font-weight: bold; -fx-font-size: 16; -fx-text-fill: #2233AA; -fx-font-family: 'Calibri (MS)';");
        
        PasswordField mdp = new PasswordField();
        mdp.setMaxWidth(250);
        
        Button se_connecter = new Button("Se connecter");
        se_connecter.setStyle("-fx-background-color: #d6d6ce; -fx-text-fill: #2233AA; -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 10px 20px ; -fx-font-family: 'Calibri (MS)';");
        
        se_connecter.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		String mailText = zonetext.getText();
        		String mdpText = mdp.getText();
        		// verifier que c non null
        		
        		//afficher un message en dessoous 
        		if(mailText.isEmpty() || mdpText.isEmpty()) {
        			Alert alerter = new Alert(Alert.AlertType.WARNING);
        			alerter.setTitle("Erreur");
        			alerter.showAndWait();
        		}
        		else {
        			
        			Alert alerter = new Alert(Alert.AlertType.INFORMATION);
        			alerter.setTitle("Connexion à votre espace réussie");
        			alerter.showAndWait();
        			
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
        
        
        conn.setCenter(root);
        root.getChildren().addAll(image_connexion,titre,sous_titre,email,zonetext,mot_de_passe ,mdp,se_connecter);
        Scene scene = new Scene(conn,900,800);
        scene.getStylesheets().add(getClass().getResource("styleCahierTexte.css").toExternalForm());
        primaryStage.setTitle("Connexion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);  
    }
}
