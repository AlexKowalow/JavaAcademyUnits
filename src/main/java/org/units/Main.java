package org.units;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    /*

    Stwórz aplikację, która będzie służyła do przeliczania jednostek.

    Zdefiniuj klasę, która będzie posiadała metody do przeliczania jednostek metrycznych:

metrów na centymetry
metrów na milimetry
centymetrów na metry
milimetrów na metry

W kolejnej klasie zdefiniuj metody związane z przeliczaniem czasu:

godzin na minuty
minut na sekundy
sekund na milisekundy
Zakładamy, że w przypadku jednostek czasu operujemy jedynie na wartościach całkowitych, czyli np. nie będziemy przeliczali "pół godziny na minuty".

W osobnej klasie przetestuj działanie stworzonych metod.

Korzystając ze zdefiniowanych metod przelicz np. 14 godzin na milisekundy.
     */

    private static final Scanner sc = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger();
    private static final UnitsFactory unitsFactory = new UnitsFactory();

    private static void processTimeUnits(TimeUnits timeUnits) {
        System.out.println("=================");
        System.out.println("SELECT CONVERSION");
        System.out.println("hr to min       1");
        System.out.println("min to sec      2");
        System.out.println("sec to ms       3");
        System.out.println("=================");

        int convId = sc.nextInt();

        switch (convId) {
            case 1 -> {
                System.out.print("Enter hours: ");
                int hours = sc.nextInt();
                int minutes = timeUnits.hoursToMinutes(hours);
                logger.debug(hours + " hours = " + minutes + " minutes");
            }
            case 2 -> {
                System.out.print("Enter minutes: ");
                int minutes = sc.nextInt();
                int seconds = timeUnits.minutesToSeconds(minutes);
                logger.debug(minutes + " minutes = " + seconds + " seconds");
            }
            case 3 -> {
                System.out.print("Enter seconds: ");
                int seconds = sc.nextInt();
                int milliseconds = timeUnits.secondsToMilliseconds(seconds);
                logger.debug(seconds + " seconds = " + milliseconds + " milliseconds");
            }
            default -> logger.error("Unknown option");
        }
    }
    private static void processLengthUnits(LengthUnits lengthUnits) {

        System.out.println("=================");
        System.out.println("SELECT CONVERSION");
        System.out.println("m to cm         1");
        System.out.println("m to mm         2");
        System.out.println("cm to m         3");
        System.out.println("mm to m         4");
        System.out.println("=================");


        int convId = sc.nextInt();

        switch (convId) {
            case 1 -> {
                System.out.print("Enter meters: ");
                int meters = sc.nextInt();
                int centimeters = lengthUnits.metersToCentimeters(meters);
                logger.debug(meters + " meters = " + centimeters + " centimeters");
            }
            case 2 -> {
                System.out.print("Enter meters: ");
                int meters = sc.nextInt();
                int millimeters = lengthUnits.metersToMillimeters(meters);
                logger.debug(meters + " meters = " + millimeters + " millimeters");
            }
            case 3 -> {
                System.out.print("Enter centimeters: ");
                int centimeters = sc.nextInt();
                double meters = lengthUnits.centimetersToMeters(centimeters);
                logger.debug(centimeters + " centimeters = " + meters + " meters");
            }
            case 4 -> {
                System.out.print("Enter millimeters: ");
                int millimeters = sc.nextInt();
                double meters = lengthUnits.millimetersToMeters(millimeters);
                logger.debug(millimeters + " millimeters = " + meters + " meters");
            }
            default -> logger.error("Unknown option");
        }
    }


    public static void main(String[] args) {
        sc.useLocale(Locale.US);

        try {
            while (true) {
                System.out.println("============");
                System.out.println("SELECT UNITS");
                System.out.println("Length     1");
                System.out.println("Time       2");
                System.out.println("============");
                int units = sc.nextInt();

                switch (units) {
                    case 1 -> {
                        LengthUnits lengthUnits = unitsFactory.getLengthUnits();
                        processLengthUnits(lengthUnits);
                    }
                    case 2 -> {
                        TimeUnits timeUnits = unitsFactory.getTimeUnits();
                        processTimeUnits(timeUnits);
                    }
                    default -> logger.debug("Unknown option");
                }

                System.out.println("Enter q to quit");
                String q = sc.next();
                if (q.equals("q")) {
                    break;
                }
            }
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}