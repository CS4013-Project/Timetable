package one.group.models.people;
import java.util.ArrayList;
import java.util.List;

public class StudentGroup {
    private String groupId;
    private String courseId;
    private int year;
    private List<Student> students;

    public StudentGroup(String groupId,String courseId, int year){
        this.groupId = groupId;
        this.courseId = courseId;
        this.year = year;
        this.students = new ArrayList<>();
    }

    public String getGroupId() {
        return groupId;
    }

    public String getCourseId(){
        return courseId;
    }

    public int getYear() {
        return year;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void addStudent(Student student){
        this.students.add(student);
    }
}
