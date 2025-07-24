package services;



import models.Book;
import java.util.*;

public class LibrarySystem {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(String bookId) {
        books.removeIf(book -> book.getId().equals(bookId));
        System.out.println("Book removed with ID: " + bookId);
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("Book not found: " + title);
        return null;
    }

    public void listAllBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
        }
    }
    public List<Book> getAllBooks() {
        return books;
    }
}

