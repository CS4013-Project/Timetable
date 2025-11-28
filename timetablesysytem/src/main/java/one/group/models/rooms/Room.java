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

    public abstract String getRoomType();

    public boolean isLabRoom(){
        return "LAB".equals(getRoomType());
    }

    public boolean isClassroom(){
        return "TEACHING".equals(getRoomType());
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
        if (!table.isEmpty()) return;            // prevents overwriting added bookings

        ArrayList<String[]> loaded = new ArrayList<>();
        ArrayList<String[]> all = TablesRepo.getTermsTable();

        for (String[] row : all) {
            if (row[4].equals(roomID) && Integer.parseInt(row[8]) == Term.getTerm()) {
                loaded.add(row);
            }
        }
        table = loaded;
    }

    /** Method to get the rooms table. Checks if current table is null, if it is, the method calls queryTable() to make one. 
    *@return the rooms timetable. 
    */
    @Override
    public ArrayList<String[]> getTable(){
        if(table.isEmpty()){
            queryTable();
        }
        return table;
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
        System.out.printf("\n------");
        }
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

/**
*Returns true if the room is free.
    */
public boolean isAvailable(String day, String start, String end) {
    int newStart = toMinutes(start);
    int newEnd = toMinutes(end);

    for(String[] row : getTable()) {

    String rowDay = row[0];
        int rowStart = toMinutes(row[1]);
        int rowEnd = toMinutes(row[2]);

    if (rowDay.equalsIgnoreCase(day)) {
        //Overlap: start < existing_end && end > existing_start
        boolean overlaps = newStart < rowEnd && newEnd > rowStart;
        if (overlaps) return false;
    }
    }
    return true;
}


/*Attempts to book the room.
    */
public boolean book(String[] newRow){
    String day = newRow[0];
    String start = newRow[1];
    String end = newRow[2];

    if (!isAvailable(day, start, end)) {
        System.out.println("ERROR: Room " + roomID + "is NOT available for the requested time.");
        return false;
    }

    //Add to memory table
    getTable().add(newRow);

    //Persist to repository if needed
    TablesRepo.addTimetableEntry(newRow);

    return true;
}}
