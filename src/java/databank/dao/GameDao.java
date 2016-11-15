/*
    GAME DAO CLASS
    DAO class for the Game table.
*/

package databank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import databank.model.GameRecord;

public class GameDao extends DAO {
    
    //Variables
    private final static String sTABLE = "game";
    
    //Methods
    public GameDao() {
        super();
        
    }
    
    //Gets and sets
    //Returns a GameRecord object by id.
    public static GameRecord getData(int gameId) {
        String query = "SELECT * "
                     + "FROM " + sTABLE
                     + "WHERE gameID = " + gameId;
        
        Connection connection;
        Statement statement;
        
        try {
            connection = createConnection();
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            if (resultSet.next()) {
                int id = resultSet.getInt("gameID");
                String gameType = resultSet.getString("gameType");
                Date timestamp = resultSet.getDate("timestamp");
                
                GameRecord gameRecord = new GameRecord(gameType, timestamp);
                gameRecord.setGameId(gameId);
                
                return gameRecord;
                
            }
            
        } 
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return null;
        
    }
    
    //Creates a game record.
    public static int setData(GameRecord newGame) {
        int index = getLastIndex(sTABLE, "gameID") + 1;
        String query = "INSERT INTO " + sTABLE + " (gameID, gameType, timestamp) "
                     + "VALUES (" + index + ", " + newGame.getGameType() + ", " + newGame.getTimestamp() + ")";
        
        Connection connection = createConnection();
        Statement statement;
        
        int updatedRows = -1;
        try {
            statement = connection.createStatement();
            
            updatedRows = statement.executeUpdate(query);
            connection.commit();
            
        } 
        catch (SQLException updateException) {
            updateException.printStackTrace();
            
            try {
                connection.rollback();
                
            } 
            catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
                
            }

        }
        
        return updatedRows;
        
    }
    
}
