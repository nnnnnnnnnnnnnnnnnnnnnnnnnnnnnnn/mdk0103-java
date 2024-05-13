package gym;

import java.time.LocalTime;

public class FullPass extends Pass {

    private static int startTime = 8;
    private static int endTime = 22;

    FullPass(Person owner) {
        super(owner, 90);
    }

    public FullPass(Person owner, int durationDays) {
        super(owner, durationDays);
    }

    @Override
    boolean allowsZone(Zone zone) {
        int currentTime = getCurrentTime();
        return currentTime >= startTime && currentTime < endTime;
    }
}
