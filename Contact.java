import ecs100.*;
/**
 * Creacting a contact
 *
 * @author (BD)
 * @version (19/04)
 */
public class Contact
{
    // instance variables - replace the example below with your own
    private int id;
    private String name;
    private String number;
    private String image;
    static final String DEFAULT_IMAGE = "contact.png";
    
    double locX = GUI.x - 30;
    double locY = GUI.y - 20;
    final double WIDTH = 50;
    final double HEIGHT = 50;
    

    /**
     * Constructor for objects of class Book
     */
    public Contact(int key, String nm, String num, String img)
    {
        // initialise instance variables
        id = key;
        name = nm;
        number = num;
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
    public Contact(int key, String nm, String num)
    {
        this(key, nm, num, DEFAULT_IMAGE);
    } 
    
    /**
     * Display image on GUI
     */
    public void displayContact() {
        
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
    
    public boolean bookClicked(double x, double y){
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
    
    public String getNum(){
        return this.number;
    }
    
}
