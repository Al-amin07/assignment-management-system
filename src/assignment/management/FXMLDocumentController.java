/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package assignment.management;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.bson.Document;

/**
 *
 * @author h
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField s_id;
    @FXML
    private PasswordField p_id;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        String username = s_id.getText();
        String password = p_id.getText();
        MongoDBConnector.connect();
        Document user = MongoDBConnector.login(username, password);
        System.out.println(user);
        if (user == null) {
            // User not found or login failed
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Invalid Email or Password");
            alert.setContentText("Please enter valid login credentials.");
            alert.showAndWait();
        } else {
            // Login successful
            String role = user.getString("role");
            String email = user.getString("email");
//            String id = user.getString("_id");
            UserSession.getInstance().setUser("2", user.getString("userName"), email, role);
            if (role.equals("student")) {
                System.out.println("userId: " + username + role + email + "2");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentDashboard.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) s_id.getScene().getWindow(); // get current window
                stage.setScene(new Scene(root));
                stage.setTitle("Student Dashboard");
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TeacherDashboard.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) s_id.getScene().getWindow(); // get current window
                stage.setScene(new Scene(root));
                stage.setTitle("Teacher Dashboard");
            }
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Successfull");
            alert.setHeaderText("");
            alert.setContentText("Welcome Back");
            alert.showAndWait();
            // You can now redirect to dashboard or continue
        }

    }

    @FXML
    private void goToRegister(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Registration.fxml")); // update name if needed
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Register");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
