package gym;

import java.util.ArrayList;
import java.util.List;

public class FitnessClub {
    private List<Pass> gymPasses = new ArrayList<>();
    private List<Pass> poolPasses = new ArrayList<>();
    private List<Pass> groupClassPasses = new ArrayList<>();

    void registerPass(Pass pass, Zone zone) {
        if (pass.isExpired()) {
            System.out.println("Срок действия абонемента истек.");
            return;
        }

        int capacity;
        capacity = switch (zone) {
            case GYM -> gymPasses.size();
            case POOL -> poolPasses.size();
            case GROUP_CLASS -> groupClassPasses.size();
        };

        if (capacity >= 20) {
            System.out.println("Зона переполнена.");
            return;
        }

        if (!pass.allowsZone(zone)) {
            System.out.println("В данный момент недоступна с этим видом абонемента.");
            return;
        }

        if (gymPasses.contains(pass) || poolPasses.contains(pass) || groupClassPasses.contains(pass)) {
            System.out.println("Абонемент уже зарегистрирован в зоне.");
            return;
        }

        switch (zone) {
            case GYM:
                gymPasses.add(pass);
                break;
            case POOL:
                poolPasses.add(pass);
                break;
            case GROUP_CLASS:
                groupClassPasses.add(pass);
                break;
        }

        System.out.println("Абонемент зарегистрирован.");
    }

    void unregisterPass(Pass pass, Zone zone) {
        switch (zone) {
            case GYM:
                gymPasses.remove(pass);
                break;
            case POOL:
                poolPasses.remove(pass);
                break;
            case GROUP_CLASS:
                groupClassPasses.remove(pass);
                break;
            default:
                throw new IllegalStateException("Unexpected zone: " + zone);
        }


    }

    void close() {
        gymPasses.clear();
        poolPasses.clear();
        groupClassPasses.clear();
    }

    void printVisitors() {
        System.out.println("Посетители тренажерного зала:");
        for (Pass pass : gymPasses) {
            System.out.println(pass.getOwner());
        }

        System.out.println("Посетители бассейна:");
        for (Pass pass : poolPasses) {
            System.out.println(pass.getOwner());
        }

        System.out.println("Посетители групповых занятий:");
        for (Pass pass : groupClassPasses) {
            System.out.println(pass.getOwner());
        }
    }
}
