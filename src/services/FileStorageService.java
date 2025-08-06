package services;
 
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import models.Document;
import models.BorrowHistory;
import models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FileStorageService implements IStorageService {
    private final String FILE_PATH = "document.json";
    private final String BORROW_FILE_PRE = "borrow_";
    private final Gson gson = new Gson();
    
    @Override
    public void saveDoc(List<Document> documents) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            String json = gson.toJson(documents);
            writer.write(json);
        } catch (IOException e) {
            System.err.println("Loi khi truy cap file" + e.getMessage());
        }
    }

    @Override
    public List<Document> loadDocuments() {
        List <Document> doc = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return doc;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            //dung de chuyen doi tuong tu json -> java va giu kieu dinh dang List<Document>
            doc = gson.fromJson(reader, new TypeToken<List<Document>>(){}.getType())
            
            if (doc == null) {
                doc = new ArrayList<>();
            }
        } catch (IOException e) {
            System.err.println("Loi khi truy cap file" + e.getMessage());
        }

        return doc;
    }

    @Override
    public void saveBorrowHis(List<BorrowHistory> borrowHistories, User u) {
        // file cua tung borrowhistory gan voi tung userid rieng
        String fileName = BORROW_FILE_PRE + u.getUserID() + ".json";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // chuyen dang tu list -> json
            String json = gson.toJson(borrowHistories);
            writer.write(json);
        } catch (IOException e) {
            System.err.println("Loi khi xu ly tep" + e.getMessage());
        }
    }

    @Override
    public List<BorrowHistory> loadBorrowHistories(User u) {
        String fileName = BORROW_FILE_PRE + u.getUserID() + "json";
        List<BorrowHistory> borrowHistories;
        File file = new File(fileName);

        if (!file.exists()) {
            return borrowHistories;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            borrowHistories = gson.fromJson(reader, new TypeToken<List<BorrowHistory>>(){}.getType());

            if (borrowHistories == null) {
                borrowHistories = new ArrayList<>();
            }
        } catch (IOException e) {
            System.err.println("Loi khi xu ly file" + e.getMessage());
        }

        return borrowHistories;
    }

    

}
