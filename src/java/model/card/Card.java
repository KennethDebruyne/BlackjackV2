/*
    CARD CLASS
    Represents a card in the game.
 */

package model.card;

import model.utilities.enumeration.CardSuit;
import model.utilities.enumeration.CardValue;
import model.utilities.manager.ImageManager;

public class Card {
    
    //Variables
    private final CardSuit cardSuit;
    private final CardValue cardValue;
    private final String imagePath;
    
    private boolean isVisible;
    
    //Methods
    public Card(CardSuit cardSuit, CardValue cardValue) {
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
        
        imagePath = ImageManager.getImagePath(cardSuit, cardValue);
        isVisible = true;
        
    }
    
    //Gets and sets
    //Returns the card type.
    public final CardSuit getCardType() {
        return cardSuit;
        
    }
    
    //Returns the card value.
    public final CardValue getCardValue() {
        return cardValue;
        
    }
    
    //Returns the path of the image.
    public final String getImagePath() {
        return imagePath;
        
    }
    
    //Returns whether or not the card is visible on the site.
    public final boolean isVisible() {
        return isVisible;
        
    }
    
    //Sets whether or not the card should be visible.
    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
        
    }
    
}
