package one.group.models.events;

public abstract class Event {
    
    private String module;
    private String startTime;
    private String endTime;
    private String lecturer;
    private String room;
    private String day;

    public Event(String module, String startTime, String endTime, String lecturer, String room, String day){
        this.module = module;
        this.startTime = startTime;
        this.endTime = endTime;
        this.lecturer = lecturer;
        this.room = room;
        this.day = day;
    }

    /**
     * Returns the module for the event
     * @return module
     */
    public String getModule(){
        return module;
    }

    /**
     * Returns the lecturer for the event
     * @return lecturer
     */
    public String getLecturer(){
        return lecturer;
    }

    /**
     * Returns the room for the event
     * @return room
     */
    public String getRoom() {
        return room;
    }

    /**
     * Returns the day of the week the event is on
     * @return day
     */
    public String getDay(){
        return day;
    }

    /**
     * Returns start time of event
     * @return startTime
     */
    public String getStartTime(){
        return startTime;
    }

    /**
     * Returns the end time of the event
     * @return endTime
     */
    public String getEndTime() {
        return endTime;
    }
}
