package hu.laczko.humanreadable;

public enum UnitOfTime {
    YEAR("year", 31536000),
    WEEK("week", 604800),
    DAY("day", 86400),
    HOUR("hour", 3600),
    MINUTE("minute", 60),
    SECOND("second", 1);

    public final String label;
    public final int numberOfSeconds;

    UnitOfTime(String label, int numberOfSeconds) {
        this.label = label;
        this.numberOfSeconds = numberOfSeconds;
    }
}
