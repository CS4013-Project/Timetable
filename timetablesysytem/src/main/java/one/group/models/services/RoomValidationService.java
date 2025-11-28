package one.group.models.services;
import one.group.models.repositories.TablesRepo;

/**
 * Class to validate room is booked for right type of event
 */
public class RoomValidationService {
    /**
     * Checks if the room being used matches the event type
     * @param roomId
     * @param eventType
     * @return
     */
    public static boolean isValidRoomForEvent(String roomId, String eventType){
        String roomType = getRoomType(roomId);

        if(roomType == null){
            System.out.println("Error: Room " + roomId + " not found");
            return false;
        }

        if("LAB".equals(eventType)){
            if(!"LAB".equals(roomType)){
                System.out.println("Error: Lab Events must be in scheduled in Lab rooms");
                return false;
            }
            return true;
        }

        if("LECTURE".equals(eventType) || "TUTORIAL".equals(eventType)){
            if(!"TEACHING".equals(roomType)){
                System.out.println("Error:" +eventType + " events must be scheduled in Teaching rooms");
                return false;
            }
            return true;
        }

        return true;
    }

    /**
     * Gets the room type
     * @param roomId
     * @return
     */
    private static String getRoomType(String roomId){
        for(String[] room: TablesRepo.getRoomsTable()){
            if(room[0].equals(roomId)){
                return room[1];
            }
        }
        return null;
    }
}
