package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class BarreNavigation extends Application{ // Barre de navigation
	protected BorderPane root = new BorderPane();  // on reprend le conteneur dans chaque page du site
	
	public BarreNavigation() {	
		// Création d'un Hbox pour mettre tous les boutons sur une même ligne
		HBox hbox = new HBox();
		root.setTop(hbox); // Ajout du HBox dans la partie haute de BorderPane
		ImageView imLogo = new ImageView (new Image (getClass().getResourceAsStream("/Photo/Logo.png")));
		imLogo.setFitHeight(90);
		imLogo.setFitWidth(200);
			
		Region spacer = new Region(); // Region est un conteneur vide qui peut occuper l'espace horizontal/vertical 
		hbox.setHgrow(spacer, Priority.ALWAYS); // setHgrow spécifie comment l'espace sur la ligne va être occupé: Le nœud utilisera tout l'espace horizontal supplémentaire disponible.
		
		// Création des boutons
		Button accueil = new Button("Accueil");
		hbox.setMargin(accueil, new Insets(20, 0, 0, 0));
		accueil.setPrefSize(130, 50); // on définit la dimension à allouer pour le bouton : largeur, hauteur
			
		MenuButton ressource = new MenuButton("Ressources élèves");
		hbox.setMargin(ressource, new Insets(20, 0, 0, 0));
		ressource.setPrefSize(130, 50);
		MenuItem pronote = new MenuItem("Pronote");
		ressource.getItems().add(pronote);

		MenuButton outil = new MenuButton("Outils");
		hbox.setMargin(outil, new Insets(20, 0, 0, 0));
		MenuItem calculatrice = new MenuItem("Calculatrice");
		outil.setPrefSize(130, 50);
		outil.getItems().add(calculatrice);
			
		Button profil = new Button("Profil");
		hbox.setMargin(profil, new Insets(20, 0, 0, 0));
		profil.setPrefSize(130, 50);

		ImageView imContact = new ImageView (new Image (getClass().getResourceAsStream("/Photo/contact.png")));
		imContact.setFitWidth(20);
		imContact.setFitHeight(20);
		MenuButton contact = new MenuButton("Contact", imContact);
		contact.setPrefSize(130, 50);
		MenuItem prof = new MenuItem("Contact par courriel : mr.crespin@profmath.fr");
		contact.getItems().add(prof);
		hbox.setMargin(contact, new Insets(20, 0, 0, 0));
		
		// Ajoute tous les boutons au HBox
		hbox.getChildren().addAll(imLogo,spacer, accueil, outil, ressource, profil, contact);
			
		EventHandler <MouseEvent> allerAccueil = new EventHandler <MouseEvent> () {
			@Override
			public void handle(MouseEvent e) {
				//Redirection vers la page d'accueil
				Stage SecondaryStage = new Stage();
				Accueil accueil = new Accueil(SecondaryStage);	
				accueil.afficher(); // Naviguer vers Accueil
			}
			};		        
		accueil.addEventHandler(MouseEvent.MOUSE_CLICKED, allerAccueil);

		calculatrice.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//Redirection vers la page Outils
				Stage SecondaryStage = new Stage();
				Calculatrice calculatricePage = new Calculatrice(SecondaryStage);	
				calculatricePage.afficher(); // Naviguer vers Outils           
			}
        });

		pronote.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	String url = "https://ds.ac-bordeaux.fr/discovery/WAYF?entityID=https%3A%2F%2Fent2d.ac-bordeaux.fr%2Fshibboleth&return=https%3A%2F%2Fent2d.ac-bordeaux.fr%2FShibboleth.sso%2FLogin%3FSAMLDS%3D1%26target%3Dhttps%253A%252F%252Fent2d.ac-bordeaux.fr%252Fsacoche%252Findex.php%253Fsso%253D2484";
				getHostServices().showDocument(url);            }
        });
			
		EventHandler <MouseEvent> allerProfil = new EventHandler <MouseEvent> () {
			@Override
			public void handle(MouseEvent e) {
				//Redirection vers la page Profil
				Stage SecondaryStage = new Stage();
				Profil profilPage = new Profil(SecondaryStage);	
				profilPage.afficher(); // Naviguer vers Profil
			}
		};		        
		profil.addEventHandler(MouseEvent.MOUSE_CLICKED, allerProfil);
		  
	}
	@Override
	public void start(Stage primaryStage) {
		
	}
	public BorderPane getBorderPane() {
		return root;
	}
}
