package gui;

import models.*;
import services.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibraryGUI {
    private LibrarySystem librarySystem = new LibrarySystem();
    private User user = new User("u01", "Alice");

    public LibraryGUI() {
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 1));

        JButton addBookBtn = new JButton("Add Book");
        JButton listBooksBtn = new JButton("List All Books");
        JButton borrowBookBtn = new JButton("Borrow Book");
        JButton returnBookBtn = new JButton("Return Book");
        JButton searchBookBtn = new JButton("Search Book");
        JButton viewBorrowedBtn = new JButton("View Borrowed Books");

        frame.add(addBookBtn);
        frame.add(listBooksBtn);
        frame.add(borrowBookBtn);
        frame.add(returnBookBtn);
        frame.add(searchBookBtn);
        frame.add(viewBorrowedBtn);

        // Button Listeners
        addBookBtn.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Enter Book ID:");
            String title = JOptionPane.showInputDialog("Enter Book Title:");
            String author = JOptionPane.showInputDialog("Enter Author Name:");
            Book book = new Book(id, title, author);
            librarySystem.addBook(book);
        });

        listBooksBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Books in Library:\n");
            for (Book book : librarySystem.getAllBooks()) {
                sb.append(book.getTitle()).append(" - ").append(book.getAuthor());
                sb.append(book.isBorrowed() ? " (Borrowed)" : " (Available)").append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        });

        borrowBookBtn.addActionListener(e -> {
            String title = JOptionPane.showInputDialog("Enter Book Title to Borrow:");
            Book book = librarySystem.searchBook(title);
            if (book != null) user.borrowBook(book);
        });

        returnBookBtn.addActionListener(e -> {
            String title = JOptionPane.showInputDialog("Enter Book Title to Return:");
            Book book = librarySystem.searchBook(title);
            if (book != null) user.returnBook(book);
        });

        searchBookBtn.addActionListener(e -> {
            String title = JOptionPane.showInputDialog("Enter Title to Search:");
            Book book = librarySystem.searchBook(title);
            if (book != null)
                JOptionPane.showMessageDialog(null, "Found: " + book.getTitle() + " by " + book.getAuthor());
        });

        viewBorrowedBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder(user.getName() + "'s Borrowed Books:\n");
            for (Book b : user.getBorrowedBooks()) {
                sb.append("- ").append(b.getTitle()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        });

        frame.setVisible(true);
    }
}
