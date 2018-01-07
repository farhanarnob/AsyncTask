package com.example.android.restful.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

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
    private int page;
    private int perPage;
    private int total;
    private int totalPages;
    private List<SingleData> data = null;

    public DataItem() {
    }

    protected DataItem(Parcel in) {
        this.page = in.readInt();
        this.perPage = in.readInt();
        this.total = in.readInt();
        this.totalPages = in.readInt();
        this.data = new ArrayList<SingleData>();
        in.readList(this.data, SingleData.class.getClassLoader());
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<SingleData> getData() {
        return data;
    }

    public void setData(List<SingleData> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.page);
        dest.writeInt(this.perPage);
        dest.writeInt(this.total);
        dest.writeInt(this.totalPages);
        dest.writeList(this.data);
    }
}