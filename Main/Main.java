package Main;
import controller.LoginController;
import view.LoginView;
import utils.DbConnection;

public class Main {
    public static void main(String[] args) {
        // Set Look and Feel
        try {
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Failed to set Look and Feel");
        }

        // Jalankan aplikasi dari LoginView
        javax.swing.SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            new LoginController(loginView);
            loginView.setVisible(true);
        });
    }
}
