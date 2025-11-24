//TIMETABLE

Up until when our group member left, what we had completed is as follows:

-Implemeted a Model-Controller-View Architecture
-Created classes for all timetable-related entities (students, lecturers, rooms, modules, courses), each mapped to CSV fields
-Implemented Table and getID interfaces to standardise timetable generation across unrelated classes
-Added DayOfWeek and CVSTable Enums for globally accessible, type-safe shared information
-Implemented a Term class with a static term variable that can be updated by the admin
-Created the TablesRepo class to:
  > Load all CSV data at program start
  > Store each file as an ArrayList<String[]>
  > Return copies of these lists to avoid mismatched data between objects
- In terms of timetable functionality, we have a fully working timetable viewing for:
  > Rooms
  > Modules
  > Students
  > Lecturers
  > Courses
- Login System - Functional login for:
  > Student
  > Lecturer
  > Admin
- Login usernames are normalised to uppercase to match CSV data
- Users can:
  > Logout to return to the start menu
  > Quit to terminate the application

Current Status of Project:

- Application is fully functional for viewing timetables for all supported entities

To be Implemented:
- Admin Ability to add/remove timetable entries
- A room availablity check feature, which prevents double booking

