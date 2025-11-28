package one.group.models.people;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles student groups
 */
public class StudentGroup {
    private String groupId;
    private String courseId;
    private int year;
    private List<Student> students;

    /**
     * Constructor for StudentGroup class
     * @param groupId
     * @param courseId
     * @param year
     */
    public StudentGroup(String groupId,String courseId, int year){
        this.groupId = groupId;
        this.courseId = courseId;
        this.year = year;
        this.students = new ArrayList<>();
    }

    /**
     * Gets group id
     * @return
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * Gets course id
     * @return
     */
    public String getCourseId(){
        return courseId;
    }

    /**
     * Gets year
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets students in a group
     * @return
     */
    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    /**
     * Adds a student to a group
     * @param student
     */
    public void addStudent(Student student){
        this.students.add(student);
    }
}
