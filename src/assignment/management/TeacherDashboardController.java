/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package assignment.management;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author h
 */
public class TeacherDashboardController implements Initializable {

    @FXML
    private BorderPane rootPane;
    @FXML
    private StackPane mainContent;
    @FXML
    private Label welcomeLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set up UI or fetch initial data here
//        loadPage("TeacherHomePage.fxml");
    }

    @FXML
    private void handleProfile() {
        loadPage("ProfilePage.fxml");
    }

    @FXML
    private void handleHome() {
        loadPage("TeacherHomePage.fxml");

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
        }
    }

}
