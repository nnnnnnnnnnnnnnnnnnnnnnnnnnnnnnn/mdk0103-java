package gym;

public class Person {
    private String name;
    private String surname;
    private int birthYear;

    public Person(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return String.format("%s %s", surname, name);
    }
}
