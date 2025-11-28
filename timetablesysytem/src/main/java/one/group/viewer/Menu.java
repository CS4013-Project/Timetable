package one.group.viewer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import one.group.models.people.Admin;
import one.group.models.people.Lecturer;
import one.group.models.people.Person;
import one.group.models.people.Student;
import one.group.models.programmes.Module;
import one.group.models.programmes.ProgramStructure;
import one.group.models.repositories.TablesRepo;
import one.group.models.rooms.Classroom;
import one.group.models.rooms.Labroom;
import one.group.models.rooms.Room;
import one.group.models.services.GroupService;
import one.group.models.term.Term;

/** The class for the viewer segment of the programme. */
public class Menu {
    /** Person the user for this interaction */
    private Person user;
    /** Admin the admin for this interaction */
    private Admin admin;
    /** Room the room for this interaction */
    private Room room;
    /** Module the module for this interaction */
    private Module module;
    /** ProgramStructure the course for this interaction */
    private ProgramStructure course;
    /** Booean the admin status for this interaction */
    private boolean adminStatus = false;
    /** Boolean the continue condition for this interaction */
    private boolean go = true;
    /** Scanner the scanner for this interaction */
    private Scanner scanner = new Scanner(System.in);

    /** Method containing the menus logic, if logout is selected the menu restarts, if quit is selected, the method returns false to signal to the controller to end the menu instance.
     * @return boolean whether or not to continue
     */
    public boolean runMenu(){
        
        user = null;
        admin = null;
        room = null;
        module = null;
        course = null;
        adminStatus = false;

        //The first block, this is where the user logs in.
        while(go == true){

            System.out.printf("\nPlease enter user type: \nS)tudent\nT)eacher\nA)dmin\nQ)uit\n");

            String input = scanner.nextLine();
            input = input.toUpperCase();
            if(input.toUpperCase().equals("S")){

                System.out.printf("\nPlease enter your ID: \n");

                input = scanner.nextLine();
                input = input.toUpperCase();
                for(String row[]:TablesRepo.getStudentsTable()){
                    if(row[0].equals(input.toUpperCase())){
                        user = GroupService.createStudentFromCSV(row);
                        System.out.printf("\nStudent log in successful!\n");
                        go = false;
                    }
                }
            }else if(input.toUpperCase().equals("T")){

                System.out.printf("\nPlease enter your ID:\n");

                input = scanner.nextLine();
                input = input.toUpperCase();
                for(String row[]:TablesRepo.getLecturersTable()){
                    if(row[0].equals(input.toUpperCase())){
                        user = new Lecturer(row[1], input , row[2]);
                        System.out.printf("\nLecturer log in successful!\n");
                        go = false;
                    }
                }
            }else if(input.toUpperCase().equals("A")){

                System.out.printf("\nPlease enter your ID: \n");

                input = scanner.nextLine();
                input = input.toUpperCase();
                for(String row[]:TablesRepo.getAdminTable()){
                    if(row[0].equals(input)){

                        System.out.printf("\nPlease enter your password: \n");

                        input = scanner.nextLine();
                        if(input.equals(row[2])){
                        admin = new Admin(input, row[1], row[2]);
                        adminStatus = true;
                        System.out.printf("\nAdmin log in successful! \n");
                        go = false;
                        }
                    }
                }            
            }else if(input.toUpperCase().equals("Q")){
                return false;
            }
        }

        //The second block, this is where the user chooses what timetable they want to see.
        go = true;
        while(go == true){

            //User branch.
            if(user instanceof Student || user instanceof Lecturer){

            System.out.printf
            ("\nPlease select option: \nU)ser timetable\nR)oom timetable\nM)odule timetable\nC)ourse timetable\nG)roup information\nL)ogout\nQ)uit\n");

                String input = scanner.nextLine();
                input = input.toUpperCase();
                if(input.equals("U")) {
                    System.out.println();
                    user.printTable(user.getTable());
                    System.out.println();
                }else if(input.equals("G")) {
                Student student = (Student) user;
                displayStudentGroupInfo(student);
                }else if(input.toUpperCase().equals("R")){

                    System.out.printf("\nPlease enter the room number: \n");

                    input = scanner.nextLine();
                    input = input.toUpperCase();
                    for(String[] row: TablesRepo.getRoomsTable()){
                        if(row[0].equals(input)){
                            if(row[1].equals("TEACHING")){
                                room = new Classroom(input, Integer.parseInt(row[2]), row[3]);
                            }else{
                                room = new Labroom(input, Integer.parseInt(row[2]), row[3]);
                            } 
                        }
                    }
                    System.out.println();
                    room.printTable(room.getTable());
                    System.out.println();
                }else if (input.equals("M")){

                    System.out.printf("\nPlease enter the module ID: \n");

                    input = scanner.nextLine();
                    input = input.toUpperCase();
                    for(String[] row: TablesRepo.getModulesTable()){
                        if(row[0].equals(input)){
                            module = new Module(row[0], row[1], row[2], row[3], row[4], row[5]);
                        }
                    }
                    System.out.println();
                    module.printTable(module.getTable());
                    System.out.println();
                }else if (input.equals("C")){
                    
                    System.out.printf("\nPlease enter course ID: \n");

                    input = scanner.nextLine();
                    input = input.toUpperCase();
                    for(String[] row: TablesRepo.getCoursesTable()){
                        if(row[0].equals(input)){
                            course = new ProgramStructure(row[0], Integer.parseInt(row[1]), Integer.parseInt(row[2]), row[3]);
                        }
                    }
                    System.out.println();
                    course.printTable(course.getTable());
                    System.out.println();
                }else if(input.equals("L")){
                    break;
                }else if(input.equals("Q")){
                    return false;
                }

            //Admin branch.
            }else if(admin instanceof Admin){
                System.out.printf
                ("\nPlease select option: \nS)et term\nA)dd timetable entry\nR)emove timetable entry\nL)og out\nQ)uit\n");

                String input = scanner.nextLine();
                input = input.toUpperCase();
                if(input.toUpperCase().equals("S")) {

                    System.out.printf("\nPlease enter the current term: \n");

                    input = scanner.nextLine();
                    input = input.toUpperCase();
                    if (input.equals("1") || input.equals("2")) {
                        admin.setTerm(Integer.parseInt(input));
                        System.out.printf("\nTerm successfully set to %s\n", input);
                    } else {
                        System.out.printf("\nError: Invalid input\n");
                    }
                }else if(input.toUpperCase().equals("A")) {
                    //ADD TIMETABLE ENTRY
                    System.out.println("\n=== Add Timetable Entry===");

                    System.out.println("Enter day (e.g. MONDAY): ");
                    String day = scanner.nextLine().toUpperCase();

                    System.out.println("Enter time range (HH:MM-HH:MM): ");
                    String timeRange = scanner.nextLine();

                    System.out.println("Enter module code: ");
                    String module = scanner.nextLine().toUpperCase();

                    System.out.println("Enter class type (LECTURE/LAB/TUTORIAL)");
                    String classType = scanner.nextLine().toUpperCase();

                    System.out.println("Enter room number: ");
                    String room = scanner.nextLine().toUpperCase();

                    System.out.println("Enter lecturer ID: ");
                    String lecturer = scanner.nextLine().toUpperCase();


                    System.out.println("Enter course ID: ");
                    String course = scanner.nextLine().toUpperCase();

                    System.out.println("Enter year of study: ");
                    int year = Integer.parseInt(scanner.nextLine());

                    int term = Term.getTerm();

                    admin.addTimetableEntry(module, timeRange, classType, room, lecturer, day, course, year, term);
                    System.out.println("Timetable entry added successfully");
                }else if(input.toUpperCase().equals("R")){
                    //REMOVE TIMETABLE ENTRY
                    System.out.println("\n=== Remove Timetable Entry ===");

                    System.out.println("Enter module code: ");
                    String module = scanner.nextLine().toUpperCase();

                    System.out.println("Enter day (e.g, MON): ");
                    String day = scanner.nextLine().toUpperCase();

                    System.out.println("Enter time range (HH:MM-HH:MM): ");
                    String timeRange = scanner.nextLine();

                    admin.removeTimetableEntry(module,day,timeRange);
                    System.out.println("Timetable entry removed successfully!");

                }else if (input.toUpperCase().equals("L")){
                    break;
                }else if(input.toUpperCase().equals("Q")){
                    return false;
                }
            }
        }
        return true;
    }

    private void displayStudentGroupInfo(Student student){
        System.out.println("\n=== YOUR GROUP INFORMATION ===");
        System.out.println("Student: "+ student.getName()+" ("+student.getID()+")");
        System.out.println(student.getGroupInfo());

        System.out.println("\n---Students in your Subgroup ---");
        List<String> subGroupMembers = student.getSubgroupMembers();
        if(subGroupMembers.isEmpty()){
            System.out.println("No other students in your subgroup.");
        } else {
            for(String member : subGroupMembers){
                System.out.println("• "+member);
            }
            System.out.println("Total in subgroup: " + (subGroupMembers.size() + 1)+ " students");
        }

        System.out.println("\n--- Your Group's Schedule ---");
        ArrayList<String[]> groupTimetable = student.getGroupTimetable();
        if(groupTimetable.isEmpty()){
            System.out.println("No classes scheduled for your group this term");
        } else{
            for(String[] entry : groupTimetable){
            System.out.println("• " + entry[0] + " " + entry[1] + " | " + entry[2] + " | " + entry[3] + " | " + entry[4]);
        }
    }
        System.out.println("========================\n");
}}