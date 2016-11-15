/*
    LOG DAO CLASS
    DAO class for the Log table.
*/

package databank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import databank.model.LogRecord;

public class LogDao extends DAO {
    
    //Variables
    private final static String sTABLE = "log";
    
    //Methods
    public LogDao() {
        super();
        
    }
    
    //Gets and sets
    //Returns a LogRecord object by id.
    public static LogRecord getData(int logId) {
        String query = "SELECT * "
                     + "FROM " + sTABLE + " "
                     + "WHERE logID = " + logId;
        
        Connection connection;
        Statement statement;
        
        try {
            connection = createConnection();
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            if (resultSet.next()) {
                int id = resultSet.getInt("logID");
                int gameId = resultSet.getInt("gameID");
                int userId = resultSet.getInt("userID");
                int bet = resultSet.getInt("bet");
                int handValue = resultSet.getInt("handValue");
                String playerStatus = resultSet.getString("playerStatus");
                
                LogRecord logRecord = new LogRecord(gameId, userId, bet, handValue, playerStatus);
                logRecord.setLogId(id);
                
                return logRecord;
                
            }
            
        } 
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return null;
        
    }
    
    //Returns all logs of a specific user.
    public static ResultSet getDataByUser(int userId) {
        String query = "SELECT * "
                     + "FROM " + sTABLE + " "
                     + "WHERE userID = " + userId;
        
        Connection connection;
        Statement statement;
        
        try {
            connection = createConnection();
            statement = connection.createStatement();
            
            return statement.executeQuery(query);
            
        } 
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return null;
        
    }
    
    //Returns all logs of a specific game.
    public static ResultSet getDataByGame(int gameId) {
        String query = "SELECT * "
                     + "FROM " + sTABLE + " "
                     + "WHERE gameID = " + gameId;
        
        Connection connection;
        Statement statement;
        
        try {
            connection = createConnection();
            statement = connection.createStatement();
            
            return statement.executeQuery(query);
            
        } 
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return null;
        
    }

    //Creates a log record.
    public static int setData(LogRecord newLog) {
        int index = getLastIndex(sTABLE, "userID") + 1;
        String query = "INSERT INTO " + sTABLE + " (logID, gameID, userID, bet, handValue) "
                     + "VALUES (" + index + ", " + newLog.getGameId() + ", " + newLog.getUserId() + ", " + newLog.getBet() + ", " + newLog.getHandValue() + ")";
        
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
