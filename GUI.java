import java.util.HashMap;
import java.util.regex.*;
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
    private Contacts contacts;      //declear books instance
    private Contact contact;        //declear book instance
    
    public static double x = 60;
    public static double y = 50;

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        contacts = new Contacts();
        UI.initialise();
        UI.setMouseListener(this::imageClick); 
        UI.addButton("Print All", contacts::printAll);
        UI.addButton("Add a Contact", this::addContact);
        UI.addButton("Find a contact", this::findContact);
        UI.addButton("Clear All", GUI::clearEverything);
        UI.addButton("Quit", UI::quit);

    }

    /**
     * Add a book to collection
     */
    public void addContact(){
       String name = UI.askString("Name: ");
       errorCheckingName(name);
       
       String number = UI.askString("Number: ");
       errorCheckingNum(number);
       
                   
       // add a book image for display in the GUI
       String imgFileName = UIFileChooser.open("Choose Image File: ");
            
       // Increment the book ID count and add to hashmap
       contacts.setContactId();  // increment the id by 1
       contacts.addContact(name, number, imgFileName);
    }
    
    public static void clearEverything(){
        UI.clearText();
        UI.clearGraphics();
        x = 50;
        y = 50;
    }
    
    public void findContact() {
        String contactName = UI.askString(" Contact Name: ");
        UI.setFontSize(15.0); 
        if (contacts.findContact(contactName.toLowerCase())){
            UI.clearGraphics();
            UI.println("Found Contact");
            
            contact = contacts.getContact();
            String name = contact.getName();
            String Num = contact.getNum();
            
            UI.drawString("Name: " + name, x, y);
            UI.drawString("Number: " + Num, x, y + 20);
            
        }else {
            UI.println("That Contact Does Not Exist! ");
        }
        
        }
        
    public void errorCheckingName(String nm) {
        if ((nm.length() > 1) &&(nm.length() < 50)){
              if (Pattern.matches("^[a-zA-Z0-9!@#$&()\\-`.+,/\"]*$", nm)){
                   return;
                
            }else{
                UI.println("this is not a vaild name please reenter");
                addContact();
            }
        }else{
            UI.println("this is not a vaild name please reenter");
            addContact();
        }
    }
    
    public void errorCheckingNum(String num) {
        if ((num.length() > 7) && (num.length() < 13)){
              if (Pattern.matches("^[0-9]+$", num)){
                   return;
                
            }else{
                UI.println("this is not a vaild number please reenter");
                addContact();
            }
        }else{
            UI.println("this is not a vaild number please reenter");
            addContact();
        }
    }
    
    public void imageClick(String action, double x, double y){
        if (action.equals("clicked")){
            if(contact.bookClicked(x,y)){
                UI.clearGraphics();
            }else {
                UI.println("Click on image to clear text");
            
            }  
        }
    
    }
}