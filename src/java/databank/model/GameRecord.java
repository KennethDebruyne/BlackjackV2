/*
    GAME RECORD CLASS
    Game record class contains all data from the database table 'Game'.
 */

package databank.model;

import java.sql.Date;

public class GameRecord {
    
    //Variables
    private int gameId = -1;
    private final String gameType;
    private final Date timestamp;
    
    //Methods
    public GameRecord(String gameType, Date timestamp) {
        this.gameType = gameType;
        this.timestamp = timestamp;
        
    }
    
    //Gets and sets
    //Returns the game id.
    public int getGameId() {
        return gameId;
        
    }
    
    //Sets the game id.
    public void setGameId(int gameId) {
        this.gameId = gameId;
        
    }
    
    //Returns the game type.
    public final String getGameType() {
        return gameType;
        
    }
    
    //Returns the timestamp.
    public final Date getTimestamp() {
        return timestamp;
        
    }
    
}
