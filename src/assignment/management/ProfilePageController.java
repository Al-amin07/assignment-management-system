/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package assignment.management;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author h
 */
public class ProfilePageController implements Initializable {

    @FXML
    private Label userNameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label roleLabel;
    @FXML
    private Label mongoIdLabel;
    @FXML
    private Button editBtn;
    @FXML
    private Button logoutBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserSession session = UserSession.getInstance();

        userNameLabel.setText(session.getUsername());
        mongoIdLabel.setText(session.getId());
        emailLabel.setText(session.getEmail());
        roleLabel.setText(session.getRole());
    }

    @FXML
    private void handleEdit(ActionEvent event) {
    }

    @FXML
    private void handleLogout(ActionEvent event) {
    }

}
