package com.example.android.restful.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DataItem implements Parcelable {
    public static final Parcelable.Creator<DataItem> CREATOR = new Parcelable.Creator<DataItem>() {
        @Override
        public DataItem createFromParcel(Parcel source) {
            return new DataItem(source);
        }

        @Override
        public DataItem[] newArray(int size) {
            return new DataItem[size];
        }
    };
    private int id;
    private String name;
    private int year;
    private String color;
    private String pantoneValue;

    public DataItem() {
    }

    protected DataItem(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.year = in.readInt();
        this.color = in.readString();
        this.pantoneValue = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPantoneValue() {
        return pantoneValue;
    }

    public void setPantoneValue(String pantoneValue) {
        this.pantoneValue = pantoneValue;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.year);
        dest.writeString(this.color);
        dest.writeString(this.pantoneValue);
    }
}