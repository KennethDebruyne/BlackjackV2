/*
    DAO ABSTRACT CLASS
    The DAO class functions as a base class for all DAO's in the application.
*/

package databank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import databank.properties.DatabaseSingleton;

public abstract class DAO {
    
    //Variables
    private static Connection connection;
    
    //Methodes
    protected DAO() {
    }
    
    //Creates a connection.
    protected static Connection createConnection() {
        if (connection == null) {
            connection = DatabaseSingleton.getDatabaseSingleton().getConnection(false);
            
        }
        
        return connection;
        
    }
    
    //Closes the connection.
    protected static boolean closeConnection() {
        boolean isClosed;
        
        try {
            if (connection != null) {
                connection.close();
                isClosed = true;
            
            }
            else {
                isClosed = false;
                
            }
            
        } 
        catch (SQLException e) {
            isClosed = false;
            e.printStackTrace();
            
        }
        
        return isClosed;
        
    }
    
    //Gets and sets
    //Returns how much records there were found.
    protected static int getCountDataRows(String table, String columnName) {
        String query = "SELECT COUNT(" + columnName + ") "
                     + "FROM " + table;
        
        ResultSet resultSet;
        Statement statement;
        
        try {
            createConnection();
            
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            
            resultSet.next();
            return resultSet.getInt(1);
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return -1;
        
    }
    
    //Returns the last index in the table.
    protected static int getLastIndex(String table, String columnName) {
        String query = "SELECT MAX(" + columnName + ") "
                     + "FROM " + table;
        
        ResultSet resultSet;
        Statement statement;
        
        try {
            createConnection();
            
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            
            resultSet.next();
            return resultSet.getInt(1);
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return -1;
        
    }
    
}
