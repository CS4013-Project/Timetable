package one.group.models.repositories;

import java.util.ArrayList;

import one.group.models.enums.CSVTable;
import one.group.models.user_timetable.CSVReader;
/** Class to act as a repositoty for the information regarding the csv files used by the program. Uses static fields and methods. 
 * Includes methods to store each csv file as an ArrayList on boot, get methods only return copies.
 */
public class TablesRepo {
    /** ArrayList for the table of admins. */
    private static ArrayList<String[]> adminTable;
    /** ArrayList for the table of courses. */
    private static ArrayList<String[]> coursesTable;
    /** ArrayList for the table of faculties. */
    private static ArrayList<String[]> facultiesTable;
    /** ArrayList for the table of lecturers. */
    private static ArrayList<String[]> lecturersTable;
    /** ArrayList for the table of modules. */
    private static ArrayList<String[]> modulesTable;
    /** ArrayList for the table of rooms. */
    private static ArrayList<String[]> roomsTable;
    /** ArrayList for the table of students. */
    private static ArrayList<String[]> studentsTable;
    /** ArrayList for the table of terms. */
    private static ArrayList<String[]> termsTable;

    /** Static block to initialise all tables on boot from the CSV files specified by the given paths.  */
    static {
        try {
            adminTable = CSVReader.readToArrayList(CSVTable.ADMINS_TABLE.filePath);
            coursesTable = CSVReader.readToArrayList(CSVTable.COURSES_TABLE.filePath);
            facultiesTable = CSVReader.readToArrayList(CSVTable.FACULTIES_TABLE.filePath);
            lecturersTable = CSVReader.readToArrayList(CSVTable.LECTURERS_TABLE.filePath);
            modulesTable = CSVReader.readToArrayList(CSVTable.MODULES_TABLE.filePath);
            roomsTable = CSVReader.readToArrayList(CSVTable.ROOMS_TABLE.filePath);
            studentsTable = CSVReader.readToArrayList(CSVTable.STUDENTS_TABLE.filePath);
            termsTable = CSVReader.readToArrayList(CSVTable.TERMS_TABLE.filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to return the admins table
     * @return adminTable the table of admins
     */
    public static ArrayList<String[]> getAdminTable(){
        return new ArrayList<>(adminTable);
    }

    /**
     * Method to return the admins table
     * @return adminTable the table of admins
     */
    public static ArrayList<String[]> getCoursesTable(){
        return new ArrayList<>(coursesTable);
    }

    /**
     * Method to return the admins table
     * @return adminTable the table of admins
     */
    public static ArrayList<String[]> getFacultiesTable(){
        return new ArrayList<>(facultiesTable);
    }

    /**
     * Method to return the admins table
     * @return adminTable the table of admins
     */
    public static ArrayList<String[]> getLecturersTable(){
        return new ArrayList<>(lecturersTable);
    }

    /**
     * Method to return the admins table
     * @return adminTable the table of admins
     */
    public static ArrayList<String[]> getModulesTable(){
        return new ArrayList<>(modulesTable);
    }

    /**
     * Method to return the admins table
     * @return adminTable the table of admins
     */
    public static ArrayList<String[]> getRoomsTable(){
        return new ArrayList<>(roomsTable);
    }

    /**
     * Method to return the admins table
     * @return adminTable the table of admins
     */
    public static ArrayList<String[]> getStudentsTable(){
        return new ArrayList<>(studentsTable);
    }

    /**
     * Method to return the terms table
     * @return termsTable the table of admins
     */
    public static ArrayList<String[]> getTermsTable(){
        return new ArrayList<>(termsTable);
    }
}
