 import java.util.HashMap;
import ecs100.*;
import java.util.*;
/**
 * Write a description of class Contacte here.
 *
 * @author (BD
 * version (11/4)
 */
public class Contacts


{
    // instance variables - replace the example below with your own
    private HashMap<Integer, Contact> library;     // declaring Hashmap
    private int currContactId;
    private Contact currContact;

    
    /**
     * Constructor for objects of class Contacte
     */
    public Contacts()
    {
        // initialise instance variables
        library = new HashMap<Integer, Contact>();
        
        //Creating Contacts
        Contact c1 = new Contact(1, "The", "2984719");
        Contact c2 = new Contact(2, "your mother", "342342");
        Contact c3 = new Contact(3, "your father", "2938749");
        
        library.put(1, c1);
        library.put(2, c2);
        library.put(3, c3);
        
        this.currContactId = 3;
       
    }
    
    /**
     * Set ContactID
     */
    
    public void setContactId(){
      this.currContactId += 1;
    
    }
    
    public void addContact(String name, String number, String img){
       library.put(currContactId, new Contact(currContactId, name, number, img));
    
    }
     
    public boolean findContact(String name) {
        for (int ContactId : library.keySet()){
             if (library.get(ContactId).getName().toLowerCase().equals(name.toLowerCase())){

              currContact = library.get(ContactId);
              library.get(ContactId).displayContact(); 
              return true;
             }
        }
        return false;
    }
    
    public Contact getContact(){
        return this.currContact;
    }
    
    public void printAll(){
        UI.setFontSize(15.0);
        GUI.clearEverything();
        if (library.size() > 0){
                for(int ContactId : library.keySet()){
        
                
                UI.drawString(ContactId + " Details:", GUI.x, GUI.y);
                
                
                String name = library.get(ContactId).getName();
                String Num = library.get(ContactId).getNum();
                
        
                UI.drawString("Name: " + name, GUI.x, GUI.y + 20);
                UI.drawString("Number: " + Num, GUI.x , GUI.y + 38);        
                
                GUI.y = GUI.y + 58;
                
                
                         
            }
        }else {
            UI.println("There are no Contacts Added Click Add Contact to Begin"); 
            
        }
    }
   
}