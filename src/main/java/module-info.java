module com.example.bangladesheyehospital {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bangladesheyehospital to javafx.fxml;
    opens com.example.bangladesheyehospital.admin to javafx.fxml, javafx.base;
    opens com.example.bangladesheyehospital.eyeDoctor to javafx.fxml, javafx.base;
    opens com.example.bangladesheyehospital.patient to javafx.fxml, javafx.base;
    exports com.example.bangladesheyehospital;
}