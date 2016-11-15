/*
    LOG RECORD CLASS
    Log record class contains all data from the database table 'Log'.
 */

package databank.model;

public class LogRecord {
    
    //Variables
    private int logId = -1;
    private final int gameId;
    private final int userId;
    private final int bet;
    private final int handValue;
    private final String playerStatus;
    
    //Methods
    public LogRecord(int gameId, int userId, int bet, int handValue, String playerStatus) {
        this.gameId = gameId;
        this.userId = userId;
        this.bet = bet;
        this.handValue = handValue;
        this.playerStatus = playerStatus;
        
    }
    
    //Gets and sets
    //Returns the log id.
    public final int getLogId() {
        return logId;
        
    }
    
    //Sets the log id.
    public void setLogId(int logId) {
        this.logId = logId;
        
    }
    
    //Returns the game id.
    public final int getGameId() {
        return gameId;
        
    }
    
    //Returns the user id.
    public final int getUserId() {
        return userId;
        
    }
    
    //Returns how much the user was betting for.
    public final int getBet() {
        return bet;
        
    }
    
    //Returns the value of all cards in the user's hand.
    public final int getHandValue() {
        return handValue;
        
    }
    
    //Returns the player status as string.
    public final String getPlayerStatusString() {
        return playerStatus;
        
    }
    
}
