/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.management;

import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author h
 */
public class Assignment {

    private final SimpleStringProperty title;
    private final SimpleStringProperty dueDate;
    private final SimpleStringProperty subject;
    private final SimpleStringProperty description;

    public Assignment(String title, String subject, String dueDate, String description) {
        this.title = new SimpleStringProperty(title);
        this.subject = new SimpleStringProperty(subject);
        this.dueDate = new SimpleStringProperty(dueDate);
        this.description = new SimpleStringProperty(description);
    }

    public String getTitle() {
        return title.get();
    }

    public String getSubject() {
        return subject.get();
    }

    public String getDueDate() {
        return dueDate.get();
    }

    public String getDescription() {
        return description.get();
    }

 

}
