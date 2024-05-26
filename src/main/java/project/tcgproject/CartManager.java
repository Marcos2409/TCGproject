package project.tcgproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the cart items for the trading card game application.
 */
public class CartManager {
    private List<String> cartItems;

    /**
     * Constructs a new CartManager with an empty list of cart items.
     */
    public CartManager() {
        cartItems = new ArrayList<>();
    }

    /**
     * Adds an item to the cart.
     *
     * @param item the item to be added to the cart
     */
    public void addToCart(String item) {
        cartItems.add(item);
    }

    /**
     * Returns the list of items in the cart.
     *
     * @return the list of cart items
     */
    public List<String> getCartItems() {
        return cartItems;
    }
}
