package controller;

import dao.UserDAO;
import model.User;

public class AdminController {

    private UserDAO userDAO;

    public AdminController() {
        this.userDAO = new UserDAO();
    }

    // Menambahkan user baru (hanya admin yang bisa melakukannya)
    public void addUser(String username, String password, String role) {
        if (role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("staff")) {
            User user = new User(username, password, role);
            userDAO.addUser(user);
        } else {
            System.out.println("Role tidak valid!");
        }
    }

    // Menghapus user (hanya admin yang bisa melakukannya)
    public void deleteUser(int userID) {
        userDAO.deleteUser(userID);
    }

    // Mengubah data user (hanya admin yang bisa melakukannya)
    public void updateUser(int userID, String username, String password, String role) {
        userDAO.updateUser(userID, username, password, role);
    }
}
