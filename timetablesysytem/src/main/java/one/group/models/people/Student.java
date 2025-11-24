package one.group.models.people;

import java.util.ArrayList;

import one.group.models.repositories.TablesRepo;
import one.group.models.term.Term;

/** The class to represent a student. */
public class Student extends Person {
    /** String to represent the course of the student. */
    private String courseID;
    /** String to represent the year of study of the student. */
    private int yearOfStudy;
    /** String to represent the id of the student. */
    private String id;
    /** String to represent the name of the student. */
    private String name;

    /**Create Student.
     * @param name the students name
     * @param id the students id
     * @param courseID the id of the student's course
     * @param yearOfStudy the year of study of the student
     */
    public Student(String name, String id, String courseID, int yearOfStudy){
        super(name, id);
        this.courseID = courseID;
        this.yearOfStudy = yearOfStudy;
    }

    /** 
     * Method to return the year of study for the stuent.
     * @return the students year of study.
     */
    public int getYearOfStudy(){
        return yearOfStudy;
    }

    /** Method queryTable implemented for a student, called by getTable() if current users table is null. Sets users table to result. */
    @Override
    public void queryTable(){
        ArrayList<String[]> thisStudentsTimetable = new ArrayList<>();
        ArrayList<String[]> termsTimetable = TablesRepo.getTermsTable();
        for(String[] row: termsTimetable){
            if(row[6].equals(courseID)&&Integer.parseInt(row[7]) == getYearOfStudy()&&Integer.parseInt(row[8]) == Term.getTerm()){
                thisStudentsTimetable.add(row);
            }
        }
        setTable(thisStudentsTimetable);
    }

    /** Method to get the users table. Checks if current table is null, if it is, the method calls queryTable() to make one. 
    *@return the students timetable. 
    */
    @Override
    public ArrayList<String[]> getTable(){
        if(accessTable() == null){
            queryTable();
        }
        return accessTable();
    }

    /**
     *  Method to print the students table.
     * @param tableToPrint
     */
    @Override
    public void printTable(ArrayList<String[]> tableToPrint){
    for(String[] row: tableToPrint){
        for(int i = 0;i < 5;i++){
            System.out.printf(" %s | ", row[i]);
            }
        System.out.printf("\n------\n");
        }
    }
}
