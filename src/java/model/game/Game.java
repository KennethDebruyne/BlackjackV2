/*
    GAME CLASS
    Contains all game logic.
 */

package model.game;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import databank.model.*;
import databank.service.BlackjackService;
import model.card.*;
import model.player.*;
import model.utilities.enumeration.*;
import model.utilities.manager.ImageManager;

public class Game {
    
    //Variables
    private Deck deck;
    private java.sql.Date startDate;
    
    private List<Player> playerArr;
    private Dealer dealerHandle;
    
    private boolean isGameOver = false;
    
    //Methods
    public Game(List<UserRecord> userArr) {
        java.util.Date utilDate = new java.util.Date();
        startDate = new Date(utilDate.getTime());
        playerArr = new ArrayList();

        initialize(userArr);
        
    }
    
    //Initializes all users in the game.
    private void initialize(List<UserRecord> userArr) {
        deck = new Deck();
        deck.shuffle();
        
        String iconDealer = ImageManager.getImagePath("DEALER");
        dealerHandle = new Dealer(iconDealer, 16, 17);
        playerArr.add(dealerHandle);
        
        // --- Initializes all the players.
        for (UserRecord user : userArr) {
            Player player = new User(user.getFirstName() + " " + user.getLastName(), user.getIconUri(), user.getBalance(), user.getBet());
            playerArr.add(player);
            
        }
        
        // --- Gives all the players two cards at the start of the game.
        for (Player player : playerArr) {
            Hand hand = player.getHand();
            
            for (int i = 0; i < 2; i++) {
                cardDestribution(hand, true);
                
            }
            
            evaluate(hand);
            
        }
        
        // --- Sets one card of the daeler invisible.
        List<Card> dealerCardArr = dealerHandle.getHand().getCards();
        dealerCardArr.get(1).setVisible(false);
        
    }
    
    //Runs one round of the game.
    public void runRound() {
        isGameOver = true;
        
        // --- Checks the status of all players.
        int lowestHandValue = Integer.MAX_VALUE;
        for (Player player : playerArr) {
            Hand playerHand = player.getHand();
            HandStatus handStatus = playerHand.getHandStatus();
            
            int handValue = playerHand.getHandValue();
            if (handValue < lowestHandValue && player != dealerHandle) {
                lowestHandValue = handValue;
                
            }

            if (handStatus == HandStatus.HIT) {
                isGameOver = false;
                    
                cardDestribution(playerHand, true);
                evaluate(playerHand);
                
            }

        }
        
        // --- Sets the status for the dealer.
        do {
            dealerHit(lowestHandValue);
            
        }
        while (isGameOver && dealerHandle.getHand().getHandStatus() == HandStatus.HIT);
        
        //Ty to end game
        if (isGameOver) {
            determineWinners();
            createLog();
            
        }

    }
    
    //Dealer AI.
    private void dealerHit(int lowestHandValue) {
        Hand dealerHand = dealerHandle.getHand();
        int dealerHandValue = dealerHand.getHandValue();
        
        if (dealerHand.getHandStatus() != HandStatus.BLACKJACK || dealerHand.getHandStatus() == HandStatus.BUSTED) {
            if (dealerHandValue < dealerHandle.getMinimumStand()) {
                dealerHand.setHandStatus(HandStatus.HIT);
            
                if (isGameOver) {
                    cardDestribution(dealerHand, false);
                    
                }
                
            }
            else if (lowestHandValue > dealerHandValue && dealerHandValue < dealerHandle.getMaximumHit()) {
                dealerHand.setHandStatus(HandStatus.HIT);

                if (isGameOver) {
                    cardDestribution(dealerHand, false);
                    
                }
                
            }
            else {
                dealerHand.setHandStatus(HandStatus.STAND);

            }
                        
        }
        
    } 
    
    //Adds a card to the player's hand.
    private void cardDestribution(Hand hand, boolean isCardVisible) {
        Card card = deck.getCard();
        card.setVisible(isCardVisible);
        
        hand.addCard(card);
        
    }
    
    //Evaluates a player and sets its status.
    private void evaluate(Hand hand) {
        int handValue = hand.getHandValue();
        
        if (handValue > 21) {
            hand.setHandStatus(HandStatus.BUSTED);
            
        }
        else if (handValue == 21) {
            hand.setHandStatus(HandStatus.BLACKJACK);
            
        }

    }
    
    //Determines the winner of the game, sets the player status.
    private void determineWinners() {
        Hand dealerHand = dealerHandle.getHand();
        int dealerHandValue = dealerHand.getHandValue();
        
        switch (dealerHand.getHandStatus()) {
            case BUSTED:
                for (Player player : playerArr) {
                    if (player.getHand().getHandStatus() == HandStatus.BUSTED) {
                        player.setPlayerStatus(PlayerStatus.LOSS);

                    }
                    else {
                        player.setPlayerStatus(PlayerStatus.WIN);

                    }

                }
                
                break;
                
            case BLACKJACK:
                for (Player player : playerArr) {
                    if (player.getHand().getHandStatus() == HandStatus.BLACKJACK) {
                        player.setPlayerStatus(PlayerStatus.PUSH);

                    }
                    else {
                        player.setPlayerStatus(PlayerStatus.LOSS);

                    }

                }
                
                break;
                
            default:
                //Dealer has less than 21.
                for (Player player : playerArr) {
                    switch(player.getHand().getHandStatus()) {
                        case BUSTED:
                            player.setPlayerStatus(PlayerStatus.LOSS);
                            break;
                            
                        case BLACKJACK:
                            player.setPlayerStatus(PlayerStatus.BLACKJACK);
                            break;
                            
                        default:
                            int playerHandValue = player.getHand().getHandValue();
                            
                            if (playerHandValue > dealerHandValue) {
                                player.setPlayerStatus(PlayerStatus.WIN);
                                
                            }
                            else if (playerHandValue == dealerHandValue) {
                                player.setPlayerStatus(PlayerStatus.PUSH);
                                
                            }
                            else {
                                player.setPlayerStatus(PlayerStatus.LOSS);
                                
                            }
                            
                            break;
                            
                    }
                    
                }
                
                break;
            
        }
        
    }
    
    //Creates a log in the the database.
    public void createLog() {
        GameRecord gameRecord = new GameRecord("NORMAL", startDate);
        BlackjackService.setDataGame(gameRecord);
        
        for (Player player : playerArr) {
            String userName = player.getUserName();
            Hand playerHand = player.getHand();
            
            UserRecord userRecord = BlackjackService.getDataUser(userName);
            
            LogRecord logRecord = new LogRecord(gameRecord.getGameId(), userRecord.getUserId(), playerHand.getBet(), playerHand.getHandValue(), player.getPlayerStatus().toString());
            BlackjackService.setDataLog(logRecord);
                        
        }      
        
    }
    
    //Gets and sets
    //Returns the players that are currently in the game.
    public final List<Player> getPlayers() {
        return playerArr;
        
    }
    
    //Creates the start date / time of the game.
    public final java.sql.Date getDate() {
        return startDate;
        
    }
    
    //Returns whether or not the game is over.
    public final boolean isGameOver() {
        return isGameOver;
        
    }
    
}
