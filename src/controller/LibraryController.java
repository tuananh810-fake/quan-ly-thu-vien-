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
    private DocumentService documentServices;
    private UserService userServices;

    // Constructor
    public LibraryController(DocumentService documentServices, UserService userService) {
        this.documentServices = documentServices;
        this.userServices = userService;
    }

    // Chức năng quản lý tài liệu
    // 1.addDocument(Thêm tài liệu)-Nhận thông tin từ ViewConsole
    public String addDocument(String title, String author, String publicationDate,String publisher, String language, String pages,String quantily){
        try {
        // Gọi DocumentService để thực hiện việc thêm tài liệu
        // DocumentService sẽ tạo ra đối tượng Document, Book, hoặc Thesis
        // dựa trên 'type' và các thông tin khác
        documentServices.addDocument(id, title, author, publicationDate, publisher, language,publicationDate,publisher, pages, ,quantity);
        return "Thêm tài liệu '" + title + "' thành công!";
        } catch (IllegalArgumentException e) {
            return "Lỗi khi thêm tài liệu: " + e.getMessage();
        } catch (Exception e) {
            return "Đã xảy ra lỗi không mong muốn khi thêm tài liệu.";
        }
    }

    // 2.removeDocument(Xóa tài liệu)
    public String removeDocument(String DocumentId) {
        if (documentServices.removeDocument(DocumentId)) {
            return "Xóa tài liệu với ID '" + DocumentId + "' thành công!";
        } else {
            return "Không tìm thấy tài liệu với ID '" + DocumentId + "' để xóa.";
        }
    }

    // 3.updateDocument()
    public String updateDocument(String DocumentId, int NewQuantily) {
        if (NewQuantily<0) {
            return "Lỗi:Số lượng mới không thể nhỏ hơn 0";
        }
        if (documentServices.updateDocumentQuantity(DocumentId,NewQuantily)) {
            return "Cập nhật số lượng tài liệu ID '" + DocumentId + "' thành công thành " + NewQuantily + ".";
        } else {
            return "Không tìm thấy tài liệu với ID '" + DocumentId + "' để cập nhật.";
        }
    }
}


