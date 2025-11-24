package one.group.models.rooms;
import java.util.ArrayList;

import one.group.models.interfaces.GetID;
import one.group.models.interfaces.Table;
import one.group.models.repositories.TablesRepo;
import one.group.models.term.Term;
/** Abstract class to represent a room. */
public abstract class Room implements GetID, Table{
    /** String for the rooms id. */
    @SuppressWarnings("FieldMayBeFinal")
    private String roomID;
    /** String for the rooms capacity. */
    private int capacity;
    /** String for the rooms building. */
    private String building;
    /** String for the rooms timetable. */
    private ArrayList<String[]> table;

    /**
     * Constructor to instantiate a room.
     * @param id the rooms id.
     * @param capacity tha capacity of the room
     * @param buidling the builiding where the room is
     */
    public Room(String id, int capacity, String buidling){
        this.roomID = id;
        this.capacity = capacity;
        this.building = buidling;

    }

    /** 
     * Method to return the room capacity.
     * @return capacity the rooms capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Method to return the id of the room.
     * @return roomID the rooms ID
     */
    @Override
    public String getID(){
        return roomID;
    }

    /**
     * Method to return the building of the room.
     * @return building the rooms building
     */
    public String getBuilding(){
        return building;
    }

    /**
     * Method to return the table of the room.
     * @return table the table for the room
     */
    public ArrayList<String[]> accessTable(){
        return table;
    }

    /**
     * Method to set the table of the room to the given one.
     */
    @Override
    public void setTable(ArrayList<String[]> newArrayList){
        table = newArrayList;
    }

    /** Method queryTable implemented for a room, called by getTable() if current rooms table is null. Sets rooms table to result. */
    @Override
    public void queryTable(){
        ArrayList<String[]> thisRoomsTimetable = new ArrayList<>();
        ArrayList<String[]> termsTimetable = TablesRepo.getTermsTable();
        for(String[] row: termsTimetable){
            if(row[4].equals(roomID)&&Integer.parseInt(row[8]) == Term.getTerm()){
                thisRoomsTimetable.add(row);
            }
        }
        setTable(thisRoomsTimetable);
    }

    /** Method to get the rooms table. Checks if current table is null, if it is, the method calls queryTable() to make one. 
    *@return the rooms timetable. 
    */
    @Override
    public ArrayList<String[]> getTable(){
        if(accessTable() == null){
            queryTable();
        }
        return accessTable();
    }

    /**
     *  Method to print the rooms table.
     * @param tableToPrint
     */
    @Override
    public void printTable(ArrayList<String[]> tableToPrint){
    for(String[] row: tableToPrint){
        for(int i = 0;i < 5;i++){
            System.out.printf(" %s | ", row[i]);
            }
        System.out.printf("\n------\n");
        }
    }

    /**
    *Checks if the room is free for a given time slot.
    *@param day the day ( e.g., "Monday" )
    *@param start the start time ( e.g. , "09:00" )
    *@param end the end time (e.g. , "10:00" )
    *@return true if room is free, false if room is already booked
    */
    public boolean isAvailable(String day, String start, String end) {
        ArrayList<String[]> timetable = getTable();

        for (String[] row : timetable) {
            String rowDay = row[0];
            String rowStart = row[1];
            String rowEnd = row[2];

            if (rowDay.equalsIgnoreCase(day)) {
                //Overlap exists if: start < existing_end AND end > existing_start
                boolean overlaps = *start.compareTo(rowEnd) < 0 &&
                    end.compareTo(rowStart) > 0;

                if (overlaps) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
    *Attempts to book the room by adding a new timetable row.
    *Prevents double booking.
    *@param newRow the timetable entry to add:
    *       [0] = Day, [1] = Start, [2] = End, [3] = Module, [4] = RoomID, ...
    *@return true if booking suceeds, false otherwise
    */
    public boolean book(String[] newRow) {
        String day = newRow[0];
        String start = newRow[1];
        String end = newRow[2];

        if (!isAvailable(day, start, end)) {
            System.out.println("ERROR: Room " + roomID + " is NOT available for the requested time.");
            return false;
        }

        ArrayList<String[]> timetable = getTable();
        timetable.add(newRow);
        setTable(timetable);

        return true;
}
