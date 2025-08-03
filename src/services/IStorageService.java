package services;

public class IStorageService {
    
}
import java.util.List;
import models.Document;

public interface IStorageService {
    void save(List<Document> documents);
    List<Document> loadDocuments();
}