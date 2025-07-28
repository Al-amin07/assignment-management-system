/* * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template */
package assignment.management;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.FindIterable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;

/**
 * MongoDB Connector with User and Complaint Management
 *
 * @author ferda
 */
public class MongoDBConnector {

    private static final String CONNECTION_STRING
            = "mongodb+srv://car_store:o7rRRjAeMw1lYPzJ@cluster0.pekpvn6.mongodb.net/assignment-management?retryWrites=true&w=majority&appName=Cluster0";

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    // Connect to MongoDB
    public static void connect() {
        ConnectionString connString = new ConnectionString(CONNECTION_STRING);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .build();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("assignment-management");
        System.out.println("Connected to MongoDB.");
    }

    // Get the database object
    public static MongoDatabase getDatabase() {
        if (database == null) {
            connect();
        }
        return database;
    }

    // Close the connection when app exits
    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("MongoDB connection closed.");
        }
    }

    // ==================== USER MANAGEMENT METHODS ====================
    public static void AddNewUser(String userName, String id, String email, String password) {
        try {
            MongoDatabase db = getDatabase();
            MongoCollection<Document> users = db.getCollection("users");
            Document doc = new Document("userName", userName)
                    .append("id", id)
                    .append("password", password)
                    .append("email", email)
                    .append("role", "student");
            // WARNING: Plaintext, only okay for testing
            users.insertOne(doc);
            System.out.println("Inserted user into MongoDB.");
        } catch (Exception e) {
            System.out.println("MongoDB insert failed: " + e.getMessage());
        }
    }

    public static Document login(String email, String password) {
        try {
            MongoDatabase db = getDatabase();  // Your MongoDB connection method
            MongoCollection<Document> users = db.getCollection("users");

            Document user = users.find(
                    new Document("email", email)
                            .append("password", password) // plaintext check (for testing only)
            ).first();

            if (user != null) {
                System.out.println("Login successful");
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
            return null;
        }
    }

    public static Document authenticateAndGetUser(String userName, String password) {
        try {
            MongoDatabase db = getDatabase();
            MongoCollection<Document> users = db.getCollection("users");
            Document query = new Document("email", userName).append("password", password);
            Document user = users.find(query).first();  // returns null if not found
            return user;
        } catch (Exception e) {
            System.out.println("MongoDB authentication failed: " + e.getMessage());
            return null;
        }
    }

    public static boolean createAssignment(String title, String subject, String description, String dueDate, String teacherEmail) {
        try {
            MongoDatabase db = getDatabase();
            MongoCollection<Document> assignments = db.getCollection("assignments");

            Document newAssignment = new Document("title", title)
                    .append("description", description)
                    .append("subject", subject)
                    .append("dueDate", dueDate)
                    .append("teacherEmail", teacherEmail)
                    .append("createdAt", new Date());

            assignments.insertOne(newAssignment);
            return true;
        } catch (Exception e) {
            System.out.println("MongoDB create assignment failed: " + e.getMessage());
            return false;
        }
    }

    public static List<Document> getAllAssignments() {
        List<Document> assignmentsList = new ArrayList<>();
        try {
            MongoDatabase db = getDatabase();
            MongoCollection<Document> assignments = db.getCollection("assignments");

            for (Document doc : assignments.find()) {
                assignmentsList.add(doc);
            }

        } catch (Exception e) {
            System.out.println("MongoDB get all assignments failed: " + e.getMessage());
        }
        return assignmentsList;
    }

}
