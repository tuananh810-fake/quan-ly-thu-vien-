package services;

import java.util.ArrayList;
import java.util.List;

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

    // Thêm người dùng mới vào danh sách với ID tự động tăng
    public String addUser(String name, String email) {  
        // Kiểm tra các tham số đầu vào
        if (name == null || name.trim().isEmpty()) {
            return "Lỗi: Tên không được để trống.";
        }
        if (email == null || email.trim().isEmpty()) {
            return "Lỗi: Email không được để trống.";
        }
        
        // Tạo ID tự động tăng theo số thứ tự
        String id = "USER" + String.format("%04d", users.size() + 1);

        // Tạo đối tượng User mới
        User user = new User(id, name, email);
        users.add(user);
        
        return "Thêm người dùng thành công với ID: " + id;
    }
}
