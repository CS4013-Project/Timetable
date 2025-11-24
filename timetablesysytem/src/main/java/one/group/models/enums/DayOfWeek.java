package one.group.models.enums;

/**
 * Enum representing the days of the week across classes,
 */
public enum DayOfWeek {

    /** Monday, not a weekend */
    MONDAY(false),
    /** Tuesday, not a weekend */
    TUESDAY(false),
    /** Wednesday, not a weekend */
    WEDNESDAY(false),
    /** Thursday, not a weekend */
    THURSDAY(false),
    /** Friday, not a weekend */
    FRIDAY(false),
    /** Saturday, weekend */
    SATURDAY(true),
    /** Sunday, weekend */
    SUNDAY(true);

    /** A truth value for whether or not a day is a weekend. */
    private final boolean isWeekend;
    
    /**
     * Constructs the enum with its weekend flag.
     * @param isWeekend whether the day is a weekend
     */
    private DayOfWeek(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    /**
     * Retrieves whether the day is a weekend.
     * @return true if the day is a weekend
     */
    public boolean isWeekend() {
        return isWeekend;
    }
}
