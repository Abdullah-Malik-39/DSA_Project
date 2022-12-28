package com.example.Controllers;

import com.example.finalproject.BinaryTree;
import com.example.finalproject.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class mainControl {
    public static BinaryTree tree = new BinaryTree();
    public DatePicker dueDateUpdate;
    public TextField nameFieldUpdate;
    public TextField durationUpdate;
    public TextArea descriptionUpdate;
    public BorderPane UpdateTask;
    public Button submitButtonUpdate;
    public Button cancelButtonUpdate;
    @FXML
    ListView<Task> listView;
    ObservableList<Task> tasks;
    @FXML
    private Pane CenterPane;
    @FXML
    private BorderPane AddTask;
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField duration;
    @FXML
    private TextArea description;
    @FXML
    private DatePicker dueDate;
    @FXML
    private Label descriptionBox;
    @FXML
    private Label durationBox;
    @FXML
    private Label duedateBox;
    @FXML
    private Label completedBox;

    @FXML
    private void updateTask() {
        Task n = listView.getSelectionModel().getSelectedItem();
        if (n == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please Select a Task!");
            alert.showAndWait();
        } else {

            UpdateTask.setVisible(true);
            listView.setVisible(false);
        }
    }

    @FXML
    public void PressClose() {
        Stage stage = (Stage) AddTask.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void submitPressed() {
        Task t = new Task(nameField.getText(), description.getText(), Integer.parseInt(duration.getText()), dueDate.getValue());
        tree.addTask(t, t.getDueDate());
        Update_list();
        listView.setItems(tasks);
        AddTask.setVisible(false);
        listView.setVisible(true);

    }

    @FXML
    public void cancelPressed() {
        AddTask.setVisible(false);
        listView.setVisible(true);

    }

    @FXML
    private void addTask() {
        listView.setVisible(false);
        AddTask.setVisible(true);

    }


    @FXML
    private void deleteTask() {
        Task n = listView.getSelectionModel().getSelectedItem();
        tree.deleteNode(n);
        Update_list();
        listView.setItems(tasks);
        descriptionBox.setText("");
        durationBox.setText("");
        duedateBox.setText("");
        completedBox.setText("");
        tree.printTree();
    }

    @FXML
    private void completeTask() {
        Task n = listView.getSelectionModel().getSelectedItem();
        tree.Complete(n.getName());
        Update_list();
        completedBox.setText((n.isCompleted() + ""));
    }

    @FXML
    public void initialize() {

        Task task1 = new Task("Write report", "Write a report for the meeting", 120, LocalDate.now().plusDays(4));
        Task task2 = new Task("Prepare presentation", "Prepare a presentation for the conference", 240, LocalDate.now().plusDays(3));
        Task task3 = new Task("Update website", "Update the company website", 60, LocalDate.now().plusDays(2));
        Task task4 = new Task("Attend meeting", "Attend the weekly team meeting", 30, LocalDate.now().plusDays(1));
        tree.addTask(task1, task1.getDueDate());
        tree.addTask(task2, task2.getDueDate());
        tree.addTask(task3, task3.getDueDate());
        tree.addTask(task4, task4.getDueDate());


        tasks = FXCollections.observableArrayList();
        Update_list();
        listView.setItems(tasks);

        listView.setOnMouseClicked(mouseEvent -> {
            if (tasks.isEmpty()) {
                descriptionBox.setText("");
                durationBox.setText("");
                duedateBox.setText("");
                completedBox.setText("");
            }
            Task n = listView.getSelectionModel().getSelectedItem();
            descriptionBox.setText(n.getDescription());
            durationBox.setText(n.getDuration() + "");
            duedateBox.setText(n.getDueDate() + "");
            completedBox.setText((n.isCompleted() + ""));
        });

    }

    public void Update_list() {
        tasks = tree.getTree();
    }

    public void submitPressedUpdate(ActionEvent actionEvent) {
        UpdateTask.setVisible(false);
        listView.setVisible(true);
    }

    public void cancelPressedUpdate(ActionEvent actionEvent) {
        UpdateTask.setVisible(false);
        listView.setVisible(true);
    }
}