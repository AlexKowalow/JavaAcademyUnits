package org.units;

public class UnitsFactory {
    private final TimeUnits timeUnits = new TimeUnits();
    private final LengthUnits lengthUnits = new LengthUnits();

    public TimeUnits getTimeUnits() {
        return timeUnits;
    }

    public LengthUnits getLengthUnits() {
        return lengthUnits;
    }
}
