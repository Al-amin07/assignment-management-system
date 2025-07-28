package assignment.management;

import static assignment.management.MongoDBConnector.connect;
import com.mongodb.client.MongoDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.bson.Document;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentAssignmentPageController implements Initializable {

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

    private final ObservableList<Assignment> assignments = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        subjectCol.setCellValueFactory(new PropertyValueFactory<>("subject"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        loadAssignments();
    }

    private void loadAssignments() {
        List<Document> docs = MongoDBConnector.getAllAssignments();
        assignments.clear();

        for (Document doc : docs) {
            String title = doc.getString("title");
            String subject = doc.getString("subject");
            String dueDate = doc.getString("dueDate");
            String description = doc.getString("description");

            assignments.add(new Assignment(title, subject, dueDate, description));
        }

        assignmentTable.setItems(assignments);
    }
    
//    public static void submitAssignment(String title, String studentEmail, String content) {
//    MongoDatabase database = connect();
//    Document submission = new Document("title", title)
//            .append("studentEmail", studentEmail)
//            .append("content", content)
//            .append("timestamp", System.currentTimeMillis());
//
//    database.getCollection("submissions").insertOne(submission);
//}

}
