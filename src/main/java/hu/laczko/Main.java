package hu.laczko;

import hu.laczko.humanreadable.HumanReadableDurationService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HumanReadableDurationService humanReadableDurationService = new HumanReadableDurationService();
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Give number of seconds to format (max number is 2,147,483,647):");
            while (in.hasNext()) {
                int durationFromInput = Integer.parseInt(in.next());
                System.out.println(humanReadableDurationService.formatDurationToHumanReadableForm(durationFromInput));
            }
        } catch (NumberFormatException e) {
            System.out.println("The input was not number of seconds");
        }
    }
}