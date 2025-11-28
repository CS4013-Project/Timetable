package one.group.models.services;

import one.group.models.repositories.TablesRepo;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class that checks if a group has conflict with another group in regard to class times
 */
public class GroupConflictService {
    /**
     * Checks for conflict with class times regarding groups
     * @param courseId
     * @param year
     * @param day
     * @param startTime
     * @param endTime
     * @param term
     * @return
     */
    public static boolean hasGroupConflict(String courseId, int year, String day, String startTime, String endTime, int term){
        ArrayList<String[]> timetable = TablesRepo.getTermsTable();
        String targetGroup = courseId + "-" + year;

        for(String[] entry : timetable){
            if(Integer.parseInt(entry[8]) != term) continue;
            if(!entry[0].equals(day)) continue;

            if(entry[6].equals(courseId)&&entry[7].equals(String.valueOf(year))){
                if(hasTimeOverlap(entry[1], startTime + "-" + endTime)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Logic to find out if groups have a time conflict
     * @param timeRange1 Start time
     * @param timeRange2 End time
     * @return
     */
    public static boolean hasTimeOverlap(String timeRange1, String timeRange2){
        String[] parts1 = timeRange1.split("-");
        String[] parts2 = timeRange2.split("-");

        return !(parts2[1].compareTo(parts1[0]) <=0 || parts2[0].compareTo(parts1[1])>=0);
    }
}
