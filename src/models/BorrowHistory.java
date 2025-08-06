package models;

import java.util.Date;

public class BorrowHistory {
    private Document book;
    private Date borrowDate;
    private Date returnDate;
    private boolean isReturned;
    private User user;

    public BorrowHistory() {}

    public BorrowHistory (Document book, Date borrowDate, Date returnDate, boolean isReturned, User user) {
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.isReturned = isReturned;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Document getBook() {
        return book;
    }

    public void setBook(Document book) {
        this.book = book;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}