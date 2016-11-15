/*
    DATABASE SINGLETON CLASS
    Contains the connection to the database.
*/

package databank.properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
    
    //Variables
    private static DatabaseSingleton reference;
    private static Connection connection;
    
    //Methods
    private DatabaseSingleton() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            
        }
        
    }
    
    //Gets and sets
    //Returns the reference to this object.
    public static DatabaseSingleton getDatabaseSingleton() {
        if (reference == null) {
            reference = new DatabaseSingleton();
            
        }
        
        return reference;
        
    }
    
    //Returns the connection with the database.
    public Connection getConnection(boolean autoCommit) {
        try {
            connection = DriverManager.getConnection(DatabaseProperties.HOST_NAME,
                                                     DatabaseProperties.USERNAME,
                                                     DatabaseProperties.PASSWORD);
            
            connection.setAutoCommit(autoCommit);
            
        } 
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return connection;
        
    }
    
}
