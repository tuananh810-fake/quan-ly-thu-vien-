package services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import models.User;

public class UserService {
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    // Getter để truy xuất danh sách người dùng
    public List<User> getUsers() {
        return users;
    }

    // 1. Thêm người dùng mới vào danh sách
    public String addUser(String name, String email, String phoneNumber) {  
        // Kiểm tra các tham số đầu vào
        if (name == null || name.trim().isEmpty()) {
            return "Lỗi: Tên không được để trống.";
        }
        if (email == null || email.trim().isEmpty()) {
            return "Lỗi: Email không được để trống.";
        }
        
        // Tạo id duy nhất cho người dùng
        String id = UUID.randomUUID().toString();

        // Tạo đối tượng User mới với đầy đủ tham số
        User user = new User(name, email, id);
        users.add(user);
        
        return "Thêm người dùng thành công với ID: " + id;
    }
}
