package application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ToggleButton;

public class Echecs {
    private final Stage stage;

    public Echecs(Stage stage) {
        this.stage = stage;

public class Echecs extends BarreNav {
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

	// Création du contenu de la page Echecs
	// Création du titre
        Label titre = new Label("Apprentissage du jeu d’échecs \n" + "♔ ♕ ♖ ♗ ♘ ♙");
        titre.setTextAlignment(TextAlignment.CENTER);
        titre.setFont(Font.font("Calibri",FontWeight.BOLD,50));
        titre.setTextFill(Color.web("#2233AA"));
        
	// Création d'un champs pour entrer du texte
        TextField text = new TextField();
        text.setPromptText("Entrez la pièce que vous souhaitez connaître");
        text.setPrefWidth(300);
        text.setPrefHeight(50);
        
	// ?
        Image imgValide = new Image(getClass().getResourceAsStream("/Photo/valide.png"));
        ImageView imgValideAffichage = new ImageView(imgValide);
        imgValideAffichage.setId("ValidationImg");
        imgValideAffichage.setFitWidth(50);
        imgValideAffichage.setFitHeight(50);
		
	// Création d'un bouton de validation
        Button validButton = new Button();
        validButton.setGraphic(imgValideAffichage);
        validButton.setId("ValidationButton");
        validButton.setPadding(new Insets(2,2,2,2));
		
        // Ajoute des événements sur le bouton de validation
	// Effet de zoom quand on passe la souris dans le ToggleButton
        validButton.setOnMouseEntered(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent event) {
        		validButton.setScaleX(1.1);
        		validButton.setScaleY(1.1);
        	}
        });
	// Effet de dézoom quand on sort la souris du le ToggleButton
        validButton.setOnMouseExited(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent event) {
        		validButton.setScaleX(1.0);
        		validButton.setScaleY(1.0);
        	}
        });
        
        // Ajoute dans un conteneur horizontal le champs de texte et le bouton de validation
        HBox ligneText = new HBox(10);
        ligneText.getChildren().addAll(text,validButton);
	ligneText.setAlignment(Pos.CENTER);

	// Création d'un conteneur vertical qui comprend tout le contenu de la page d'échecs sauf la barre de navigation
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(titre,ligneText); // Ajoute le titre et le HBox
	
	Label infoPiece = new Label();
	infoPiece.setOpacity(0);
		
	// Ajoute un événement qui fait un traitement du texte entré 
        validButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent event) {
        		String rep = text.getText();
        		rep = rep.toUpperCase();
        		if(rep.equals("ROI")) {
        			infoPiece.setText("Le roi est la pièce la plus importante aux échecs et peut se déplacer d'une case dans toutes les directions,\n"
        	        		+ "avec la possibilité de faire un mouvement spécial appelé le roc. Lorsqu'il est en échec, le joueur doit soit déplacer le roi, \n"
        	        		+ "bloquer l'attaque, soit capturer la pièce menaçante, faute de quoi il sera en échec et mat, ce qui met fin à la partie.");
        		}
        		else if (rep.equals("REINE")){
        			infoPiece.setText("La reine est la pièce la plus puissante aux échecs, capable de se déplacer d’un nombre illimité de cases dans toutes \n"
        		        		+ " les directions (horizontalement, verticalement et en diagonale). Sa polyvalence en fait une grande menace sur l'échiquier, \n"
        		        		+ "permettant de contrôler de nombreuses cases à la fois.");
        		}
        		else if (rep.equals("TOUR")) {
        			infoPiece.setText("La tour se déplace en ligne droite, soit horizontalement, soit verticalement, sur un nombre illimité de cases.\n"
        	        		+ "Chaque joueur possède deux tours, situées initialement dans les coins de l'échiquier, et elles sont particulièrement puissantes\n"
        	        		+ "dans la phase finale du jeu.");
        		}
        		else if(rep.equals("FOU")) {
        			infoPiece.setText("Le fou se déplace en diagonale sur l'échiquier, sur un nombre illimité de cases. Chaque joueur possède deux fous,\n"
        	        		+ "un sur une case noire et l'autre sur une case blanche, et ils restent confinés à ces couleurs tout au long de la partie.");
        		}
        		else if(rep.equals("CAVALIER")) {
        			infoPiece.setText("Le cavalier se déplace en formant un 'L', c’est-à-dire deux cases dans une direction (horizontale ou verticale) \n"
        		        		+ "et une case perpendiculairement, ou une case dans une direction et deux cases perpendiculairement. \n"
        		        		+ "Il est la seule pièce à pouvoir sauter par-dessus les autres pièces, ce qui lui permet de se déplacer librement à travers l'échiquier.");
        		}
        		else if (rep.equals("PION")) {
        			infoPiece.setText("Le pion se déplace d'une case en avant, mais capture une pièce adverse en diagonale. Lors de son premier déplacement,\n"
        	        		+ "il peut avancer de deux cases, et lorsqu'il atteint la dernière rangée de l'échiquier, \n"
        	        		+ "il peut être promu en une autre pièce (reine, tour, fou ou cavalier).");
        		}
        		else {
        			infoPiece.setText("Veuillez saisir exactement la syntaxe des pièces d'échecs de cette manière: \n"
        					+ "Roi, Reine, Tour, Fou, Cavalier, Pion");
        		}
        		infoPiece.setFont(Font.font("Calibri",15));
        		infoPiece.setTextFill(Color.web("#2233AA"));
        		infoPiece.setTextAlignment(TextAlignment.JUSTIFY);
        		infoPiece.setOpacity(1);
        	}
        });
        vbox.getChildren().add(infoPiece); // Ajoute le résultat de l'événement dans le VBox
        
	// Création d'un ToggleButton pour avoir un booléen indiquant si il a été sélectionné.
        ToggleButton consigne = new ToggleButton("Consigne");
        consigne.setPrefHeight(40);
        consigne.setPrefWidth(300);
        consigne.setFont(Font.font("Calibri", FontWeight.BOLD,50));
        consigne.setTextFill(Color.web("#2233AA"));
		
        // Création d'un Label décrivant la consigne de ce qu'il ce passe dans cette page
        Label infoConsigne = new Label();
		infoConsigne.setOpacity(0);
		infoConsigne.setText("Bienvenue sur la page d'apprentissage d'échecs où tu peux apprendre les bases en échecs. \n"
				+ "Ecrit le nom de la pièce d'échec comme le Roi, Dame, Cavalier,... dans la zone d'écriture pour connaître les informations de celles-ci.");
		infoConsigne.setFont(Font.font("Calibri",25));
		infoConsigne.setTextFill(Color.web("#2233AA"));
		infoConsigne.setTextAlignment(TextAlignment.CENTER);
		
        // Ajoute un événement au ToggleButon 'consigne'
        consigne.setOnMouseClicked(new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent event){
        			if(consigne.isSelected()) { // Si le ToggleButton est cliqué, on rend la consigne visible
        				infoConsigne.setOpacity(1);
        			}
        			else { // Sinon, on la rend invisible
        				infoConsigne.setOpacity(0);
        			}
        
               	}
        });
        // Ajoute un effet de zoom quand la souris passe dans le ToggleButton
        consigne.setOnMouseEntered(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent event) {
        		consigne.setScaleX(1.025);
        		consigne.setScaleY(1.025);
        	}
        });
	// Ajoute un effet de dézoom quand la souris sort du le ToggleButton
        consigne.setOnMouseExited(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent event) {
        		consigne.setScaleX(1.0);
        		consigne.setScaleY(1.0);
        	}
        });
        
        // Création du contenu vertical pour ajouter le ToggleButton consigne et le label infoConsigne
        VBox contenuConsigne = new VBox(20);
        contenuConsigne.setMargin(consigne, new Insets(30,0,0,0));
        contenuConsigne.getChildren().addAll(consigne,infoConsigne);
        contenuConsigne.setAlignment(Pos.CENTER);
        
        vbox.setMargin(titre, new Insets(50,0,0,0));
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().add(contenuConsigne);
        root.setCenter(vbox);
	}
	// A modifier
	public void afficher() {
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
        stage.setTitle("Echecs");
	scene.getStylesheets().add(getClass().getResource("EchecsCSS.css").toExternalForm());
        stage.show();
    }
}
