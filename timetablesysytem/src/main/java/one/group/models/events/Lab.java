package one.group.models.events;

public class Lab extends Event {
    /**
     * Constructor for lab class
     * @throws IllegalArgumentException if lab isnt scheduled in a lab room
     * @throws IllegalArgumentException if the group size exceeds the lab room capacity
     * @param module
     * @param lecturer
     * @param room
     * @param group
     * @param day
     * @param startTime
     * @param endTime
     */
    public Lab(String module, String startTime, String endTime, String lecturer, String room, String day){
        super(module, startTime, endTime, lecturer, room, day);
    }
}
