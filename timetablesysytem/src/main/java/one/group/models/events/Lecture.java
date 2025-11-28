package one.group.models.events;

/**
 * Represents Lecture event
 */
public class Lecture extends Event {
    /**
     * Constructor for lecture class
     * @param module
     * @param startTime
     * @param endTime
     * @param lecturer
     * @param room
     * @param day
     */
    public Lecture(String module, String startTime, String endTime, String lecturer, String room, String day){
        super(module, startTime, endTime, lecturer, room, day);
    }
}
