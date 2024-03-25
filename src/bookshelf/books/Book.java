package bookshelf.books;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Book {

    private String title;
    private int pageCount;
    private Author author;

    public Book() {
    }

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public Book(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if (pageCount < 10) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Количество страниц не может быть меньше 10. Введите корректное значение: ");
            try {
            pageCount = scan.nextInt();}
            catch (InputMismatchException ex) {
                pageCount = 0;
            }
            setPageCount(pageCount);
            return;
        }
        this.pageCount = pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("author не может быть null");
        }
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', pageCount=%d}",title,author,pageCount);
    }
}
