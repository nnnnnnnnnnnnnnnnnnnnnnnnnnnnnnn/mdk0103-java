package gym;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public abstract class Pass {
    private LocalDate registrationDate;
    private LocalDate expirationDate;
    private Person owner;

    private static int startTime;
    private static int endTime;

    Pass(Person owner, int durationDays) {
        this.registrationDate = LocalDate.now();
        this.expirationDate = this.registrationDate.plusDays(durationDays);
        this.owner = owner;
    }

    boolean isExpired() {
        return Period.between(registrationDate, LocalDate.now()).getDays() > 0;
    }

    abstract boolean allowsZone(Zone zone);

    Person getOwner() {
        return owner;
    }

    int getCurrentTime() {
        return LocalTime.now().getHour();
        // return 17;
    }
}
