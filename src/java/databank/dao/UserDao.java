/*
    USER DAO CLASS
    DAO class for the User table.
*/

package databank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import databank.model.UserRecord;

public class UserDao extends DAO {
    
    //Variables
    private static final String sTABLE = "user";
    
    //Methods
    public UserDao() {
        super();
        
    }
    
    //Gets and sets
    //Returns how much users there are in the database.
    public static int getCountData() {
        return getCountDataRows(sTABLE, "userID");
        
    }
    
    //Returns all users in a result set.
    public static ResultSet getAllData() {
        String query = "SELECT * "
                     + "FROM " + sTABLE;
        
        Connection connection;
        Statement statement;
        
        ResultSet resultSet = null;
        try {
            connection = createConnection();
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(query);

            
        } 
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return resultSet;
        
    }
    
    //Returns a UserRecord object by id.
    public static UserRecord getData(int userId) {
        String query = "SELECT * "
                     + "FROM " + sTABLE + " "
                     + "WHERE userID = " + userId;
        
        Connection connection;
        Statement statement;
        
        try {
            connection = createConnection();
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            if (resultSet.next()) {
                return getUser(resultSet);
                
            }
            
        } 
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return null;
        
    }
    
    //Returns a userRecord by user name.
    public static UserRecord getData(String userName) {
        String query = "SELECT *, ISNULL(firstName,'') + ' ' + ISNULL(lastName,'') as fullName "
                     + "FROM " + sTABLE + " "
                     + "WHERE fullName = " + userName;
        
        Connection connection;
        Statement statement;
        
        try {
            connection = createConnection();
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            if (resultSet.next()) {
                return getUser(resultSet);
                
            }
            
        } 
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return null;
    
    }
    
    //Creates a user record.
    public static int setData(UserRecord newUser) {
        int index = getLastIndex(sTABLE, "userID") + 1;
        String query = "INSERT INTO " + sTABLE + " (userID, firstName, lastName, icon, password, balance) "
                     + "VALUES ('" + index + "', '" + newUser.getFirstName() + "', '" + newUser.getLastName() + "', '" + newUser.getIconUri() + "', '" + newUser.getPassword() + "', '" + newUser.getBalance() + "')";
        
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
    
    //Edits an existing user in the database.
    public static int editData(UserRecord editedUser) {
        String query = "UPDATE " + sTABLE + " "
                     + "SET firstName='" + editedUser.getFirstName() + "', lastName='" + editedUser.getLastName() + "', icon ='" + editedUser.getIconUri() + "', password ='" + editedUser.getPassword() + "', balance ='" + editedUser.getBalance() + "' "
                     + "WHERE userID ='" + editedUser.getUserId() + "'";
        
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
    
    //Deletes a user by id.
    public static int deleteData(int userId) {
        String query = "DELETE "
                     + "FROM " + sTABLE + " "
                     + "WHERE userID = " + userId;
        
        Connection connection = createConnection();
        Statement statement;
        
        int updatedRows = -1;
        try {
            statement = connection.createStatement();
            
            updatedRows = statement.executeUpdate(query);
            connection.commit();
            
        } 
        catch (SQLException deleteException) {
            deleteException.printStackTrace();
            
            try {
                connection.rollback();
                
            } 
            catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
                
            }
            
        }
        
        return updatedRows;
        
    }
    
    //Creates a user object.
    private static UserRecord getUser(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("userID");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String iconUri = resultSet.getString("icon");
        String password = resultSet.getString("password");
        int balance = resultSet.getInt("balance");

        UserRecord userRecord = new UserRecord(firstName, lastName, iconUri, password, balance);
        userRecord.setUserId(id);
        
        return userRecord;
        
    }
    
}
