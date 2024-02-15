package mountain_climbing;

public class Mountain {

    private String name;
    private String country;
    private double height;

    public Mountain(String name, String country, double height) {
        setName(name);
        setCountry(country);
        setHeight(height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = Math.abs(height);
    }

    public void showInfo(){
        System.out.printf("%s, страна - %s, высота %s м\n", name, country, height);
    }

}
