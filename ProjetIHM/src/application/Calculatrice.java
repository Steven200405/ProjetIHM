package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;

public class Calculatrice extends Application {

    private String currentInput = "0";  // Valeur actuelle affichée
    private String previousInput = "";  // Valeur précédente
    private String operator = "";  // Opérateur en cours
    private boolean isOperatorPressed = false;  // Indicateur si un opérateur a été pressé

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculatrice");

        BorderPane root = new BorderPane();

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10));

        ImageView imLogo = new ImageView(new Image(getClass().getResourceAsStream("/Photo/Logo.png")));
        imLogo.setFitHeight(90);
        imLogo.setFitWidth(200);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button accueil = new Button("Accueil");
        accueil.setPrefSize(130, 50);

        Button ressource = new Button("Ressources élèves");
        ressource.setPrefSize(130, 50);

        Button outil = new Button("Outils");
        outil.setPrefSize(130, 50);

        Button profil = new Button("Profil");
        profil.setPrefSize(130, 50);

        ImageView imContact = new ImageView(new Image(getClass().getResourceAsStream("/Photo/contact.png")));
        imContact.setFitWidth(20);
        imContact.setFitHeight(20);
        Button contact = new Button("Contact", imContact);
        contact.setPrefSize(130, 50);

        hbox.getChildren().addAll(imLogo, spacer, accueil, outil, ressource, profil, contact);
        root.setTop(hbox);

        Label displayLabel = new Label(currentInput);  // Étiquette affichant la valeur courante
        displayLabel.setFont(new Font("Arial", 40));
        displayLabel.setMinWidth(300);
        displayLabel.setAlignment(Pos.CENTER_RIGHT);
        displayLabel.setPadding(new Insets(15)); 
        displayLabel.setStyle("-fx-border-color: blue; -fx-border-width: 1px;");

        VBox calculatorLayout = new VBox(10);
        calculatorLayout.setAlignment(Pos.CENTER);
        calculatorLayout.setPadding(new Insets(10));

        calculatorLayout.getChildren().add(displayLabel);

        String[][] buttonText = {
            {"C", "DEL", "%", "/"},
            {"7", "8", "9", "*"},
            {"4", "5", "6", "-"},
            {"1", "2", "3", "+"},
            {"0", "", ".", "="}
        };

        // Création des boutons de la calculatrice
        for (String[] row : buttonText) {
            HBox buttonRow = new HBox(10);
            buttonRow.setAlignment(Pos.CENTER);

            for (String text : row) {
                if (text.isEmpty()) continue;

                Button button = new Button(text);
                button.setFont(new Font("Arial", 30));
                button.setMinSize(80, 80);
                button.setStyle("-fx-border-color: blue; -fx-border-width: 1px; -fx-background-color: lightgray;");

                // Personnalisation de la couleur des boutons spéciaux
                if ("C".equals(text)) {
                    button.setStyle("-fx-background-color: yellow; -fx-border-color: blue; -fx-border-width: 1px;");
                } else if ("DEL".equals(text)) {
                    button.setStyle("-fx-background-color: red; -fx-border-color: blue; -fx-border-width: 1px;");
                }

                // Action à effectuer lors de l'appui sur un bouton
                button.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        gererButtonClick(text, displayLabel);
                    }
                });

                buttonRow.getChildren().add(button);
            }

            calculatorLayout.getChildren().add(buttonRow);
        }

        StackPane buttonContainer = new StackPane();
        buttonContainer.setPadding(new Insets(5)); 
        buttonContainer.setStyle("-fx-border-color: blue; -fx-border-width: 2px;"); 
        buttonContainer.getChildren().add(calculatorLayout);

        root.setCenter(buttonContainer);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void gererButtonClick(String text, Label displayLabel) {
        // Gestion des clics sur les boutons
        if (text.equals("C")) {
            currentInput = "0";  // Réinitialiser l'affichage
            previousInput = "";
            operator = "";
            isOperatorPressed = false;
        } else if (text.equals("DEL")) {
            if (currentInput.length() > 1) {
                currentInput = currentInput.substring(0, currentInput.length() - 1);  // Supprimer un chiffre
            } else {
                currentInput = "0";
            }
        } else if (text.equals("=")) {
            if (!previousInput.isEmpty() && !operator.isEmpty()) {
                double result = Operation(Double.parseDouble(previousInput),
                        Double.parseDouble(currentInput), operator);
                currentInput = String.valueOf(result);  // Afficher le résultat
                previousInput = "";
                operator = "";
                isOperatorPressed = false;
            }
        } else if (text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/")) {
            if (!currentInput.equals("0")) {
                if (isOperatorPressed) {
                    double result = Operation(Double.parseDouble(previousInput),
                            Double.parseDouble(currentInput), operator);
                    currentInput = String.valueOf(result);
                    previousInput = currentInput;
                } else {
                    previousInput = currentInput;
                }
                operator = text;
                isOperatorPressed = true;
            }
        } else {
            if (isOperatorPressed) {
                currentInput = text;
                isOperatorPressed = false;
            } else {
                if (currentInput.equals("0") && !text.equals(".")) {
                    currentInput = text;  // Remplacer le "0" par un autre chiffre
                } else {
                    currentInput += text;  // Ajouter le chiffre à l'affichage
                }
            }
        }

        displayLabel.setText(currentInput);  // Mettre à jour l'affichage
    }

    private double Operation(double num1, double num2, String operator) {
        // Effectuer les calculs en fonction de l'opérateur
        if (operator.equals("+")) {
            return num1 + num2;
        } else if (operator.equals("-")) {
            return num1 - num2;
        } else if (operator.equals("*")) {
            return num1 * num2;
        } else if (operator.equals("/")) {
            if (num2 != 0) {
                return num1 / num2;  // Division
            } else {
                return 0;  // Si division par zéro, retour de 0
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        launch(args);  
    }
}
