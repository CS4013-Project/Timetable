package one.group.models.enums;
/**
 * Enum with the filepaths for each CSV file.
 * This allows global access to filepaths.
 */
public enum CSVTable {
    /** Path to the courses CSV file. */
    COURSES_TABLE("/data/courses.csv"),
    /** Path to the faculties CSV file. */
    FACULTIES_TABLE("/data/faculties.csv"),
    /** Path to the lecturers CSV file. */
    LECTURERS_TABLE("/data/lecturers.csv"),
    /** Path to the modules CSV file. */
    MODULES_TABLE("/data/modules.csv"),
    /** Path to the rooms CSV file. */
    ROOMS_TABLE("/data/rooms.csv") ,
    /** Path to the students CSV file. */
    STUDENTS_TABLE("/data/students.csv"),
    /** Path to the terms CSV file. */
    TERMS_TABLE("/data/terms.csv"),
    /** Path to the admins CSV file. */
    ADMINS_TABLE("/data/admins.csv");

    /** The filepath associated with an entry. */
    public String filePath;

    /** Private constructor method. */
    private CSVTable(String filePath){
        this.filePath = filePath;
    }
}
