package models;

import java.util.List;
import java.util.ArrayList;

public class User {
    private String userID;
    private String name;
    private String email;
    private List<BorrowHistory> borrowHistory;

    public User(String userID, String name, String email) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.borrowHistory = new ArrayList<>();
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

    public List<BorrowHistory> getBorrowHistory() {
        return borrowHistory;
    }

    public void setBorrowHistory(List<BorrowHistory> borrowHistory) {
        this.borrowHistory = borrowHistory;
    }
}
