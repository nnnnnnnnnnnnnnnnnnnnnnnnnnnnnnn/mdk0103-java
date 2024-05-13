package gym;

import java.time.LocalTime;

public class DayPass extends Pass {

    private static int startTime = 8;
    private static int endTime = 16;

    public DayPass(Person owner) {
        super(owner, 90);
    }

    public DayPass(Person owner, int durationDays) {
        super(owner, durationDays);
    }

    @Override
    boolean allowsZone(Zone zone) {
        int currentTime = getCurrentTime();
        return (zone == Zone.GYM || zone == Zone.GROUP_CLASS) && (currentTime >= startTime && currentTime < endTime);
    }
}
