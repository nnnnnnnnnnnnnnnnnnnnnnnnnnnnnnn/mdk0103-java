package mountain_climbing;

public class Climber {

    private String name;
    private int age;
    private String address;

    public Climber(String name, int age, String address) {
        setName(name);
        if (!setAge(age)) setAge(18);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public boolean setAge(int age) {
        if (18 <= age && age < 100) {
            this.age = age;
            return true;
        }
        return false;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void showInfo() {
        System.out.printf("%s, %s лет, адрес: %s\n", name, age, address);
    }

}
