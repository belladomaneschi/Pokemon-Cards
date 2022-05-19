import java.util.HashMap;
import ecs100.*;
/**
 * Write a description of class GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private Cards cards;      //declear books instance
    private Card card;        //declear book instance

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        cards = new Cards();
        UI.initialise();
        UI.setMouseListener(this::imageClick); 
        UI.addButton("Print All", cards::printAll);
        UI.addButton("Add a Card", this::addCard);
        UI.addButton("Find a Card", this::findCard);
        UI.addButton("Clear All", this::clearEverything);
        UI.addButton("Quit", UI::quit);
    }

    /**
     * Add a book to collection
     */
    public void addCard(){
       String name = UI.askString("Card Name: ");
       double price = UI.askDouble("Price: ");
       
                   
       // add a book image for display in the GUI
       String imgFileName = UIFileChooser.open("Choose Image File: ");
            
       // Increment the book ID count and add to hashmap
       cards.setCardId();  // increment the id by 1
       cards.addCard(name, price, imgFileName);
    }
    
    public void clearEverything(){
        UI.clearText();
        UI.clearGraphics();
    }
    
    public void findCard() {
        String cardName = UI.askString("Card Name: ");
        if (cards.findCard(cardName.toLowerCase())){
            UI.println("Found Card");
            card = cards.getCard();
            UI.println("Name: " + card.getName());
            UI.println("Number: " + card.getPrc());
            
        }else {
            UI.println("That Contact Does Not Exist! ");
        }
        
        }
    
    public void imageClick(String action, double x, double y){
        if (action.equals("clicked")){
            if(card.cardClicked(x,y)){
                clearEverything();
            }else {
                UI.println(x + " " + " " + y);
                UI.println("Click on image to clear text");
            
            }  
        }
    
    }
}