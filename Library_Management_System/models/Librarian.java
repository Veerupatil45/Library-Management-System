package models;

import services.LibrarySystem;

public class Librarian extends User {

    public Librarian(String userId, String name) {
        super(userId, name);
    }

    public void addBook(LibrarySystem library, Book book) {
        library.addBook(book);
    }

    public void removeBook(LibrarySystem library, String bookId) {
        library.removeBook(bookId);
    }
}
