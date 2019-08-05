package com.robelseyoum3.parcelableassignmentbonus;

import android.os.Parcel;
import android.os.Parcelable;

public class Vehicle implements Parcelable {

    private String make;
    private String colour;
    private int numOfDoors;

    public Vehicle(String make, String colour, int numOfDoors) {
        this.make = make;
        this.colour = colour;
        this.numOfDoors = numOfDoors;
    }

    protected Vehicle(Parcel in) {
        make = in.readString();
        colour = in.readString();
        numOfDoors = in.readInt();
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(make);
        parcel.writeString(colour);
        parcel.writeInt(numOfDoors);
    }
}
