package project.tcgproject;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Controller class for managing the cart in the trading card game application.
 */
public class CartController {

    private CartManager cartManager = new CartManager();

    @FXML
    private ListView<String> listView;

    /**
     * Sets the CartManager instance to be used by this controller.
     *
     * @param cartManager the CartManager instance
     */
    public void setCartManager(CartManager cartManager) {
        this.cartManager = cartManager;
    }

    /**
     * Initializes the cart by loading items from a file and populating the ListView.
     */
    @FXML
    public void initialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("listFile.txt"));
            ObservableList<String> items = listView.getItems();

            String line;
            while ((line = reader.readLine()) != null) {
                items.add(line);
            }
            reader.close();
            listView.setItems(items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds an item to the cart and writes it to the file.
     *
     * @param itemName the name of the item to be added
     */
    @FXML
    public void addToList(String itemName) {
        try {
            FileWriter writer = new FileWriter("listFile.txt", true);
            writer.write(itemName + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the action of going back to the main screen.
     *
     * @param actionEvent the event triggered by the action
     */
    @FXML
    public void handleGoToMain(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
