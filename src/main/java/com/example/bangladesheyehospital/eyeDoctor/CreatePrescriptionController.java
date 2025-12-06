package com.example.bangladesheyehospital.eyeDoctor;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class CreatePrescriptionController
{
    @javafx.fxml.FXML
    private ComboBox patientIdCB;
    @javafx.fxml.FXML
    private Label dateL;
    @javafx.fxml.FXML
    private Label dateL1;
    @javafx.fxml.FXML
    private DatePicker followUpDP;
    @javafx.fxml.FXML
    private TextArea medicinesInfoTA;
    @javafx.fxml.FXML
    private TextArea adviceInfoTA;
    @javafx.fxml.FXML
    private TextArea diseaseInfoTA;
    @javafx.fxml.FXML
    private Label prescriptionIDL;
    @javafx.fxml.FXML
    private TextArea TestInfoTA;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createPrescriptionOA(ActionEvent actionEvent) {
    }
}