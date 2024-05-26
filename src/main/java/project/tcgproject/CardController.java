package project.tcgproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for handling card-related actions in the trading card game application.
 */
public class CardController {
    @FXML
    private ImageView imageView;
    private String cardListName;

    /**
     * Sets the image to be displayed in the ImageView.
     *
     * @param imagePath the path to the image file
     */
    public void setImage(String imagePath) {
        imageView.setImage(new Image(getClass().getResource(imagePath).toExternalForm()));
    }

    @FXML
    private Label cardName;

    /**
     * Sets the name of the card to be displayed and stored.
     *
     * @param name the name of the card
     */
    public void setCardName(String name) {
        cardName.setText(name);
        cardListName = name;
    }

    /**
     * Handles the action of going back to the main screen.
     *
     * @param actionEvent the event triggered by the action
     */
    @FXML
    public void handleGoToMain(ActionEvent actionEvent) {
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Handles the action of adding the card to the cart.
     *
     * @param actionEvent the event triggered by the action
     */
    public void handleAddToCart(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
            Parent root = loader.load();
            CartManager cartManager = new CartManager();
            cartManager.addToCart(cardListName);
            CartController cartController = loader.getController();
            cartController.addToList(cardListName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
