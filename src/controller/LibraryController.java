package controller;

//Import các class Services mà controller sẽ sử dụng
import services.DocumentService;
import services.UserService;

//Import các class Models mà controller cần trả về hoặc nhận đối tượng models
import models.Document;
import models.User;

//Import các lớp mà controller sẽ sử dụng
import java.util.List;// 1. Import các lớp Service mà Controller sẽ sử dụng

public class LibraryController {
    // Khai báo biến lưu trữ đối tượng service
    private DocumentService documentService;
    private UserService userService;

    // Constructor
    public LibraryController(DocumentService documentService, UserService userService) {
        this.documentService = documentService;
        this.userService = userService;
    }

    // Chức năng quản lý tài liệu
    // 1. Thêm tài liệu - nhận thông tin từ ViewConsole
    public String addDocument(String title, String author, String publicationDate, String publisher, String language, String pages, int quantity) {
        // Gọi DocumentService để thực hiện việc thêm tài liệu
        String result = documentService.addDocument(title, author, publicationDate, publisher, language, pages, quantity);
        return result;
    }

    // 2. Xóa tài liệu theo id
    public String removeDocument(String documentId) {
        boolean success = documentService.removeDocument(documentId);
        if (success) {
            return "Xóa tài liệu thành công.";
        } else {
            return "Không tìm thấy tài liệu với ID: " + documentId;
        }
    }

    // 3. Cập nhật số lượng tài liệu theo id
    public String updateDocument(String documentId, int newQuantity) {
        boolean success = documentService.updateDocumentQuantity(documentId, newQuantity);
        if (success) {
            return "Cập nhật số lượng tài liệu thành công.";
        } else {
            return "Không tìm thấy tài liệu với ID hoặc số lượng không hợp lệ.";
        }
    }
}


