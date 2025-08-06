package services;

import java.util.List;
import models.Document;
import models.User;
import models.BorrowHistory;

public interface IStorageService {
    public void saveDoc(List<Document> documents);
    public List<Document> loadDocuments();
    public void saveBorrowHis(List<BorrowHistory> borrowHistories, User u);
    public List<BorrowHistory> loadBorrowHistories(User u);
    public void saveUser(List<User> users);
    public List<User> loadUsers();
}