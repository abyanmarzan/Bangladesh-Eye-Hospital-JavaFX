package com.example.bangladesheyehospital.admin;

import com.example.bangladesheyehospital.eyeDoctor.EyeDoctor;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.time.LocalDate;

public class CreateEyeDoctorAccountController
{
    @javafx.fxml.FXML
    private TextArea outputTA;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private DatePicker dOBDP;
    @javafx.fxml.FXML
    private TextField phoneNoTF;
    @javafx.fxml.FXML
    private TextField passwordTF;
    @javafx.fxml.FXML
    private RadioButton femaleRB;
    @javafx.fxml.FXML
    private TextField timingTF;
    @javafx.fxml.FXML
    private TextField feesTF;
    @javafx.fxml.FXML
    private TextArea AddressTA;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private RadioButton maleRB;
    @javafx.fxml.FXML
    private ComboBox <String> typeCB;
    @javafx.fxml.FXML
    private TextField licenceNoTF;

    Admin admin;

    public void setter(Admin admin){
        this.admin = admin;
    }

    @javafx.fxml.FXML
    public void initialize() {
        typeCB.getItems().addAll("Medicine and lence Specialist", "Eye Surgeon ");
    }

    public void cEDAOA(ActionEvent actionEvent) {

        String name = nameTF.getText();
        String email = emailTF.getText();
        String phoneNo = phoneNoTF.getText();
        String address = AddressTA.getText();
        String licenseNo = licenceNoTF.getText();
        String type = typeCB.getValue();
        String timing = timingTF.getText();
        LocalDate dob = dOBDP.getValue();
        String password = passwordTF.getText();
        int fees = Integer.parseInt(feesTF.getText());

        String gender = "";
        if (maleRB.isSelected()) gender = "Male";
        else if (femaleRB.isSelected()) gender = "Female";

        EyeDoctor doctor = admin.createEyeDoctorAccount(
                name,
                phoneNo,
                email,
                address,
                gender,
                password,
                dob,
                licenseNo,
                type,
                timing,
                fees
        );

        outputTA.setText(doctor.toString());

        nameTF.clear();
        phoneNoTF.clear();
        emailTF.clear();
        AddressTA.clear();
        licenceNoTF.clear();
        timingTF.clear();
        feesTF.clear();
        passwordTF.clear();

    }
}