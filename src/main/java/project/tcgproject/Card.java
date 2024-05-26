package project.tcgproject;

/**
 * Represents a card in the trading card game.
 */
public class Card {
    private String name;
    private String imageUrl;

    /**
     * Constructs a new Card with the specified name and image URL.
     *
     * @param name the name of the card
     * @param imageUrl the URL of the card's image
     */
    public Card(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    /**
     * Returns the name of the card.
     *
     * @return the name of the card
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the URL of the card's image.
     *
     * @return the URL of the card's image
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Returns a string representation of the card, which is its name.
     *
     * @return the name of the card
     */
    @Override
    public String toString() {
        return name;
    }
}
