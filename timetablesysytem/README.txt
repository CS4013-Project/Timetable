//TIMETABLING APPLICATILON

The timetable application currently functions essentially fully for the viewing of timetables for all relevant entities. It does not yet have any functionality for adding or removing entries.
It adopts the Model Controller View structure.
The program has a login system that detirmines the menu the user will be presented with after this stage.
Users and Lecturers have the same options but with different methods being used for getting the User timetable.
All entities that can have a timetable exist as a class and can be instantiated, they have fields corresponding to the entries in the CSV files, this allows for easy comparisons.
The entries for the 'terms' csv file are in chronological order for using the days, the decision is that it will be easier to manage the adding of entries so that they are placed with an entry with the same day precedding it
than it is to sort String[]'s in an array list every time the timetable is called to be printed.
Interfaces Table and getID allow for the common methods required to generate a timetable from a csv file of data to be present in and overrided for unrelated classes.
Enums DayOfWeek and CVSTable allow global access to information about their respective concerns using static fields and methods to prevent mismatched objects existing in the program.
The Term class allows for the term to exist as a static variable which can be changed by the admin.
The TablesRepo class allows for all the CSV files to be initialised and converted to ArrayList<String[]>'s on program start, it includes methods to return a copy of one of these arrays for operations, as not to create objects with mismatched data.

The program currently allows a user to log in as a student, lecturer or admin. The user can log out to go to the starting menu and log in as a new user, they can also quit to terminate the app.
Timetables can be viewed for rooms, modules, students, lecturers and courses. 
Admin can set the term for the system and requires a password to log in that is case sensitive.
All login details are converted to capital letters so match the CSV files, except the admin password.