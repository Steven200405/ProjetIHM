package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Figure extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Belles figures de géométrie");

        HBox navbar = new HBox();
        navbar.setPadding(new Insets(10));
        navbar.setSpacing(10);
        navbar.setAlignment(Pos.CENTER_LEFT);
        navbar.setStyle("-fx-background-color: #ececec;");  

        ImageView imLogo = new ImageView(new Image(getClass().getResourceAsStream("/Photo/Logo.png")));
        imLogo.setFitHeight(90);
        imLogo.setFitWidth(200);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button accueil = new Button("Accueil");
        accueil.setPrefSize(130, 50);

        MenuButton ressource = new MenuButton("Ressources élèves");
        ressource.setPrefSize(130, 50);

        MenuButton outil = new MenuButton("Outils");
        outil.setPrefSize(130, 50);

        Button profil = new Button("Profil");
        profil.setPrefSize(130, 50);

        ImageView imContact = new ImageView(new Image(getClass().getResourceAsStream("/Photo/contact.png")));
        imContact.setFitWidth(20);
        imContact.setFitHeight(20);
        Button contact = new Button("Contact", imContact);
        contact.setPrefSize(130, 50);

        navbar.getChildren().addAll(imLogo, spacer, accueil, outil, ressource, profil, contact);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(30);
        gridPane.setVgap(30);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(createSection("Galerie de réalisations",
            "Les plus belles figures de ces dernières années sont à consulter ici.",
            null), 0, 0);

        gridPane.add(createSection("Consignes à suivre",
            "- Effectuer la construction sur une feuille blanche non quadrillée (feuille d'imprimante ou papier Canson).\n"
            + "- Ne pas oublier d'indiquer votre nom ainsi que le numéro de la figure réalisée.\n"
            + "- Tracer avec précision au crayon à papier sans appuyer, parfois pour les noms des points.\n"
            + "- À la fin, gommer tous les traits de constructions devenus inutiles (ainsi que les noms des points).",
            null), 1, 0);

        gridPane.add(createSectionWithWhiteBackground("Animaux compassés",
            "- Le panda",
            new Image(getClass().getResourceAsStream("/Photo/panda.png")),
            new Hyperlink("énoncé"),
            new Hyperlink("article"),
            new Hyperlink("animation")
        ), 0, 1);

        gridPane.add(createSectionWithWhiteBackground("Géométrie pour le plaisir",
            "- Tome 1 figure n°3",
            new Image(getClass().getResourceAsStream("/Photo/figure.png")),
            new Hyperlink("énoncé")
        ), 1, 1);

        VBox diversSection = createSectionWithWhiteBackground("Divers",
            "- Rose des vents",
            new Image(getClass().getResourceAsStream("/Photo/rose.png")),
            new Hyperlink("énoncé")
        );

        diversSection.setPrefSize(300, 180);

        GridPane.setConstraints(diversSection, 0, 2, 2, 1);
        gridPane.getChildren().add(diversSection);

        BorderPane root = new BorderPane();
        root.setTop(navbar);
        root.setCenter(gridPane);

        root.setStyle("-fx-background-color: #ececec;");

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Crée une section avec un fond gris clair, titre et description
    private VBox createSection(String titleText, String descriptionText, Image image, Hyperlink... links) {
        VBox section = new VBox(10);
        section.setPadding(new Insets(15));
        section.setStyle("-fx-background-color: #f4f4f4; -fx-background-radius: 20px; -fx-border-color: #0055b8; -fx-border-radius: 20px; -fx-border-width: 2px;");
        section.setAlignment(Pos.TOP_CENTER);
        section.setPrefSize(400, 300);

        Label title = new Label(titleText);
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        title.setAlignment(Pos.CENTER);

        Label description = new Label(descriptionText);
        description.setFont(Font.font("Arial", 16));
        description.setWrapText(true);

        // Si une image est fournie, l'ajouter à la section
        if (image != null) {
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            section.getChildren().add(imageView);
        }

        section.getChildren().addAll(title, description);

        // Si des liens sont fournis, les afficher sous forme de HBox
        if (links.length > 0) {
            HBox linkBox = new HBox(10);
            linkBox.setAlignment(Pos.CENTER);
            linkBox.getChildren().addAll(links);
            section.getChildren().add(linkBox);
        }

        return section;
    }

    // Crée une section avec un fond blanc, titre, description, image et liens
    private VBox createSectionWithWhiteBackground(String titleText, String descriptionText, Image image, Hyperlink... links) {
        VBox section = new VBox(10);
        section.setPadding(new Insets(15));
        section.setStyle("-fx-background-color: white; -fx-background-radius: 20px; -fx-border-color: #0055b8; -fx-border-radius: 20px; -fx-border-width: 2px;");
        section.setAlignment(Pos.TOP_CENTER);
        section.setPrefSize(400, 300);

        Label title = new Label(titleText);
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        title.setAlignment(Pos.CENTER);

        Label description = new Label(descriptionText);
        description.setFont(Font.font("Arial", 16));
        description.setWrapText(true);

        // Si une image est fournie, l'ajouter à la section
        if (image != null) {
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            section.getChildren().add(imageView);
        }

        section.getChildren().addAll(title, description);

        // Si des liens sont fournis, les afficher sous forme de HBox
        if (links.length > 0) {
            HBox linkBox = new HBox(10);
            linkBox.setAlignment(Pos.CENTER);
            linkBox.getChildren().addAll(links);
            section.getChildren().add(linkBox);
        }

        return section;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
