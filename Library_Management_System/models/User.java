package models;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        if (!book.isBorrowed()) {
            book.borrowBook();
            borrowedBooks.add(book);
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println("Book already borrowed.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
            System.out.println(name + " returned " + book.getTitle());
        } else {
            System.out.println("Book not found in user's list.");
        }
    }

    public void viewBorrowedBooks() {
        System.out.println(name + "'s Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
