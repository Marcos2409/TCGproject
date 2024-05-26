package project.tcgproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for handling the main view in the trading card game application.
 */
public class HelloController {

    @FXML
    private Button prevButton;
    @FXML
    private Button nextButton;
    @FXML
    private Label welcomeText;

    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    @FXML
    private ImageView imageView3;
    @FXML
    private ImageView imageView4;
    @FXML
    private ImageView imageView5;

    private int currentPage = 0;
    private final String[][] imagePages = {
            {"/images/logo.png", "/images/pawmot.png", "/images/medicham.png", "/images/charizard.png", "/images/sprigatito.png"},
            {"/images/logo.png", "/images/arcanine.png", "/images/giratina.png", "/images/shaymin.png", "/images/pikachu.png"}
    };

    private final String[][] cardNames = {
            {"Pawmot", "Medicham", "Charizard", "Sprigatito"},
            {"Arcanine", "Giratina", "Shaymin", "Pikachu"}
    };

    private CartManager cartManager;

    /**
     * Initializes the controller by setting up the images and actions.
     */
    @FXML
    public void initialize() {
        updateImages();
        setImageViewActions();
        cartManager = new CartManager();
    }

    /**
     * Handles the action of moving to the next set of images.
     */
    @FXML
    private void handleNextAction() {
        if (currentPage < imagePages.length - 1) {
            currentPage++;
            updateImages();
        }
    }

    /**
     * Handles the action of moving to the previous set of images.
     */
    @FXML
    private void handlePreviousAction() {
        if (currentPage > 0) {
            currentPage--;
            updateImages();
        }
    }

    /**
     * Updates the images displayed in the ImageView components.
     */
    private void updateImages() {
        Image[] images = new Image[5];
        for (int i = 0; i < 5; i++) {
            images[i] = new Image(getClass().getResource(imagePages[currentPage][i]).toExternalForm());
        }
        imageView1.setImage(images[0]);
        imageView2.setImage(images[1]);
        imageView3.setImage(images[2]);
        imageView4.setImage(images[3]);
        imageView5.setImage(images[4]);

        updateButtonVisibility();
    }

    /**
     * Updates the visibility of the next and previous buttons based on the current page.
     */
    private void updateButtonVisibility() {
        prevButton.setVisible(currentPage > 0);
        nextButton.setVisible(currentPage < imagePages.length - 1);
    }

    /**
     * Sets actions for the ImageView components to handle mouse click events.
     */
    private void setImageViewActions() {
        imageView1.setOnMouseClicked(event -> showImageInNewScene(imagePages[currentPage][0], cardNames[currentPage][0]));
        imageView2.setOnMouseClicked(event -> showImageInNewScene(imagePages[currentPage][1], cardNames[currentPage][1]));
        imageView3.setOnMouseClicked(event -> showImageInNewScene(imagePages[currentPage][2], cardNames[currentPage][2]));
        imageView4.setOnMouseClicked(event -> showImageInNewScene(imagePages[currentPage][3], cardNames[currentPage][3]));
        imageView5.setOnMouseClicked(event -> showImageInNewScene(imagePages[currentPage][4], cardNames[currentPage][4]));
    }

    /**
     * Displays the selected image in a new scene.
     *
     * @param imageUrl the URL of the image to display
     * @param cardName the name of the card
     */
    private void showImageInNewScene(String imageUrl, String cardName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("card.fxml"));
            Parent root = loader.load();

            CardController cardController = loader.getController();
            cardController.setImage(imageUrl);
            cardController.setCardName(cardName);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action of going to the cart view.
     *
     * @param event the event triggered by the action
     */
    @FXML
    private void handleGoToCart(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
            Parent root = loader.load();

            CartController cartController = loader.getController();
            cartController.setCartManager(cartManager);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
