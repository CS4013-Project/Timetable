package one.group.models.people;

import java.util.ArrayList;

import one.group.models.interfaces.GetID;
import one.group.models.interfaces.Table;

/**
 * The base abstract class for representing a person.
 */
 public abstract class Person implements GetID, Table{
    /** The name of the person. */
    private String name;
    /** The id of the person. */
    private String id;
    /** The persons admin status. */
    private boolean  isAdmin = false;
    /** The persons timetable */
    private ArrayList<String[]> table;
    
    /**
     * Creates Person object with specified name, id and typeOfPerson.
     * @param name the persons name
     * @param id the persons id
     */
    public Person(String name, String id){
        this.name = name;
        this.id = id;
    }

    /**
     * Returns the name of the Person.
     * @return name the persons name
     */
    public String getName(){
        return name;
    }

    /**
     * Returns whether of not the Perosn is an Admin.
     * @return isAdmin the persons admin status
     */
    public boolean getIsAdmin(){
        return isAdmin;
    }

    /**
     * Sets the Admin status of a person with the boolean parameter given.
     * @param truthValue a true or false value
     */
    public void setIsAdmin(boolean truthValue){
        isAdmin = truthValue;
    }

    /** Method to return the users ID. */
    @Override
    public String getID(){
        return id;
    }

    /**
     * Method to access a users table.
     * @return
     */
    @Override
    public ArrayList<String[]> accessTable(){
        return table;
    }

    /**
     * Method to set a users table to the given one.
     */
    @Override
    public void setTable(ArrayList<String[]> newArrayList){
        table = newArrayList;
    }

}