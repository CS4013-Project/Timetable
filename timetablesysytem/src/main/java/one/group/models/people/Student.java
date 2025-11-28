package one.group.models.people;

import java.util.ArrayList;
import java.util.List;

import one.group.models.repositories.TablesRepo;
import one.group.models.services.GroupService;
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

    private String groupId;
    private String subgroupId;

    /**Create Student.
     * @param name the students name
     * @param id the students id
     * @param courseID the id of the student's course
     * @param yearOfStudy the year of study of the student
     */
    public Student(String name, String id, String courseID, int yearOfStudy, String groupId, String subgroupId){
        super(name, id);
        this.courseID = courseID;
        this.yearOfStudy = yearOfStudy;
        this.groupId = groupId;
        this.subgroupId = subgroupId;
    }

    /** 
     * Method to return the year of study for the stuent.
     * @return the students year of study.
     */
    public int getYearOfStudy(){
        return yearOfStudy;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getSubgroupId(){
        return subgroupId;
    }

    public String getCourseID(){
        return courseID;
    }

    public String getGroupInfo(){
        return "Main Group: "+ groupId + "\n" +
                "Subgroup: "+ subgroupId + "\n" +
                "Course: " + courseID + "- Year " + yearOfStudy;
    }

    public List<String> getSubgroupMembers(){
        List<String> members = new ArrayList<>();
        for(String[] row : TablesRepo.getStudentsTable()){
            Student otherStudent = GroupService.createStudentFromCSV(row);

            if(otherStudent!=null && otherStudent.getSubgroupId().equals(this.subgroupId)&&!otherStudent.getID().equals(this.getID())){
                members.add(otherStudent.getName() + " ("+ otherStudent.getID() + ")");
            }
        }
        return members;
    }

    public ArrayList<String[]> getGroupTimetable(){
        ArrayList<String[]> groupTimetable = new ArrayList<>();
        ArrayList<String[]> allTimetable = TablesRepo.getTermsTable();

        for(int i=0;i<allTimetable.size();i++){
            String[] entry = allTimetable.get(i);

            if(entry.length!=9){
                System.out.println("Skipping corrupted row" + i + ": length="+entry.length);
                continue;
            }

            if(entry[0].equals("DAY")){
                continue;
            }
            String entryCourse = entry[6];
            String entryYear = entry[7];
            String entryTerm = entry[8];
            if(entryCourse.equals(courseID)&&entryYear.equals(String.valueOf(yearOfStudy))&&Integer.parseInt(entryTerm)==Term.getTerm()){
                groupTimetable.add(entry);
            }
        }
        return groupTimetable;
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
