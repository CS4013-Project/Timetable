package one.group.models.people;

import one.group.models.term.Term;

/** A Class for admin users*/
public class Admin{
    private String id;
    private String name;
    private String password;
    /**
     * Creates an Admin user with the given id and name.
     * @param id   the admins id
     * @param name the admins name
     */
    public Admin(String id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    /**
     * Method to set the term for the system and by extension what timetable is shown. 
     * @param n int that should be either 1 or 2.
     */
    public void setTerm(int n){
        Term.setTerm(n);
    }
}
