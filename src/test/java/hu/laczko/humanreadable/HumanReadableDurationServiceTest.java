package hu.laczko.humanreadable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HumanReadableDurationServiceTest {

    @Test
    public void testFormatDurationToHumanReadableForm_WithNegativeNumbers(){
        HumanReadableDurationService humanReadableDurationService = new HumanReadableDurationService();
        int negativeDuration = -1;
        String expectedResult = "Duration cannot be negative";

        String actualResult = humanReadableDurationService.formatDurationToHumanReadableForm(negativeDuration);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFormatDurationToHumanReadableForm_WithZero(){
        HumanReadableDurationService humanReadableDurationService = new HumanReadableDurationService();
        int zeroDuration = 0;
        String expectedResult = "now";

        String actualResult = humanReadableDurationService.formatDurationToHumanReadableForm(zeroDuration);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1 second", "40:40 seconds"}, delimiter = ':')
    public void testFormatDurationToHumanReadableForm_WithUnder60Duration(String input, String expectedResult){
        HumanReadableDurationService humanReadableDurationService = new HumanReadableDurationService();

        String actualResult = humanReadableDurationService.formatDurationToHumanReadableForm(Integer.parseInt(input));

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"100:1 minute and 40 seconds", "3600:1 hour", "31536001:1 year and 1 second", "31543202: 1 year, 2 hours and 2 seconds"}, delimiter = ':')
    public void testFormatDurationToHumanReadableForm_WithOver60Duration(String input, String expectedResult){
        HumanReadableDurationService humanReadableDurationService = new HumanReadableDurationService();

        String actualResult = humanReadableDurationService.formatDurationToHumanReadableForm(Integer.parseInt(input));

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
