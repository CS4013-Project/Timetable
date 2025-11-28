package one.group.models.services;
import one.group.models.people.Student;
import one.group.models.people.StudentGroup;
import one.group.models.repositories.TablesRepo;

import java.util.*;

/**
 * Class that handles organizing students into their respective groups
 */
public class GroupService {
    /**
     * Creates a student object from CSV row data
     * Automatically handles header row detection and missing group data
     * @param csvRow
     * @return
     */
    public static Student createStudentFromCSV(String[] csvRow){
        if(csvRow[0].equals("ID") || !isNumeric(csvRow[3])){
            return null;
        }

        String id = csvRow[0];
        String name = csvRow[1];
        String course = csvRow[2];
        int year = Integer.parseInt(csvRow[3]);

        String groupId = (csvRow.length>4) ? csvRow[4] : course + "-" + year;
        String subgroupId = (csvRow.length > 5) ? csvRow[5] : groupId + "-A";

        return new Student(name, id, course, year, groupId, subgroupId);
    }

    /**
     * Checks if a string can be parsed as an integer
     * Used for validating numeric fields in csv data
     * @param str
     * @return
     */
    private static boolean isNumeric(String str){
        try{
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * Organizes students into groups
     * @return
     */
    public static Map<String, StudentGroup> organizeStudentsIntoGroups(){
        Map<String, StudentGroup> groups = new HashMap<>();

        for(String[] row :  TablesRepo.getStudentsTable()) {
            Student student = createStudentFromCSV(row);
            String groupKey = student.getGroupId();

            groups.putIfAbsent(groupKey, new StudentGroup(groupKey,student.getCourseID(),student.getYearOfStudy()));

            groups.get(groupKey).addStudent(student);
        }

        return groups;
    }
}
