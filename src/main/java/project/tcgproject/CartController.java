package project.tcgproject;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CartController {

    private CartManager cartManager = new CartManager();

    @FXML
    private ListView<String> listView;

    public void setCartManager(CartManager cartManager) {
        this.cartManager = cartManager;
    }

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


    @FXML
    public void handleGoToMain(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.close();
    }


}
