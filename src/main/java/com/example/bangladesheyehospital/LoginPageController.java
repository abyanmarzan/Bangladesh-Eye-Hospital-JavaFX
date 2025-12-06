package com.example.bangladesheyehospital;

import com.example.bangladesheyehospital.admin.Admin;
import com.example.bangladesheyehospital.admin.AdminDashboardController;
import com.example.bangladesheyehospital.eyeDoctor.EyeDoctor;
import com.example.bangladesheyehospital.patient.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;



public class LoginPageController
{
    @javafx.fxml.FXML
    private TextField userIdTF;
    @javafx.fxml.FXML
    private TextField passwordTF;

    ObservableList<Admin> adminObservableList = FXCollections.observableArrayList();
    ObservableList<EyeDoctor> eyeDoctorObservableList = FXCollections.observableArrayList();
    ObservableList<Patient> patientObservableList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        Admin admin = new Admin(
                "Admin",
                "01631468378",
                "admin@gmail.com",
                "Dhaka",
                "Male",
                "1234",
                LocalDate.of(1990, 1, 1)
        );
        adminObservableList.add(admin);

        Admin admin2 = new Admin(
                "Admin2",
                "01631468378",
                "admin2@gmail.com",
                "Dhaka",
                "Female",
                "1235",
                LocalDate.of(1990, 9, 1)
        );
        adminObservableList.add(admin2);

        Patient patient = new Patient(
                "Sakib Khan",
                "01712345678",
                "sakib@gmail.com",
                "Mirpur, Dhaka",
                "Male",
                "pass123",
                LocalDate.of(2000, 5, 20),
                "01800000000"
        );
        patientObservableList.add(patient);

    }

    @javafx.fxml.FXML
    public void createAccountOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loginOA(ActionEvent actionEvent) throws IOException {
        String id, password;
        boolean flag = true;

        Alert erroralert = new Alert(Alert.AlertType.ERROR);

        id = userIdTF.getText();
        password = passwordTF.getText();

        if (id.isBlank()) {
            flag = false;
            erroralert.setTitle("User ID Error");
            erroralert.setContentText("User ID can not be blank");
            erroralert.showAndWait();
        }
        if (password.isBlank()) {
            flag = false;
            erroralert.setTitle("User Password Error");
            erroralert.setContentText("User Password can not be blank");
            erroralert.showAndWait();
        }

        if (flag) {
            if(id.length() == 4) {
                // login as a Doctor
            }
            if(id.length() == 5) {
                for (Admin admin: adminObservableList){
                    if (admin.login(id, password) != null) {
                        Parent root = null ;
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin/AdminDashboard.fxml"));
                        root = fxmlLoader.load();
                        AdminDashboardController adminDashboardController = fxmlLoader.getController();
                        adminDashboardController.setter(admin);
                        Scene scene = new Scene(root);
                        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("AdminDashboard");
                        stage.show();
                    }
                }
            } else {
                erroralert.setTitle("User Password Error");
                erroralert.setContentText("User ID type does not exist");
                erroralert.showAndWait();
            }
        }
    }
}