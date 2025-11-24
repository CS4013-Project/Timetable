package one.group.models.events;

public class Lecture extends Event {

    public Lecture(String module, String startTime, String endTime, String lecturer, String room, String day){
        super(module, startTime, endTime, lecturer, room, day);
    }
}
