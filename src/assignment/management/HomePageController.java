/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package assignment.management;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author h
 */
public class HomePageController implements Initializable {

    @FXML
    private Label totalAssignmentsLabel;
    @FXML
    private Label completedAssignmentsLabel;
    @FXML
    private Label pendingAssignmentsLabel;
    @FXML
    private Label marksLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // Sample values, you can load these from MongoDB
        totalAssignmentsLabel.setText("12");
        completedAssignmentsLabel.setText("8");
        pendingAssignmentsLabel.setText("4");
        marksLabel.setText("92");
    }

}
