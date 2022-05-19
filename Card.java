import ecs100.*;
/**
 * Creacting a card
 *
 * @author (BD)
 * @version (19/05)
 */
public class Card
{
    // instance variables - replace the example below with your own
    private int id;
    private String name;
    private double price;
    private String image;
    static final String DEFAULT_IMAGE = "Blank-Card.png";
    
    int locX = 100;
    int locY = 100;
    final double WIDTH = 100;
    final double HEIGHT = 100;
    

    /**
     * Constructor for objects of class Book
     */
    public Card(int key, String nm, double prc, String img)
    {
        // initialise instance variables
        id = key;
        name = nm;
        price = prc;
        if (img == null) {
            this.image = DEFAULT_IMAGE;
        }else{
            this.image = img;
        }
    }
    /**
     * Constructor overloading
     * Set default image to obj
     */ 
    public Card(int key, String nm, double prc)
    {
        this(key, nm, prc, DEFAULT_IMAGE);
    } 
    
    /**
     * Display image on GUI
     */
    public void displayCard() {
        
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
    
    public boolean cardClicked(double x, double y){
        // an easy approximation is to pretend it is the enclosing rectangle.
        // It is nicer to do a little bit of geometry and get it right
        if ((x >= this.locX) && (x<= this.locX + WIDTH) && (y >= this.locY) && (y<= this.locY + HEIGHT)){  // Makes square around bulb for click
            return true;
        }else{
            return false;
        }
    }   
    
    /**
     * id Getter
     */
    
    public int getId(){
        return this.id;
    }
    
    
    /**
     * Name Getter
     */
    
    public String getName(){
        return this.name;
    }
    
    /**
     * Num Getter
     */
    
    public double getPrc(){
        return this.price;
    }
    
}