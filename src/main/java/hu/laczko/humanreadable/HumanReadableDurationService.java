package hu.laczko.humanreadable;

public class HumanReadableDurationService {
    private final String SEPARATOR = ", ";
    private final String LAST_SEPARATOR = " and ";

    public String formatDurationToHumanReadableForm(int duration) {
        if (duration < 0) {
            return "Duration cannot be negative";
        } else if (duration == 0) {
            return "now";
        }

        return calculateDurationComponentValues(duration);
    }

    String calculateDurationComponentValues(int duration) {
        StringBuilder stringBuilder = new StringBuilder();
        int remainingDuration = duration;

        //Returns an array containing the constants of this enum type, in the ORDER they're DECLARED.
        for (UnitOfTime unitOfTime : UnitOfTime.values()) {
            if (remainingDuration / unitOfTime.numberOfSeconds > 1) {
                stringBuilder.append(remainingDuration / unitOfTime.numberOfSeconds)
                        .append(" ")
                        .append(unitOfTime.label)
                        .append("s")
                        .append(SEPARATOR);
            } else if (remainingDuration / unitOfTime.numberOfSeconds > 0) {
                stringBuilder.append(remainingDuration / unitOfTime.numberOfSeconds)
                        .append(" ")
                        .append(unitOfTime.label)
                        .append(SEPARATOR);
            }
            remainingDuration = remainingDuration % unitOfTime.numberOfSeconds;
        }

        int lastIndexOfTheSeparator = stringBuilder.lastIndexOf(SEPARATOR);
        stringBuilder.delete(lastIndexOfTheSeparator, lastIndexOfTheSeparator + SEPARATOR.length());
        lastIndexOfTheSeparator = stringBuilder.lastIndexOf(SEPARATOR);
        if (lastIndexOfTheSeparator >= 0) {
            stringBuilder.replace(lastIndexOfTheSeparator, lastIndexOfTheSeparator + SEPARATOR.length(), LAST_SEPARATOR);
        }

        return stringBuilder.toString();
    }

}
