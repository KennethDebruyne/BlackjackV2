/*
    USER RECORD CLASS
    User record class contains all data from the database table 'User'.

    *User record class has an extra data field, 'bet', which will only be used on the site to initialize the game class.

 */

package databank.model;

public class UserRecord {
    
    //Variables
    private int userId = -1;
    private final String firstName;
    private final String lastName;
    private final String iconUri;
    private final String password;
    private int balance;
    
    private int bet = 0;
    
    //Methods
    public UserRecord(String firstName, String lastName, String iconUri, String password, int balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.iconUri = iconUri;
        this.password = password;
        this.balance = balance;
        
    }
    
    //Gets and sets
    //Returns the user id.
    public int getUserId() {
        return userId;
        
    }
    
    //Sets the user id.
    public void setUserId(int userId) {
        this.userId = userId;
        
    }
    
    //Returns the first name of the user.
    public final String getFirstName() {
        return firstName;
        
    }
    
    //Returns the last name of the user.
    public final String getLastName() {
        return lastName;
        
    }
    
    //Returns the URI of an icon / image.
    public final String getIconUri() {
        return iconUri;
        
    }
    
    //Returns the password of the user, null if there was no password found.
    public final String getPassword() {
        return password;
        
    }
    
    //Returns the balance of the user.
    public final int getBalance() {
        return balance;
        
    }
    
    //Sets the balance to a new number.
    public void setBalance(int balance) {
        this.balance = balance;
        
    }
    
    //Gets the bet the user is making.
    public final int getBet() {
        return bet;
        
    }
    
    //Sets the bet the user wants to make.
    public void setBet(int bet) {
        this.bet = bet;
        
    }
    
}
