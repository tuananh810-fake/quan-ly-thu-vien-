package services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.Document;

public class DocumentService {

    private List<Document> documents;

    public DocumentService() {
        this.documents = new ArrayList<>();
    }

    // Getter để truy xuất danh sách tài liệu
    public List<Document> getDocuments() {
        return documents;
    }

    // 1. Thêm tài liệu mới vào danh sách
    public String addDocument(String title, String author, String publicationDate, String publisher, String language, String pages, int quantity) {
        // Kiểm tra các tham số đầu vào
        if (title == null || title.trim().isEmpty()) {
            return "Lỗi: Tiêu đề không được để trống.";
        }
        if (author == null || author.trim().isEmpty()) {
            return "Lỗi: Tác giả không được để trống.";
        }
        if (publicationDate == null || publicationDate.trim().isEmpty()) {
            return "Lỗi: Ngày xuất bản không được để trống.";
        }
        if (publisher == null || publisher.trim().isEmpty()) {
            return "Lỗi: Nhà xuất bản không được để trống.";
        }
        if (language == null || language.trim().isEmpty()) {
            return "Lỗi: Ngôn ngữ không được để trống.";
        }
        if (pages == null || pages.trim().isEmpty()) {
            return "Lỗi: Số trang không được để trống.";
        }
        if (quantity < 0) {
            return "Lỗi: Số lượng không thể là số âm.";
        }

        int pagesInt;
        try {
            pagesInt = Integer.parseInt(pages);
            if (pagesInt <= 0) {
                return "Lỗi: Số trang phải là số nguyên dương.";
            }
        } catch (NumberFormatException e) {
            return "Lỗi: Số trang phải là một số nguyên hợp lệ.";
        }

        // Tạo id duy nhất cho tài liệu
        String id = UUID.randomUUID().toString();

        // Tạo đối tượng Document mới với đầy đủ tham số
        Document newDocument = new Document(title, author, publicationDate, publisher, language, pagesInt, id, quantity);

        // Thêm tài liệu vào danh sách
        documents.add(newDocument);

        return "Thêm tài liệu '" + title + "' thành công!";
    }

    // 2. Mượn tài liệu
    public String borrowDocument(String documentId) {
        for (Document doc : documents) {
            if (doc.getId().equals(documentId)) {
                if (doc.getQuantity() > 0) {
                    doc.setQuantity(doc.getQuantity() - 1);
                    return "Mượn tài liệu '" + doc.getTitle() + "' thành công!";
                } else {
                    return "Tài liệu '" + doc.getTitle() + "' đã hết.";
                }
            }
        }
        return "Không tìm thấy tài liệu với ID: " + documentId;
    }

    // 3. Xóa tài liệu theo id
    public boolean removeDocument(String documentId) {
        // Duyệt danh sách tài liệu để tìm tài liệu có id tương ứng
        for (Document doc : documents) {
            if (doc.getId().equals(documentId)) {
                documents.remove(doc);
                return true; // Xóa thành công
            }
        }
        return false; // Không tìm thấy tài liệu để xóa
    }

    // 4. Cập nhật số lượng tài liệu theo id
    public boolean updateDocumentQuantity(String documentId, int newQuantity) {
        if (newQuantity < 0) {
            return false; // Số lượng không hợp lệ
        }
        // Duyệt danh sách tài liệu để tìm tài liệu có id tương ứng
        for (Document doc : documents) {
            if (doc.getId().equals(documentId)) {
                doc.setQuantity(newQuantity);
                return true; // Cập nhật thành công
            }
        }
        return false; // Không tìm thấy tài liệu để cập nhật
    }
}
