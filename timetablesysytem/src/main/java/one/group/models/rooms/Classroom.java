package one.group.models.rooms;
/** Class to represent a classroom. */
public class Classroom extends Room {

    /**
     * Creates Classroom object using String id, int capacity and building.
     * @param id the number of the room
     * @param capacity the capacity of the room
     * @param building the building where the room is
     */
    public Classroom(String id, int capacity, String building){
        super(id, capacity, building);
    }
}
