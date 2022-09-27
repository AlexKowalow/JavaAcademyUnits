package org.units;

public class LengthUnits {
    public int metersToCentimeters(int meters) {
        return meters * 100;
    }

    public int metersToMillimeters(int meters) {
        return meters * 10000;
    }

    public double centimetersToMeters(int centimeters) {
        return centimeters / 100.0;
    }

    public double millimetersToMeters(int millimeters) {
        return millimeters / 10000.0;
    }
}
