/*
    DEALER CLASS    
    Represents the dealer in the game.
 */

package model.player;

public class Dealer extends Player {
    
    //Variables
    private final int minStand;
    private final int maxHit;
    
    //Methods
    public Dealer(String iconUri, int minStand, int maxHit) {
        super("DEALER", iconUri, -1, -1);
        
        this.minStand = minStand;
        this.maxHit = maxHit;
        
    }
    
    //Gets and sets
    //Returns the maximum value for hiting a new card.
    public final int getMaximumHit() {
        return maxHit;
        
    }
    
    //Returns the minimum stand value.
    public final int getMinimumStand() {
        return minStand;
        
    }
    
}
