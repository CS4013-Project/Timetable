package one.group.models.events;

/**
 * Represents Lab Event
 */
public class Lab extends Event {
    /**
     * Constructor for lab class
     * @param module
     * @param startTime
     * @param endTime
     * @param lecturer
     * @param room
     * @param day
     */
    public Lab(String module, String startTime, String endTime, String lecturer, String room, String day){
        super(module, startTime, endTime, lecturer, room, day);
    }
}
