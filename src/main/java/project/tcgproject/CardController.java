package project.tcgproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class CardController {
    @FXML
    private ImageView imageView;
    private String cardListName;

    public void setImage(String imagePath) {
        imageView.setImage(new Image(getClass().getResource(imagePath).toExternalForm()));
    }
    @FXML
    private Label cardName;

    public void setCardName(String name) {
        cardName.setText(name);
        cardListName = name;
    }

    @FXML
    public void handleGoToMain(ActionEvent actionEvent) {
        Stage stage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

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
