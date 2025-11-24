package one.group.models.user_timetable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter; 
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
}