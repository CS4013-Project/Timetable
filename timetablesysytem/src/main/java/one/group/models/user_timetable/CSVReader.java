package one.group.models.user_timetable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Utility class for reading CSV files. All methods are static.
 */
public class CSVReader {     

    /** 
     * Default constructor. No parameters needed since all methods are static.
     */
    private CSVReader(){
    }
    
    /**
     * Reads a CSV file line by line and returns its contents as a list of strings.
     * Each line becomes a single string in the list.
     *
     * @param filePath the path to the CSV file
     * @return allData a list of strings representing each line in the CSV
     * @throws FileNotFoundException if the specified file does not exist
     */
    public static ArrayList<String[]> readToArrayList(String resourcePath) throws Exception {
        ArrayList<String[]> allData = new ArrayList<>();
        try (InputStream data = CSVReader.class.getResourceAsStream(resourcePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(data))){

            if (data == null){
                throw new Exception("Resource not found: " + resourcePath);
            }
            String line;
            while ((line = reader.readLine()) != null){
                String[] thisRow = line.split(",");
                allData.add(thisRow);
            }
        }
        return allData;
    }
}
