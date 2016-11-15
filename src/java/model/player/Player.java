/*
    PLAYER ABSTRACT CLASS
    An abstract class for all playable objects in the game.
 */

package model.player;

import model.card.Hand;
import model.utilities.enumeration.PlayerStatus;

public abstract class Player {
    
    //Variables
    protected final String userName;
    protected final String iconUri;
    protected int balance;
    
    protected Hand playerHand;
    protected PlayerStatus playerStatus;
    
    //Methods
    protected Player(String userName, String iconUri, int balance, int bet) {
        this.userName = userName;
        this.iconUri = iconUri;
        this.balance = balance;
        
        playerHand = new Hand(bet);
        
    }
    
    //Applies a bet (as well as negative as positive) to the players balance.
    public void applyBet(int bet) {
        balance += bet;
        
    }
    
    //Gets and sets
    //Returns the hand of the player.
    public Hand getHand() {
        return playerHand;
        
    }
    
    //Retuns the status of the player, null if the game hasn't been finished yet.
    public final PlayerStatus getPlayerStatus() {
        return playerStatus;
        
    }
    
    //Sets the status of the player.
    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
        
    }  
    
    //Returns the icon URI of the player.
    public final String getIconUri() {
        return iconUri;
        
    }
    
    //Returns the user name of the player.
    public final String getUserName() {
        return userName;
        
    } 
    
}
