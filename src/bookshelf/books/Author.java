package bookshelf.books;

public class Author {
    private String name;
    private String surname;

    public Author() {
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return String.format("Author{name='%s', surname='%s'}", name, surname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name не может быть пустой строкой");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname.isEmpty()) {
            throw new IllegalArgumentException("surname не может быть пустой строкой");
        }
        this.surname = surname;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public void printFullName() {
        System.out.println(name + " " + surname);
    }
}
