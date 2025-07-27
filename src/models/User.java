package models;

<<<<<<< HEAD
public class User {
    
}
=======
import java.util.List;
import java.util.ArrayList;

public class User {
    private String userID;
    private String name;
    private String email;
    private List<Book> borrowedBooks;
    private List<Book> borrowingHistory;
    private List<Thesis> borrowedTheses;
    private List<Thesis> borrowingHistoryTheses;
    private List<Document> borrowedDocuments;
    private List<Document> borrowingHistoryDocuments;

    // Constructor
    public User(String userID, String name, String email) { 
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
        this.borrowingHistory = new ArrayList<>();
        this.borrowedTheses = new ArrayList<>();
        this.borrowingHistoryTheses = new ArrayList<>();
        this.borrowedDocuments = new ArrayList<>();
        this.borrowingHistoryDocuments = new ArrayList<>();
    }

    // Getters
    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<Book> getBorrowingHistory() {
        return borrowingHistory;
    }

    public List<Thesis> getBorrowedTheses() {
        return borrowedTheses;
    }

    public List<Thesis> getBorrowingHistoryTheses() {
        return borrowingHistoryTheses;
    }

    public List<Document> getBorrowedDocuments() {
        return borrowedDocuments;
    }

    public List<Document> getBorrowingHistoryDocuments() {
        return borrowingHistoryDocuments;
    }

    // Setters
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void setBorrowingHistory(List<Book> borrowingHistory) {
        this.borrowingHistory = borrowingHistory;
    }

    public void setBorrowedTheses(List<Thesis> borrowedTheses) {
        this.borrowedTheses = borrowedTheses;
    }

    public void setBorrowingHistoryTheses(List<Thesis> borrowingHistoryTheses) {
        this.borrowingHistoryTheses = borrowingHistoryTheses;
    }

    public void setBorrowedDocuments(List<Document> borrowedDocuments) {
        this.borrowedDocuments = borrowedDocuments;
    }

    public void setBorrowingHistoryDocuments(List<Document> borrowingHistoryDocuments) {
        this.borrowingHistoryDocuments = borrowingHistoryDocuments;
    }
}
>>>>>>> edd18aa5ed8ec2e418302875afd4483d58c42a44
