package com.example.bangladesheyehospital.admin;

import com.example.bangladesheyehospital.patient.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.Objects;


public class VerifyPatientController
{
    @javafx.fxml.FXML
    private TableView <Patient>patientTBV;
    @javafx.fxml.FXML
    private Label genderL;
    @javafx.fxml.FXML
    private TableColumn <Patient, String>genderTC;
    @javafx.fxml.FXML
    private TableColumn <Patient, String> nameTc;
    @javafx.fxml.FXML
    private TableColumn <Patient, String> emailTC;
    @javafx.fxml.FXML
    private Label emailL;
    @javafx.fxml.FXML
    private TableColumn <Patient, String> pNTC;
    @javafx.fxml.FXML
    private Label nameL;
    @javafx.fxml.FXML
    private Label dobL;
    @javafx.fxml.FXML
    private TableColumn <Patient, String> idTC;
    @javafx.fxml.FXML
    private ComboBox <String> idCB;
    @javafx.fxml.FXML
    private Label pNL;
    @javafx.fxml.FXML
    private TableColumn <Patient, String>  statusTC;

    Admin admin;
    ObservableList<Patient> patientObservableList = FXCollections.observableArrayList();


    public void setter (Admin admin) {
        this.admin = admin;
    }

    @javafx.fxml.FXML
    public void initialize() {

        patientObservableList.add(
                new Patient(
                        "patient1",
                        "01740499280",
                        "patient1@gmail.com",
                        "Dhaka",
                        "Male",
                        "1245",
                        LocalDate.of(1990, 2, 10),
                        "01631468378"
                )
        );

        patientObservableList.add(
                new Patient(
                        "patient2",
                        "01740499280",
                        "patient2@gmail.com",
                        "Dhaka",
                        "Female",
                        "1246",
                        LocalDate.of(1990, 2, 10),
                        "01631468378"
                )
        );

        patientObservableList.add(
                new Patient(
                        "patient3",
                        "01740499280",
                        "patient3@gmail.com",
                        "Dhaka",
                        "Male",
                        "1247",
                        LocalDate.of(1990, 2, 10),
                        "01631468378"
                )
        );

        patientObservableList.add(
                new Patient(
                        "patient4",
                        "01740499280",
                        "patient4@gmail.com",
                        "Dhaka",
                        "Female",
                        "1248",
                        LocalDate.of(1990, 2, 10),
                        "01631468378"
                )
        );

        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTc.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailTC.setCellValueFactory(new PropertyValueFactory<>("email"));
        genderTC.setCellValueFactory(new PropertyValueFactory<>("gender"));
        pNTC.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));


        for (Patient patient : patientObservableList) {
            if(patient.getStatus() == 2) {
                idCB.getItems().add(patient.getId());
            }

        }

        patientTBV.setItems(patientObservableList);

    }

    @javafx.fxml.FXML
    public void idCBOA(ActionEvent actionEvent) {
        String id = idCB.getValue();

        for (Patient patient: patientObservableList) {
            if (Objects.equals(patient.getId(), id)) {
                nameL.setText(patient.getName());
                emailL.setText(patient.getName());
                pNL.setText(patient.getPhoneNO());
                genderL.setText(patient.getGender());
                dobL.setText(patient.getDob().toString());
                break;
            }
        }

    }


    @javafx.fxml.FXML
    public void acceptOA(ActionEvent actionEvent) {
        String id = idCB.getValue();

        for (Patient patient: patientObservableList) {
            if (Objects.equals(patient.getId(), id)) {
                this.admin.verifyPatientAccount(patient, 1);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Patient Account Verify");
                alert.setContentText("Patient Account has been Accepted successfully");
                alert.showAndWait();
                break;
            }
        }

        idCB.getItems().removeAll();
        for (Patient patient : patientObservableList) {
            if(patient.getStatus() == 2) {
                idCB.getItems().add(patient.getId());
            }

        }
    }

    @javafx.fxml.FXML
    public void rejectOA(ActionEvent actionEvent) {

        String id = idCB.getValue();

        for (Patient patient: patientObservableList) {
            if (Objects.equals(patient.getId(), id)) {
                this.admin.verifyPatientAccount(patient, 0);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Patient Account Verify");
                alert.setContentText("Patient Account has been rejected successfully");
                alert.showAndWait();
                break;
            }
        }

        idCB.getItems().removeAll();

        for (Patient patient : patientObservableList) {
            if(patient.getStatus() == 2) {
                idCB.getItems().add(patient.getId());
            }

        }
    }
}
