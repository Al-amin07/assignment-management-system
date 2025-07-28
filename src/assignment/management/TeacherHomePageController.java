/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package assignment.management;

import com.mongodb.client.MongoDatabase;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.bson.Document;

/**
 * FXML Controller class
 *
 * @author h
 */
public class TeacherHomePageController implements Initializable {

    @FXML
    private TableView<Assignment> assignmentTable;
    @FXML
    private TableColumn<Assignment, String> titleCol;
    @FXML
    private TableColumn<Assignment, String> subjectCol;
    @FXML
    private TableColumn<Assignment, String> dueDateCol;
    @FXML
    private TableColumn<Assignment, String> descriptionCol;

    @FXML
    private TextField titleField;
    @FXML
    private TextField subjectField;
    @FXML
    private TextField dueDateField;
    @FXML
    private TextField descriptionField;

    private String userEmail;

    private ObservableList<Assignment> assignments = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UserSession session = UserSession.getInstance();

        userEmail = session.getEmail();

        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        subjectCol.setCellValueFactory(new PropertyValueFactory<>("subject"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        loadAssignments();
    }

    @FXML
    private void handleCreateAssignment(ActionEvent event) {
        String title = titleField.getText().trim();
        String subject = subjectField.getText().trim();
        String description = descriptionField.getText().trim();
        String dueDate = dueDateField.getText().trim();

        MongoDBConnector.connect();
        MongoDBConnector.createAssignment(title, subject, description, dueDate, userEmail);

        Assignment assignment = new Assignment(title, subject, dueDate, description);
        assignments.add(assignment);

        titleField.clear();
        subjectField.clear();
        dueDateField.clear();
        descriptionField.clear();
    }

    private void loadAssignments() {
        List<Document> docs = MongoDBConnector.getAllAssignments();
        assignments.clear(); // Clear old data

        for (Document doc : docs) {
            String title = doc.getString("title");
            String subject = doc.getString("subject");
            String dueDate = doc.getString("dueDate");
            String description = doc.getString("description");

            assignments.add(new Assignment(title, subject, dueDate, description));
        }

        assignmentTable.setItems(assignments);
    }

}
