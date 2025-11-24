package one.group.controller;
import one.group.viewer.Menu;

/** The class for the controller segment of the programme. */
public class Run {
    /**
     * The main method for the controller.
     * @param args the command line arguments.
     * Uses the boolean value for 'go' to sustain a while loop, go is set to false when the menu returns false.
     */
    public static void main(String[] args){
        Menu menu = new Menu();

        boolean go = true;

        while(go){
            go = menu.runMenu();
        }
    }
}