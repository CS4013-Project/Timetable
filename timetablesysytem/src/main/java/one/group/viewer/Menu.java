package one.group.viewer;

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
                        user = new Student(row[1], input, row[2], Integer.parseInt(row[3]));
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
            ("\nPlease select option: \nU)ser timetable\nR)oom timetable\nM)odule timetable\nC)ourse timetable\nL)ogout\nQ)uit\n");

                String input = scanner.nextLine();
                input = input.toUpperCase();
                if(input.equals("U")){
                    System.out.println();
                    user.printTable(user.getTable());
                    System.out.println();
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
                ("\nPlease select option: \nS)et term\nL)og out\nQ)uit\n");

                String input = scanner.nextLine();
                input = input.toUpperCase();
                if(input.toUpperCase().equals("S")){

                    System.out.printf("\nPlease enter the current term: \n");

                    input = scanner.nextLine();
                    input = input.toUpperCase();
                    if(input.equals("1") || input.equals("2")){
                        admin.setTerm(Integer.parseInt(input));
                        System.out.printf("\nTerm successfully set to %s\n", input);
                    }else{
                        System.out.printf("\nError: Invalid input\n");
                    }
                }else if (input.toUpperCase().equals("L")){
                    break;
                }else if(input.toUpperCase().equals("Q")){
                    return false;
                }
            }
        }
        return true;
    }
}