package services;

public class FileStorageService {
    
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import models.Document;

public class FileStorageService implements IStorageService {
    private final String FILE_PATH = "document.txt";

    @Override
    public void save(List<Document> documents) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Document doc : documents) {
                writer.write(doc.toString());
                writer.newLine();
            }
            System.out.println("Luu tai lieu thanh cong");
        } catch (IOException e) {
            System.err.println("Loi khi mo tai lieu" + e.getMessage());
        }
    }

    public List<Document> loaDocuments() {
        List<Document> documents = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                documents.add(Document.fromString(line));
            }
        } catch (IOException e) {
            System.err.println("Loi khu mo tai lieu" + e.getMessage());
        }
        return documents;
    }

}
