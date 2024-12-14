package application;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.Region;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Button;


public class Profil {
    private final Stage stage;

    public Profil(Stage stage) {
        this.stage = stage;

    }


public class Profil extends Application{
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		
        HBox barreNav = new HBox();

        ImageView imLogo = new ImageView (new Image (getClass().getResourceAsStream("/Photo/Logo.png")));
        imLogo.setFitHeight(90);
        imLogo.setFitWidth(200);
        Region spacer = new Region(); // Region est un conteneur- vide qui peut occuper l'espace horizontal/vertical 
        barreNav.setHgrow(spacer, Priority.ALWAYS); // setHgrow spécifit comment l'espace sur la ligne va être occupé.
        
        Button accueil = new Button("Accueil");        
        barreNav.setMargin(accueil, new Insets(20, 0, 0, 0));
        accueil.setPrefSize(130, 50);
        MenuButton ressource = new MenuButton("Ressources élèves");
        barreNav.setMargin(ressource, new Insets(20, 0, 0, 0));
        ressource.setPrefSize(130, 50);

        MenuButton outil = new MenuButton("Outils");
        barreNav.setMargin(outil, new Insets(20, 0, 0, 0));
        outil.setPrefSize(130, 50);

        Button profil = new Button("Profil");
        barreNav.setMargin(profil, new Insets(20, 0, 0, 0));
        profil.setPrefSize(130, 50);

        ImageView imContact = new ImageView (new Image (getClass().getResourceAsStream("/Photo/contact.png")));
        imContact.setFitWidth(20);
        imContact.setFitHeight(20);
        Button contact = new Button("Contact", imContact);
        barreNav.setMargin(contact, new Insets(20, 0, 0, 0));
        contact.setPrefSize(130, 50);
        
        barreNav.getChildren().addAll(imLogo,spacer, accueil, outil, ressource, profil, contact);
        root.setTop(barreNav);

        // Contenu de la page Profil
        Label titre = new Label("Profil");
        titre.setFont(Font.font("Calibri",FontWeight.BOLD,75));
        titre.setTextFill(Color.web("#2233AA"));
		
	//Création d'une image de photo de profil
        Image img = new Image(getClass().getResourceAsStream("/Photo/PDPVide.png"));
		ImageView Affichage = new ImageView(img);
		Affichage.setFitHeight(350);
		Affichage.setFitWidth(250);
		
		//Création des Label, avec légende et données réels, et décoration 
		Label nom = new Label("Nom: ");
		nom.setFont(Font.font("Calibri",FontWeight.BOLD,25));
		nom.setTextFill(Color.web("#2233AA"));
		Label nomReel = new Label("Huang");
		nomReel.setFont(Font.font("Calibri",25));
		nomReel.setTextFill(Color.web("#2233AA"));

		Label prenom = new Label("Prenom: ");
		prenom.setFont(Font.font("Calibri",FontWeight.BOLD,25));
		prenom.setTextFill(Color.web("#2233AA"));
		Label prenomReel = new Label("Steven");
		prenomReel.setFont(Font.font("Calibri",25));
		prenomReel.setTextFill(Color.web("#2233AA"));
		
		Label dateNais = new Label("Date de Naissance: ");
		dateNais.setFont(Font.font("Calibri",FontWeight.BOLD,25));
		dateNais.setTextFill(Color.web("#2233AA"));
		Label dateNaisReel = new Label("29/05/2004");
		dateNaisReel.setFont(Font.font("Calibri", 25));
		dateNaisReel.setTextFill(Color.web("#2233AA"));
		
		// Création d'images cliquables pour la modification des données
		Image modifImage=new Image(getClass().getResourceAsStream("/Photo/Modifier.png"));
		ImageView modifImageAffichage = new ImageView(modifImage);
		ImageView modifImageAffichage2 = new ImageView(modifImage);
		ImageView modifImageAffichage3 = new ImageView(modifImage);
		ImageView modifImageAffichage4= new ImageView(modifImage);
		
		// Ajuste la taille des images
		modifImageAffichage.setFitWidth(20); 
		modifImageAffichage.setFitHeight(20);
		modifImageAffichage2.setFitWidth(20); 
		modifImageAffichage2.setFitHeight(20);
		modifImageAffichage3.setFitWidth(20); 
		modifImageAffichage3.setFitHeight(20);
		modifImageAffichage4.setFitWidth(20); 
		modifImageAffichage4.setFitHeight(20);
		
		// Création d'un bouton qu'on lui associe l'image crée et on lui ajoute un événement
		Button modifDateNais = new Button();
		modifDateNais.setGraphic(modifImageAffichage);
		modifDateNais.setOnMouseEntered(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent event) { // ?
        		interactionButton(modifDateNais,1.2);
        	}
        });
		modifDateNais.setOnMouseExited(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent event) {
        		interactionButton(modifDateNais,1);
        	}
        });
		modifDateNais.setPadding(new Insets(0,0,0,0));
		modifDateNais.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
					modifDialog(dateNaisReel,"date de naissance");
				}
		});
		
		Label email = new Label("Email: ");
		email.setFont(Font.font("Calibri",FontWeight.BOLD,25));
		email.setTextFill(Color.web("#2233AA"));
		Label emailReel = new Label("huangsteven2004@gmail.com");
		emailReel.setFont(Font.font("Calibri",25));
		emailReel.setTextFill(Color.web("#2233AA"));
		HBox ligneEmail = new HBox();
		Button modifEmail = new Button();
		modifEmail.setGraphic(modifImageAffichage2);
		modifEmail.setOnMouseEntered(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent event) {
        		interactionButton(modifEmail,1.2);
        	}
        });
		modifEmail.setOnMouseExited(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent event) {
        		interactionButton(modifEmail,1);
        	}
        });
		modifEmail.setPadding(new Insets(0,0,0,0));
		
		ligneEmail.getChildren().addAll(email,emailReel,modifEmail);
		ligneEmail.setAlignment(Pos.CENTER_LEFT);
		modifEmail.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
					modifDialog(emailReel,"email");
				}
		});
		
		Label mdp = new Label("Mdp: ");
		mdp.setFont(Font.font("Calibri",FontWeight.BOLD,25));
		mdp.setTextFill(Color.web("#2233AA"));
		Label mdpReel = new Label("********");
		mdpReel.setFont(Font.font("Calibri",25));
		mdpReel.setTextFill(Color.web("#2233AA"));
		Button modifMdp = new Button();
		modifMdp.setGraphic(modifImageAffichage3);

		modifMdp.setOnMouseEntered(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent event) {
        		interactionButton(modifMdp,1.2);
        	}
        });
		modifMdp.setOnMouseExited(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent event) {
        		interactionButton(modifMdp,1);
        	}
        });
		modifMdp.setPadding(new Insets(0,0,0,0));
		Label mdpMauvais = new Label("Mot de passe incorrecte, veuillez réessayer");
		mdpMauvais.setOpacity(0);
		mdpMauvais.setFont(Font.font("Calibri",FontWeight.BOLD, 15));
		mdpMauvais.setTextFill(Color.web("#2233AA"));

		modifMdp.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				TextInputDialog verif = new TextInputDialog();
				verif.setTitle("Confirmation Mot de Passe");
				verif.setHeaderText("Confirmation du Mot de Passe");
				verif.setContentText("Saisissez le mot de passe actuel: ");
				verif.getDialogPane().setStyle("-fx-font-size: 13; -fx-font-family:Calibri; -fx-font-weight:Bold; -fx-background-color: #F5F5F5");
				Optional<String> result = verif.showAndWait();
				if(result.isPresent()) {
					if(mdpReel.getText().equals(result.get())){
						mdpMauvais.setOpacity(0);
						modifDialog(mdpReel,"mot de passe");
					}
					else {
						mdpMauvais.setOpacity(1);
					}
				}
				}
		});
		
		Label statut = new Label("Élève: ");
		statut.setFont(Font.font("Calibri",FontWeight.BOLD,25));
		statut.setTextFill(Color.web("#2233AA"));
		Label statutReel = new Label("Élève");
		statutReel.setFont(Font.font("Calibri",25));
		statutReel.setTextFill(Color.web("#2233AA"));
		
		Button modifStatut = new Button();
		modifStatut.setGraphic(modifImageAffichage4);
		modifStatut.setOnMouseEntered(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent event) {
        		interactionButton(modifStatut,1.2);
        	}
        });
		modifStatut.setOnMouseExited(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent event) {
        		interactionButton(modifStatut,1);
        	}
        });
		
		modifStatut.setPadding(new Insets(0,0,0,0));
		modifStatut.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
					modifDialog(statutReel,"statut");
				}
		});
		GridPane grille = new GridPane();
		grille.add(nom,0, 0,3,1);
		grille.add(prenom, 0, 1,3,1);
		grille.add(dateNais,0,2,3,1);
		grille.add(email,0,3,3,1);
		grille.add(mdp,0,4,3,1);
		grille.add(statut,0,6,3,1);
		grille.add(nomReel,3, 0,3,1);
		grille.add(prenomReel, 3, 1,3,1);
		grille.add(dateNaisReel,3,2,3,1);
		grille.add(emailReel,3,3,3,1);
		grille.add(mdpReel,3,4,3,1);
		grille.add(statutReel,3,6,3,1);
		grille.add(modifDateNais,7, 2);
		grille.add(modifEmail, 7, 3);
		grille.add(modifMdp, 7, 4);
		grille.add(mdpMauvais, 5, 5);
		grille.add(modifStatut, 7, 6);
		
		grille.setHalignment(nom, HPos.RIGHT);	
		grille.setHalignment(prenom, HPos.RIGHT);		
		grille.setHalignment(dateNais, HPos.RIGHT);		
		grille.setHalignment(email, HPos.RIGHT);		
		grille.setHalignment(mdp, HPos.RIGHT);	
		grille.setHalignment(statut, HPos.RIGHT);		
		
		grille.setHgap(10);
		grille.setVgap(10);

		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(grille,Affichage);

		grille.setAlignment(Pos.CENTER_RIGHT);
		hbox.setAlignment(Pos.CENTER);
		hbox.setMargin(grille, new Insets(0,50,0,50));
		
		VBox vbox = new VBox();
		VBox.setMargin(titre, new Insets(0,0,50,0));
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(titre,hbox);		
		root.setCenter(vbox);


		Scene scene=new Scene(root,1500,800);
        scene.getStylesheets().add(getClass().getResource("ProfilCSS.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("BarreNav.css").toExternalForm());
		primaryStage.setTitle("Page d'accueil");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void interactionButton(Button btn, double nb) {
		btn.setScaleX(nb);
		btn.setScaleY(nb);
	}
	
	private void modifDialog(Label contenu, String nom) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Modification");
		dialog.setHeaderText("Modification du " + nom);
		dialog.setContentText("Entrez: "+ nom);
		dialog.getDialogPane().setStyle("-fx-font-size: 13; -fx-font-family:Calibri; -fx-font-weight:Bold; -fx-background-color: #F5F5F5");
		Optional<String> result = dialog.showAndWait();
		if(result.isPresent()) {
			contenu.setText(result.get());
		}
	}
    public void afficher() {// Mettre le code d'affichage de Steven ici
  
        StackPane root = new StackPane();
        Button button = new Button("Accueil");
        
        EventHandler <MouseEvent> allerAccueil = new EventHandler <MouseEvent> () {
			@Override
			public void handle (MouseEvent e) {
				Accueil accueil= new Accueil(stage);
				accueil.afficher(); // Naviguer vers Accueil
			}
		};
		
		button.addEventHandler(MouseEvent.MOUSE_CLICKED, allerAccueil);
        Scene scene = new Scene(root, 400, 300);
        root.getChildren().add(button);
        stage.setScene(scene);
        stage.setTitle("Profil");
        stage.show();
    }
}
