package one.group.models.term;

/** Class representing a term, a term is the basis for a timetable. */
public class Term{
    private static int currentTerm = 1;

    /** 
     * Static method to return the current term.
     * @return i the current term (1:Autum, 2:Spring)
     */
    public static int getTerm(){
        int i = currentTerm;
        return i;
    }

    /**
     * Method to set the term for the system.
     * @param n the term to set to, only accepts 1 or 2
     */
    public static void setTerm(int n){
        if(n == 1 || n ==2){
            currentTerm = n;
        }
    }
}
