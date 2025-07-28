/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.management;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author h
 */
public class UserDatabase {

    public static List<User> users = new ArrayList<>();

    static {
        // Default users with role "student" instead of "user"
        users.add(new User("1", "admin", "1234", "admin"));
        users.add(new User("2", "john", "1234", "student"));
        users.add(new User("3", "alamin", "1234", "student"));
    }

    public static boolean login(String userName, String password) {
        for (User user : users) {
            if (user.getUsername().equals(userName)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static String getUserRole(String userName) {
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                return user.getRole();
            }
        }
        return null; // or return "student" as default if not found
    }

    public static boolean register(String id, String username, String password) {
        for (User user : users) {
            if (user.getId().equals(id) && user.getUsername().equals(username)) {
                return false; // Username already exists
            }
        }
        users.add(new User(id, username, password, "student"));
        return true;
    }
}
