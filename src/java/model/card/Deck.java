/*
    DECK CLASS
    Deck class handles all cards in the game and ensures an in-game deck has all the cards a real deck would have.
 */

package model.card;

import model.utilities.enumeration.CardValue;
import model.utilities.enumeration.CardSuit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
    
    //Variables
    List<Card> cardArr;
    
    //Methods
    public Deck() {
        cardArr = new ArrayList();
        
        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardValue cardValue : CardValue.values()) {
                cardArr.add(new Card(cardSuit, cardValue));
                
            }
            
        }
        
    }
        
    //Shuffles the deck with the Collections algorithm in the java.util library.
    public void shuffle() {
        Collections.shuffle(cardArr);
        
    }
    
    //Removes a card from the list.
    private void removeCard(Card card) {
        cardArr.remove(card);
        
    }
    
    //Gets and sets
    //Draws a card from the deck and removes it from the list.
    public final Card getCard() {
        Card card = null;
        
        if (!cardArr.isEmpty()) {
            card = cardArr.get(0);
            removeCard(card);
            
        }
        
        return card;
        
    }
    
}
