package bookshelf;

import bookshelf.books.Author;
import bookshelf.books.Book;

public class Application {
    public static void main(String[] args) {
        Author author1 = new Author("Иван", "Иванов");
        Author author2 = new Author("Александр", "Пушкин");
        Author author3 = new Author();

        Book book1 = new Book("Книга", author1);
        Book book2 = new Book("Стихи", author2);
        Book book3 = new Book();
        Book book4 = new Book();
        Book book5 = new Book();
        Book book6 = new Book();
        Book book7 = new Book();

        Shelf shelf1 = new Shelf(10);
        Shelf shelf2 = new Shelf(0, "синий");

        shelf2.addBook(book1);
        shelf2.addBook(book2);
        System.out.println(shelf1.toString() + shelf2.toString());
    }
}
