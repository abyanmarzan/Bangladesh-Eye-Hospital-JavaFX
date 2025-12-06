package com.example.bangladesheyehospital.admin;

import com.example.bangladesheyehospital.User;
import com.example.bangladesheyehospital.eyeDoctor.EyeDoctor;
import com.example.bangladesheyehospital.patient.Patient;

import java.time.LocalDate;
import java.util.Objects;

public class Admin extends User {
    public Admin(String name, String phoneNO, String email, String address, String gender, String password, LocalDate dob) {
        super(name, phoneNO, email, address, gender, password, dob);
    }

    @Override
    public String generateID() {
        return "admin";
    }

    public  Admin login(String id, String password) {
        if(Objects.equals(id, this.getId()) && Objects.equals(password, this.getPassword())){
            return this;
        }
        return null;
    }

    public EyeDoctor createEyeDoctorAccount(String name, String phoneNO, String email, String address, String gender, String password, LocalDate dob, String licenceNo, String type, String timming, int fees) {
        EyeDoctor eyeDoctor = new EyeDoctor(name, phoneNO, email, address, gender, password,dob, licenceNo,type, timming, fees );
        return eyeDoctor ;
    }

    public Patient verifyPatientAccount(Patient patient, int status){
        patient.setStatus(status);
        return patient;
    }


}
