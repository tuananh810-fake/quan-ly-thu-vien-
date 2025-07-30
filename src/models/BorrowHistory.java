package models;

import java.util.Date;
import java.util.List;

public class BorrowHistory {
    private Document book;
    private Date borrowDate;
    private Date returnDate;
    private boolean isReturned;

    public List<BorrowHistory> getBorrowHistory(Document book, Date borrowDate, Date returnDate, boolean isReturned) {
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.isReturned = isReturned;
        return List.of(this);
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