package application;
import javafx.stage.Stage;
import java.util.Optional;
import javafx.application.Application;
import javafx.css.Size;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.geometry.*;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Region;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Accordion;
import javafx.scene.control.CheckBox;

public class CahierTexte extends BarreNavigation {
	
	public CahierTexte(Stage primaryStage) {
		super(); // héritage de la barre de navigation dans Cahier de texte
		VBox grandVBox = new VBox();
		root.setCenter(grandVBox); // On met le contenu du Cahier de texte dans un VBox
		
		Label titre = new Label("CAHIER DE TEXTES");
		// Décoration du titre 
		titre.setTextFill(Color.web("#2233AA"));
		titre.setFont(Font.font("Calibri", FontWeight.BOLD, 45));
		
		// Positionne le titre au centre de la ligne
		HBox conteneurTitre = new HBox();
		conteneurTitre.getChildren().add(titre);
		conteneurTitre.setAlignment(Pos.CENTER);
		conteneurTitre.setMargin(titre, new Insets(60, 0, 0, 0));

		Label sous_titre = new Label ("6_E - MATHEMATIQUES - M.CRESPIN");
		// Décoration du sous-titre
		sous_titre.setTextFill(Color.web("#44725d"));
		sous_titre.setFont(Font.font("Calibri", FontWeight.BOLD, 25));
		
		// Positionne le sous-titre au centre de la ligne
		HBox conteneurSousTitre = new HBox();
		conteneurSousTitre.getChildren().add(sous_titre);
		conteneurSousTitre.setAlignment(Pos.CENTER);
		conteneurSousTitre.setMargin(sous_titre, new Insets(0, 0, 100, 0));
		
		// Création des historiques de cours et devoirs par date
		VBox dateContent = new VBox();
		Accordion accordion = new Accordion(); // Accordion prend un groupe de TitledPane. Seul un TitlePane peut être ouvert à la fois.
		grandVBox.setMargin(accordion, new Insets(0, 100, 0, 100));
		
		// Historique de cours pour une date 
		Image etoile = new Image(getClass().getResourceAsStream("/Photo/etoile.png"));
		ImageView ImEtoile1 = new ImageView(etoile);
		ImEtoile1.setFitHeight(50);
		ImEtoile1.setFitWidth(50);
		Label titleSeance = new Label ("Séance du vendredi 18 octobre 2024", ImEtoile1);
		titleSeance.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		titleSeance.setTextFill(Color.web("#2233AA"));
		
		// Création d'un événement de redirection sur un Label
		Label probleme140 = new Label("Problème n° 140.");
		Hyperlink correctionProbleme140 = new Hyperlink("[Correction]");
		EventHandler <MouseEvent> c = new EventHandler <MouseEvent> () {
			@Override
			public void handle (MouseEvent e) {
				String url = "https://ressources.profmath.fr/pdfjs2/web/viewer.html?file=../../web_pdf/3igk89l07.pdf";
				getHostServices().showDocument(url);
			}
		};
		correctionProbleme140.addEventHandler(MouseEvent.MOUSE_CLICKED, c);
		
		// Création d'un conteneur horizontal comprenant un contenu pour une date
		HBox seanceLine1 = new HBox (); 
		seanceLine1.getChildren().addAll(probleme140, correctionProbleme140);
		
		Label exercice9 = new Label("Exercice n°9.");
		Hyperlink correctionExercice9 = new Hyperlink("[Correction]");
		EventHandler <MouseEvent> d = new EventHandler <> () {
			@Override
			public void handle (MouseEvent e) {
				String url = "https://ressources.profmath.fr/pdfjs2/web/viewer.html?file=../../web_pdf/3inukh6ex.pdf";
				getHostServices().showDocument(url);
			}
		};
		correctionExercice9.addEventHandler(MouseEvent.MOUSE_CLICKED, d);
		
		// Création d'un second conteneur horizontal comprenant un autre contenu pour une date
		HBox seanceLine2 = new HBox ();
		seanceLine2.getChildren().addAll(exercice9, correctionExercice9);
		
		// Création d'un événement de redirection "interne", pas sur le Web
		Hyperlink consigneBelleFigure = new Hyperlink("Consignes pour la construction de belles figure de géométrie.");
		EventHandler <MouseEvent> allerBelleFigure = new EventHandler <MouseEvent> () {
			@Override
			public void handle(MouseEvent e) {
				//Redirection vers la page Belle figure
				Stage ThirdyStage = new Stage();
				Figure belleFigure = new Figure(ThirdyStage);	
				belleFigure.afficher(); // Afficher Accueil
			}
		 };		        
		 consigneBelleFigure.addEventHandler(MouseEvent.MOUSE_CLICKED, allerBelleFigure);

		Hyperlink debutConstruction = new Hyperlink("Début d'une construction.");	
		EventHandler <MouseEvent> g = new EventHandler <>() {
			@Override 
			public void handle(MouseEvent e) {
				String url = "https://profmath.fr/docs/geometrie/sources/GeometriePourLePlaisir/Tome1Figure03/GP_1-03.pdf";
				getHostServices().showDocument(url);
			}
		};
		debutConstruction.addEventHandler(MouseEvent.MOUSE_CLICKED, g);
		
		// Ajoute tout l'historique de cours pour une date dans un VBox
		dateContent.setMargin(seanceLine1, new Insets(0, 0, 0, 50));
		dateContent.setMargin(seanceLine2, new Insets(0, 0, 0, 50));
		dateContent.setMargin(consigneBelleFigure, new Insets(0, 0, 0, 50));
		dateContent.setMargin(debutConstruction, new Insets(0, 0, 0, 50));
		dateContent.getChildren().addAll(titleSeance, seanceLine1, seanceLine2, consigneBelleFigure, debutConstruction);
		
		// Contenu des devoirs pour une date
		Image fleche = new Image(getClass().getResourceAsStream("/Photo/fleche.png"));
		ImageView ImFleche1 = new ImageView (fleche);
		ImFleche1.setFitHeight(50);
		ImFleche1.setFitWidth(50);
		Label titreDevoir = new Label ("Devoirs", ImFleche1);
		titreDevoir.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		titreDevoir.setTextFill(Color.web("#2233AA"));
		
		// Création d'une case à cocher 
		CheckBox devoirLine= new CheckBox("Rendre une construction de géométrie de son choix (ne pas oublier d'indiquer de quoi il s'agit.)");
		dateContent.setMargin(devoirLine, new Insets(0, 0, 0, 50));
		
		// Ajout du titre 'Devoir' et de la case à cocher dans le VBOX
		dateContent.getChildren().addAll(titreDevoir, devoirLine);
		TitledPane dateLabel1 = new TitledPane(); // TitledPane est un panneau avec un titre qui peut être ouvert ou fermé. TitledPance est une extension de Labeled.		
		dateLabel1.setText("Lundi 4 novembre 2024");
		dateLabel1.setFont(Font.font("Calibri", FontWeight.BOLD,14));
		dateLabel1.setContent(dateContent);
		dateLabel1.setAlignment(Pos.CENTER); // Mettre la date au milieu
		
		// Création d'un deuxième panneau avec son contenu dans un VBox
		TitledPane dateLabel2 = new TitledPane();
		dateLabel2.setText("Jeudi 17 octobre 2024");
		dateLabel2.setAlignment(Pos.CENTER);
		dateLabel2.setFont(Font.font("Calibri", FontWeight.BOLD,14));
		
		VBox dateContent2 = new VBox();
		dateLabel2.setContent(dateContent2);
		ImageView ImEtoile2 = new ImageView(etoile);
		ImEtoile2.setFitHeight(50);
		ImEtoile2.setFitWidth(50);
		Label titleSeance2 = new Label ("Séance du jeudi 17 octobre 2024", ImEtoile2);
		titleSeance2.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		titleSeance2.setTextFill(Color.web("#2233AA"));
		
		Label presentationExpo = new Label("Présentation des exposés par les élèves.");
		Hyperlink evaluationCourte = new Hyperlink("Evaluation courte.");
		EventHandler <MouseEvent> f = new EventHandler <>() {
			@Override 
			public void handle(MouseEvent e) {
				String url = "https://ds.ac-bordeaux.fr/discovery/WAYF?entityID=https%3A%2F%2Fent2d.ac-bordeaux.fr%2Fshibboleth&return=https%3A%2F%2Fent2d.ac-bordeaux.fr%2FShibboleth.sso%2FLogin%3FSAMLDS%3D1%26target%3Dhttps%253A%252F%252Fent2d.ac-bordeaux.fr%252Fsacoche%252Findex.php%253Fsso%253D0333121N%2526page%253Devaluation_voir";
				getHostServices().showDocument(url);
			}
		};
		evaluationCourte.addEventHandler(MouseEvent.MOUSE_CLICKED, f);
		
		Label exercice87 = new Label ("Exercice n°87");
		Hyperlink correctionExercice87 = new Hyperlink("[Correction]");
		EventHandler <MouseEvent> a = new EventHandler <MouseEvent> (){
			@Override
			public void handle(MouseEvent e) {
				String url = "https://ressources.profmath.fr/pdfjs2/web/viewer.html?file=../../web_pdf/3imicc5af.pdf";
				getHostServices().showDocument(url);
			}
		};
		correctionExercice87.addEventHandler(MouseEvent.MOUSE_CLICKED, a);
		
		HBox seanceLine3 = new HBox();
		seanceLine3.getChildren().addAll(exercice87, correctionExercice87);
		
		Hyperlink enonceProbleme140 = new Hyperlink("[énoncé]");
		EventHandler <MouseEvent> b = new EventHandler <MouseEvent> () {
			@Override
			public void handle (MouseEvent e) {
				String url = "https://ressources.profmath.fr/pdfjs2/web/viewer.html?file=../../web_pdf/38boafmoy.pdf";
				getHostServices().showDocument(url);
			}
		};
		enonceProbleme140.addEventHandler(MouseEvent.MOUSE_CLICKED, b);
		
		Label phrase = new Label ("Problème n° 140. Cherché par certains élèves. ");
		HBox seanceLine4 = new HBox ();
		seanceLine4.getChildren().addAll(phrase, enonceProbleme140);	
		
		// Ajoute tous le contenu du cours à une date dans le VBox
		dateContent2.getChildren().addAll(titleSeance2, presentationExpo, evaluationCourte, seanceLine3, seanceLine4);
		
		ImageView ImFleche2 = new ImageView (fleche);
		ImFleche2.setFitHeight(50);
		ImFleche2.setFitWidth(50);
		Label titreDevoir2 = new Label ("Devoirs", ImFleche2);
		titreDevoir2.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		titreDevoir2.setTextFill(Color.web("#2233AA"));
		CheckBox devoirLine2 = new CheckBox("Problème n°140. Recherche à poursuivre.");
		dateContent2.setMargin(devoirLine2, new Insets(0, 0, 0, 50));	
		
		dateContent2.setMargin(presentationExpo, new Insets(0, 0, 0, 50));
		dateContent2.setMargin(evaluationCourte, new Insets(0, 0, 0, 50));
		dateContent2.setMargin(seanceLine3, new Insets(0, 0, 0, 50));
		dateContent2.setMargin(seanceLine4, new Insets(0, 0, 0, 50));
		
		// Ajout des devoirs et titre Devoir
		dateContent2.getChildren().addAll(titreDevoir2, devoirLine2);

		// Ajoute les TitledPane dans l'Accordion
		accordion.getPanes().addAll(dateLabel1, dateLabel2);
		
		grandVBox.getChildren().addAll(conteneurTitre, conteneurSousTitre, accordion);
		Scene scene = new Scene(root, 400, 500);
		scene.getStylesheets().add(getClass().getResource("styleCahierTexte.css").toExternalForm());
		primaryStage.setScene(scene);
		
	}

}
