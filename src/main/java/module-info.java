module com.example.bangladesheyehospital {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bangladesheyehospital to javafx.fxml;
    exports com.example.bangladesheyehospital;
}