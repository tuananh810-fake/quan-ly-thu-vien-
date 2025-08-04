package test.services;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import models.User;
import services.UserService;

public class UserServiceTest {
    
    private UserService userService;
    
    @Before
    public void setUp() {
        userService = new UserService();
    }
    
    @Test
    public void testAddUser() {
        String result = userService.addUser("U001", "John Doe", "john@example.com", "0123456789", "Student");
        assertEquals("User added successfully", "Thêm người dùng John Doe thành công!", result);
    }
    
    @Test
    public void testFindUserById() {
        userService.addUser("U001", "John Doe", "john@example.com", "0123456789", "Student");
        
        User found = null;
        for (User user : userService.getUsers()) {
            if (user.getId().equals("U001")) {
                found = user;
                break;
            }
        }
        
        assertNotNull("User should be found", found);
        assertEquals("John Doe", found.getName());
    }
}
