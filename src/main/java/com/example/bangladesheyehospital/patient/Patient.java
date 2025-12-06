package com.example.bangladesheyehospital.patient;


import com.example.bangladesheyehospital.User;

import java.time.LocalDate;
import java.util.Random;

public class Patient extends User {
    private int status; // status == 2 pending; 1 == accepted; 0 == rejected
    private String emergencyContact;

    public Patient(String name, String phoneNO, String email, String address, String gender, String password, LocalDate dob,String emergencyContact) {
        super(name, phoneNO, email, address, gender, password, dob);
        this.setId(this.generateID());
        this.status = 2;
        this.emergencyContact = emergencyContact;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    @Override
    public String toString() {
        return
                super.toString() + '\n' +
                "EmergencyContact ='" + emergencyContact + '\n' +
                "status" + status
                ;
    }

    @Override
    public String generateID() {
        String id = "";

        Random random = new Random();
        id = Integer.toString(random.nextInt(1000000, 9999999));
        return id;
    }

}
