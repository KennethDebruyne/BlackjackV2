/*
    BLACKJACK SERVICE CLASS
    Handles all communication with the DAO classes via the service layer.
*/

package databank.service;

import java.util.List;

import databank.dao.*;
import databank.model.*;
import databank.utilities.Conversion;

public class BlackjackService {
    
    //Methods
    public BlackjackService() {
    }
    
    //Gets and sets
    // --- USER ---
    //Returns how much users there were found in the database.
    public static int getCountUsers() {
        return UserDao.getCountData();
        
    }
    
    //Returns all users.
    public static List<UserRecord> getAllUsers() {
        return Conversion.getListUser(UserDao.getAllData());
        
    }
    
    //Retuns a user by id.
    public static UserRecord getDataUser(int userId) {
        return UserDao.getData(userId);
        
    }
    
    //Returns a user by user name.
    public static UserRecord getDataUser(String userName) {
        return UserDao.getData(userName);
        
    }
    
    //Adds a user to the database, returns the updated rows.
    public static int setDataUser(UserRecord newUser) {
        return UserDao.setData(newUser);
        
    }
    
    //Edits an existing user from the database, returns the updated rows.
    public static int editDataUser(UserRecord editedUser) {
        return UserDao.editData(editedUser);
        
    }
    
    //Deletes a user from the database, returns the amount of deleted rows.
    public static int deleteDataUser(int userId) {
        return UserDao.deleteData(userId);
        
    }
    
    // --- GAME ---
    //Returns a game by id.
    public static GameRecord getDataGame(int gameId) {
        return GameDao.getData(gameId);
        
    }
    
    //Adds a game record to the database, returns the updated rows.
    public static int setDataGame(GameRecord newGame) {
        return GameDao.setData(newGame);
        
    }
    
    // --- LOG ---
    //Returns a list of logs by game id.
    public static List<LogRecord> getDataLogGame(int gameId) {
        return Conversion.getListLog(LogDao.getDataByGame(gameId));
        
    }
    
    //Returns a list of logs by user id.
    public static List<LogRecord> getDataLogUser(int userId) {
        return Conversion.getListLog(LogDao.getDataByUser(userId));
        
    }
    
    //Adds a log to the database, returns the updated rows.
    public static int setDataLog(LogRecord newLog) {
        return LogDao.setData(newLog);
        
    }
    
}
