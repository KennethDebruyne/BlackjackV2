/*
    USERS GROUP DAO
    Dao class for the 'Users_Group' table.
 */

package databank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersGroupDao extends DAO {
    
    //Variables
    private static String sTABLE = "users_group";
    
    //Methods
    public UsersGroupDao() {
    }
    
    //Gets and sets
    //Returns the name of the user group of the corresponding user id.
    public static String getData(int userId) {
        String query = "SELECT * "
                     + "FROM " + sTABLE + " "
                     + "WHERE USERID = " + userId;
        
        Connection connection;
        Statement statement;
        
        try {
            connection = createConnection();
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            if (resultSet.next()) {
                return resultSet.getString("GROUP_NAME");
                
            }
            
        } 
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return null;
        
    }
    
}
