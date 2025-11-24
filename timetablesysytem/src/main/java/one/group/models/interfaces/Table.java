package one.group.models.interfaces;

import java.util.ArrayList;
/** Interface formalising the use of getTable() across unrelated classes. */
public interface Table {

    /** Timetable field, an ArrayList of 1D String arrays. */
    public ArrayList<String[]> timetable = new ArrayList<>();
    
    /** Method to retrieve a table. */
    public ArrayList<String[]> getTable();
    
    /** Method to generate a timetable for an entity from the CSV files, creates an ArrayList<String>. */
    public void queryTable();

    /** Method to set an entities table as the parameter. */
    public void setTable(ArrayList<String[]> newArrayList);

    /** Method to print a table. */
    public void printTable(ArrayList<String[]> tableToPrint);

    public ArrayList<String[]> accessTable();
}
