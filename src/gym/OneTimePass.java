package gym;

import java.time.LocalTime;

public class OneTimePass extends Pass {

    private static int startTime = 8;
    private static int endTime = 22;

    OneTimePass(Person owner) {
        super(owner, 1);
    }

    @Override
    boolean allowsZone(Zone zone) {
        int currentTime = getCurrentTime();
        return (zone == Zone.GYM || zone == Zone.POOL) && (currentTime >= startTime && currentTime < endTime);
    }
}
