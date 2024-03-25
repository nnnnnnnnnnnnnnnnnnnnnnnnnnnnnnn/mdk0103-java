package bookshelf;
import java.util.Arrays;
import java.util.stream.IntStream;

import bookshelf.books.*;

public class Shelf {
    private String color = "белый";
    public Book[] books;

    public Shelf(int capacity) {
        setCapacity(capacity);
    }

    public Shelf(int capacity, String color) {
        setCapacity(capacity);
        this.color = color;
    }

    public void addBook(Book book){
        int index = IntStream.range(0, books.length).filter(i -> books[i] == null).findFirst().orElse(-1);
            if (index != -1) {
                books[index] = book;
                return;
            }
        System.out.printf("Книге автора %s не хватило места на полке \n", book.getAuthor().getFullName());
    }

    public String getColor() {
        return color;
    }

    private void setCapacity(int capacity) {
        this.books = new Book[capacity > 0 ? capacity : 1];
    }

    public int getCapacity() {
        return books.length;
    }

    @Override
    public String toString() {
        return String.format("Shelf{color='%s',capacity=%s, books=%s}\n", color, books.length, Arrays.toString(books));
    }

}

