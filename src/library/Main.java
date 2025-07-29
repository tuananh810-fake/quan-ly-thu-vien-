package library;

import controller.LibraryController;
import services.DocumentService;
import services.UserService;

public class Main {

    public static void main(String[] args) {
        // Khởi tạo các service
        DocumentService documentService = new DocumentService();
        UserService userService = new UserService();

        // Khởi tạo controller với các service
        LibraryController libraryController = new LibraryController(documentService, userService);

        // Kiểm thử thêm tài liệu với dữ liệu hợp lệ
        System.out.println("=== Thêm tài liệu hợp lệ ===");
        String addResult1 = libraryController.addDocument("Lập trình Java", "Nguyễn Văn A", "2023-01-01", "NXB Giáo Dục", "Tiếng Việt", "300", 10);
        System.out.println(addResult1);

        // Kiểm thử thêm tài liệu với dữ liệu không hợp lệ (thiếu tiêu đề)
        System.out.println("=== Thêm tài liệu thiếu tiêu đề ===");
        String addResult2 = libraryController.addDocument("", "Nguyễn Văn B", "2023-01-01", "NXB Giáo Dục", "Tiếng Việt", "200", 5);
        System.out.println(addResult2);

        // Kiểm thử thêm tài liệu với dữ liệu không hợp lệ (số trang âm)
        System.out.println("=== Thêm tài liệu số trang âm ===");
        String addResult3 = libraryController.addDocument("Lập trình Python", "Nguyễn Văn C", "2023-01-01", "NXB Giáo Dục", "Tiếng Việt", "-50", 5);
        System.out.println(addResult3);

        // Giả định id tài liệu vừa thêm (do chưa có phương thức lấy id thực tế)
        String fakeId = "123e4567-e89b-12d3-a456-426614174000";

        // Kiểm thử xóa tài liệu với id không tồn tại
        System.out.println("=== Xóa tài liệu không tồn tại ===");
        String removeResult1 = libraryController.removeDocument(fakeId);
        System.out.println(removeResult1);

        // Kiểm thử cập nhật số lượng với id không tồn tại
        System.out.println("=== Cập nhật số lượng tài liệu không tồn tại ===");
        String updateResult1 = libraryController.updateDocument(fakeId, 20);
        System.out.println(updateResult1);

        // Kiểm thử cập nhật số lượng với số lượng âm
        System.out.println("=== Cập nhật số lượng âm ===");
        String updateResult2 = libraryController.updateDocument(fakeId, -5);
        System.out.println(updateResult2);
    }
}
