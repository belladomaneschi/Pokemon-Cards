import java.util.HashMap;
import ecs100.*;
import java.util.Map;
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
    private double totVal = 0.0;
    
    /**
     * Constructor for objects of class Card
     */
    public Cards()
    {
        // initialise instance variables
        library = new HashMap<Integer, Card>();
        
        //Creating Contacts
        Card c1 = new Card(1, "Picachu", 3.89);
        Card c2 = new Card(2, "Carizard", 3.42);
        Card c3 = new Card(3, "Metapod", 29.38);
        
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
    
    public void removeCard(String name){
         library.remove(name);
         UI.println("Card had been removed");
    
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
    UI.clearText(); 
    totVal = 0; // if print button is hit more then once it does not effect to total price
    UI.println("All Cards: \n");
    for(int CardId : library.keySet()){
        UI.println(CardId + " Details:");
        UI.println(library.get(CardId).getName() + " "
                    + " $" + library.get(CardId).getPrc());
                    
        totVal += library.get(CardId).getPrc();
                 
    }
    UI.println("\n----------------------------");
    
    UI.println("\nThere are " + library.size() + " cards in the collection");
    UI.println("With a Value of: $" + totVal);
    
    }
   
}