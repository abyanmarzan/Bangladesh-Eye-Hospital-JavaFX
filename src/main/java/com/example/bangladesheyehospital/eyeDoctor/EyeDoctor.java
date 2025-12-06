package com.example.bangladesheyehospital.eyeDoctor;

import com.example.bangladesheyehospital.User;

import java.time.LocalDate;
import java.util.Random;

public class EyeDoctor extends User {
    private  String licenceNo, type, timming;
    private int fees;

    public EyeDoctor(String name, String phoneNO, String email, String address, String gender, String password, LocalDate dob, String licenceNo, String type, String timming, int fees) {
        super(name, phoneNO, email, address, gender, password, dob);
        this.licenceNo = licenceNo;
        this.type = type;
        this.timming = timming;
        this.fees = fees;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimming() {
        return timming;
    }

    public void setTimming(String timming) {
        this.timming = timming;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return
                super.toString() + '\n' +
                "licenceNo=" + licenceNo + '\n' +
                ", type=" + type + '\n'+
                ", timming=" + timming + '\n' +
                ", fees=" + fees + "tk"+
                '.';
    }

    @Override
    public String generateID() {
        String id = "";

        Random random = new Random();

        id = Integer.toString(random.nextInt(1000, 9999));

        return id;
    }
}
