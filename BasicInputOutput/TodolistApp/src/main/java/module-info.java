module com.tonio.todolistapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tonio.todolistapp to javafx.fxml;
    exports com.tonio.todolistapp;
}