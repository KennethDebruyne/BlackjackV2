/*
    CONVERSION CLASS
    Converts ResultSets to lists of specific objects.
*/

package databank.utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databank.model.*;

public class Conversion {
    
    //Methods
    public Conversion() {
    }
    
    //Gets and sets
    // --- USER ---
    public static List<UserRecord> getListUser(ResultSet resultSet) {
        List<UserRecord> list = new ArrayList();        
        
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("userID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String iconUri = resultSet.getString("icon");
                String password = resultSet.getString("password");
                int balance = resultSet.getInt("balance");

                UserRecord userRecord = new UserRecord(firstName, lastName, iconUri, password, balance);
                userRecord.setUserId(id);
                
                list.add(userRecord);
                
            }
            
        } 
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return list;
        
    }
    
    // --- LOG ---
    //Returns a list of Log objects.
    public static List<LogRecord> getListLog(ResultSet resultSet) {
        List<LogRecord> list = new ArrayList();        
        
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("logID");
                int gameId = resultSet.getInt("gameID");
                int userId = resultSet.getInt("userID");
                int bet = resultSet.getInt("bet");
                int handValue = resultSet.getInt("handValue");
                String playerStatus = resultSet.getString("playerStatus");
                
                LogRecord logRecord = new LogRecord(gameId, userId, bet, handValue, playerStatus);
                logRecord.setLogId(id);
                
                list.add(logRecord);
                
            }
            
        } 
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return list;

    }
    
}
