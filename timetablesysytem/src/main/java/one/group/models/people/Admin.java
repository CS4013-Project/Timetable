package one.group.models.people;

import one.group.models.repositories.TablesRepo;
import one.group.models.services.GroupConflictService;
import one.group.models.services.RoomValidationService;
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

    /**
     * Method to add an entry to timetable
     * @param module
     * @param timeRange
     * @param classType
     * @param room
     * @param lecturer
     * @param day
     * @param course
     * @param year
     * @param term
     * @return
     */
    public boolean addTimetableEntry(String module, String timeRange, String classType, String room, String lecturer, String day, String course, int year, int term){
        // CHECKS ROOM TYPE VALIDATION
        if(!RoomValidationService.isValidRoomForEvent(room, classType)){
            return false;
        }


        if(GroupConflictService.hasGroupConflict(course,year,day,timeRange.split("-")[0],timeRange.split("-")[1],term)){
            System.out.println("Error: Student Group conflict detected");
            return false;
        }


        String[] newEntry = {
                day,
                timeRange,
                module,
                classType,
                room,
                lecturer,
                course,
                String.valueOf(year),
                String.valueOf(term)
        };
        TablesRepo.addTimetableEntry(newEntry);
        return true;
    }

    /**
     * Method to remove a timetable entry
     *
     * @param module
     * @param day
     * @param timeRange
     * @return
     */
    public void removeTimetableEntry(String module, String day, String timeRange){
        TablesRepo.removeTimeTableEntry(module, day, timeRange, Term.getTerm());
    }

}
