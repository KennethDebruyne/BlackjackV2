/*
    HAND CLASS
    A hand holds all the cards and the bet of the player.
 */

package model.card;

import java.util.ArrayList;
import java.util.List;
import model.utilities.enumeration.HandStatus;

public class Hand {
    
    //Variables
    private List<Card> cardArr;
    private HandStatus handStatus;
    
    private final int bet;
    
    //Methods
    public Hand(int bet) {
        cardArr = new ArrayList();
        
        this.bet = bet;
        
    }
    
    //Adds a card to the list.
    public void addCard(Card card) {
        cardArr.add(card);
        
    }
    
    //Gets and sets
    //Returns the list of cards.
    public final List<Card> getCards() {
        return cardArr;
        
    }
    
    //Returns the status of the hand.
    public final HandStatus getHandStatus() {
        return handStatus;
        
    }
    
    //Sets the hand status.
    public void setHandStatus(HandStatus handStatus) {
        this.handStatus = handStatus;
        
    }
    
    //Returns the bet of the player on this hand.
    public final int getBet() {
        return bet;
        
    }
    
    //Returns the value of the hand as an integer.
    public final int getHandValue(){
        int handValue = 0;
        
        for (Card card : cardArr) {
            switch (card.getCardValue()) {
                case ACE:
                    if (handValue < 11) {
                        handValue += 11;
                        
                    }
                    else {
                        handValue += 1;
                        
                    }
                    
                    break;
                    
                case TWO:
                    handValue += 2;
                    break;
                    
                case THREE:
                    handValue += 3;
                    break;
                    
                case FOUR:
                    handValue += 4;
                    break;
                    
                case FIVE:
                    handValue += 5;
                    break;
                    
                case SIX:
                    handValue += 6;
                    break;
                    
                case SEVEN:
                    handValue += 7;
                    break;
                    
                case EIGHT:
                    handValue += 8;
                    break;
                    
                case NINE:
                    handValue += 9;
                    break;
                    
                case TEN:
                    handValue += 10;
                    break;
                    
                case JACK:
                    handValue += 10;
                    break;
                    
                case QUEEN:
                    handValue += 10;
                    break;
                    
                case KING:
                    handValue += 10;
                    break;
                
            }
            
        }
        
        return handValue;
        
    }
    
}
