package one.group.models.user_timetable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

/** Utility class for writing to CSV files. All methods are static. */
public class CSVWriter{
    
    /** Constructor with no parameters. */
    public CSVWriter(){}

    /**
     * Method to write the input String to the target csv file.
     * @param input the String to input
     * @param fileToUpdate the target file to write to
     * @throws FileNotFoundException throws this if no file found at the filepath given
     */
    public static void writeToFile(String input, File fileToUpdate) throws FileNotFoundException {
        try(PrintWriter writeTo = new PrintWriter(fileToUpdate)){
             writeTo.print(input);
        }
    }

    public static void writeArrayListToCSV(String resourcePath, ArrayList<String[]> data){
        try {
            String absolutePath = new File("").getAbsolutePath()+"/timetablesysytem/src/main/resources/data/terms.csv";
            File file = new File(absolutePath);

            System.out.println("Writing to: "+absolutePath);


            file.getParentFile().mkdirs();

            try (PrintWriter writer = new PrintWriter(file)){
                for (String[] row:data){
                    String line = String.join(",",row);
                    writer.println(line);
                }
            }


        } catch(FileNotFoundException e){
            System.err.println("Error: Could not write to "+ resourcePath);
            e.printStackTrace();
        }
    }
}