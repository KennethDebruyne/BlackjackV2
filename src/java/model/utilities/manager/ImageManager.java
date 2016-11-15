/*
    IMAGE MANAGER CLASS
    Distributes all correct image paths.
 */

package model.utilities.manager;

import model.utilities.enumeration.CardSuit;
import model.utilities.enumeration.CardValue;

public class ImageManager {
    
    //Methods
    public ImageManager() {
    }
    
    //Gets and sets
    //Returns an image path of a card by suit and value enumeration.
    public static final String getImagePath(CardSuit cardSuit, CardValue cardValue) {
        String imagePath = "Images/Cards/";
        imagePath += cardSuit.toString();
        imagePath += cardValue.toString();
        imagePath += ".png";
        
        return imagePath;
        
    }
    
    //Returns an image path by attribute name.
    public static final String getImagePath(String attributeName) {
        switch (attributeName.toUpperCase()) {
            case "DEALER":
                return "Images/Gargamel.png";
                
            default:
                return null;
            
        }
        
    }
    
}
