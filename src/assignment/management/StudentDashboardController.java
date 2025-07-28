package assignment.management;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class StudentDashboardController {

    @FXML
    private StackPane mainContent;

    @FXML
    private Button homeBtn, assignmentsBtn, profileBtn, logoutBtn;

    private Button activeButton;

    @FXML
    public void initialize() {
        loadPage("HomePage.fxml"); // load home page on startup
        setActiveButton(homeBtn);
    }

    @FXML
    private void handleHome() {
        loadPage("HomePage.fxml");
        setActiveButton(homeBtn);
    }

    @FXML
    private void handleAssignments() {
        loadPage("Assignments.fxml");
        setActiveButton(assignmentsBtn);
    }

    @FXML
    private void handleProfile() {
        loadPage("ProfilePage.fxml");
        setActiveButton(profileBtn);
    }

    @FXML
    private void handleLogout() {
        // your logout logic, e.g. close app or return to login page
        System.exit(0);
    }

    private void loadPage(String fxmlFile) {
        try {
            Parent page = FXMLLoader.load(getClass().getResource(fxmlFile));
            mainContent.getChildren().setAll(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setActiveButton(Button button) {
        if (activeButton != null) {
            activeButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        }
        activeButton = button;
        activeButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
    }
}
