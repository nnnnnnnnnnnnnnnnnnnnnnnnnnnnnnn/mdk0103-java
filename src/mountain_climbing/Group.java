package mountain_climbing;

import java.util.List;

public class Group {


    private String name;
    private boolean isOpen;
    private List<Climber> climbers;
    private Mountain mountain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group(String name, boolean isOpen, List<Climber> climbers, Mountain mountain) {
        setName(name);
        setOpen(isOpen);
        setClimbers(climbers);
        setMountain(mountain);
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        this.isOpen = open;
    }

    public List<Climber> getClimbers() {
        return climbers;
    }

    public void setClimbers(List<Climber> climbers) {
        this.climbers = climbers;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }

    public boolean addClimber(Climber climber) {
        if (isOpen)
        {
            climbers.add(climber);
            return true;
        }
        return false;
    }

    public void showInfo() {
        System.out.printf("Группа %s, набор %s\n", name, isOpen ? "открыт" : "закрыт");
        mountain.showInfo();
        System.out.println("Участники:");
        for (Climber climber : climbers)
            climber.showInfo();
        System.out.println();
    }

}
