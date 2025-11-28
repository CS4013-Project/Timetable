package one.group.models.events;

/**
 * Represents tutorial event
 */
public class Tutorial extends Event {
    /**
     * Constructor for tutorial class
     * @param module
     * @param startTime
     * @param endTime
     * @param lecturer
     * @param room
     * @param day
     */
    public Tutorial(String module, String startTime, String endTime, String lecturer, String room, String day){
        super(module, startTime, endTime, lecturer, room, day);
    }
}
