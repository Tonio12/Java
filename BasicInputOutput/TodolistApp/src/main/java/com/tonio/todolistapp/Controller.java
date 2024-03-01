package com.tonio.todolistapp;

import com.tonio.todolistapp.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Controller {
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;
    private List<TodoItem> todoItems = new LinkedList<>();
    public void initialize() {
        TodoItem item1 = new TodoItem("Mail Birthday card", "Buy  a birthday card for Tonio",
                LocalDate.of(2023, Month.AUGUST, 3));
        TodoItem item2 = new TodoItem("Get Passport", "Complete getting your passport",
                LocalDate.of(2023, Month.AUGUST, 5));
        TodoItem item3 = new TodoItem("Buy Spring course", "Buy the Tom Java Spring Course",
                LocalDate.of(2023, Month.AUGUST, 1));

        TodoItem item4 = new TodoItem("Complete CV", "Complete new CV",
                LocalDate.of(2023, Month.JUNE, 30));

        TodoItem item5 = new TodoItem("Pick Up Birth Certificate", "Go pick up the biometric birth certificate",
                LocalDate.of(2023, Month.AUGUST, 30));

        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getSelectionModel().selectedItemProperty().addListener((observableValue, todoItem, newValue) -> {
            if(newValue != null)  {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                itemDetailsTextArea.setText(item.getDetails());
            }
        });

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
    }
}