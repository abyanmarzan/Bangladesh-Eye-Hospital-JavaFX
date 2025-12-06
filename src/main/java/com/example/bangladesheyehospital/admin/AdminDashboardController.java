package com.example.bangladesheyehospital.admin;

import com.example.bangladesheyehospital.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.zip.Inflater;

public class AdminDashboardController
{
    @javafx.fxml.FXML
    private TextArea infoTA;
    @javafx.fxml.FXML
    private BorderPane adminDashboardBP;

    Admin admin;
    public void setter(Admin admin) {
        this.admin = admin;
        infoTA.setText(admin.toString());
    }


    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createDoctorOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin/CreateEyeDoctorAccount.fxml"));
        adminDashboardBP.setCenter(fxmlLoader.load());
        CreateEyeDoctorAccountController createEyeDoctorAccountController = fxmlLoader.getController();
        createEyeDoctorAccountController.setter(this.admin);

    }

    @javafx.fxml.FXML
    public void verifyPatientOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin/VerifyPatient.fxml"));
        adminDashboardBP.setCenter(fxmlLoader.load());
        VerifyPatientController verifyPatientController = fxmlLoader.getController();
        verifyPatientController.setter(admin);
    }

    @javafx.fxml.FXML
    public void controlUserOA(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("admin/ControlUsersAccount.fxml"));
        adminDashboardBP.setCenter(fxmlLoader.load());
    }
}
