package com.example.test23;

import com.google.gson.annotations.SerializedName;

public class DataModel {

    @SerializedName("name")
    private CName cName;


    @SerializedName("location")
    private CLocation cLocation;


    @SerializedName("picture")
    private CPicture cPicture;



    //constructor

    public DataModel(CName cName, CLocation cLocation, CPicture cPicture) {
        this.cName = cName;
        this.cLocation = cLocation;
        this.cPicture = cPicture;
    }


    //getters and setters

    public CName getcName() {
        return cName;
    }

    public void setcName(CName cName) {
        this.cName = cName;
    }

    public CLocation getcLocation() {
        return cLocation;
    }

    public void setcLocation(CLocation cLocation) {
        this.cLocation = cLocation;
    }

    public CPicture getcPicture() {
        return cPicture;
    }

    public void setcPicture(CPicture cPicture) {
        this.cPicture = cPicture;
    }
}