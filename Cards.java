import java.util.HashMap;
import ecs100.*;
/**
 * Write a description of class Card here.
 *
 * @author (BD
 * version (19/05)
 */
public class Cards


{
    // instance variables - replace the example below with your own
    private HashMap<Integer, Card> library;     // declaring Hashmap
    private int currCardId;
    private Card currCard; 
    
    /**
     * Constructor for objects of class Card
     */
    public Cards()
    {
        // initialise instance variables
        library = new HashMap<Integer, Card>();
        
        //Creating Contacts
        Card c1 = new Card(1, "The wicked king", 3.89);
        Card c2 = new Card(2, "your mother", 3.42);
        Card c3 = new Card(3, "your father", 29.38);
        
        library.put(1, c1);
        library.put(2, c2);
        library.put(3, c3);
        
        this.currCardId = 3;
       
    }
    
    /**
     * Set CardID
     */
    
    public void setCardId(){
      this.currCardId += 1;
    
    }
    
    public void addCard(String name, double price, String img){
       library.put(currCardId, new Card(currCardId, name, price, img));
    
    }
     
    public boolean findCard(String name) {
        for (int CardId : library.keySet()){
             if (library.get(CardId).getName().toLowerCase().equals(name.toLowerCase())){
              currCard = library.get(CardId);
              library.get(CardId).displayCard(); 
              return true;
             }
        }
        return false;
    }
    
    public Card getCard(){
        return this.currCard;
    }
    
   public void printAll(){
    for(int CardId : library.keySet()){
        UI.println(CardId + " Details:");
        UI.println(library.get(CardId).getName() + " "
                    + library.get(CardId).getPrc());
                 
    }
    
    }
   
}