package model;

import android.os.Parcel;
import android.os.Parcelable;

public class motherboardsimpen implements Parcelable {
    public static String motherboardsimpen;

    public motherboardsimpen(String motherboardsimpen) {
        this.motherboardsimpen = motherboardsimpen;
    }

    protected motherboardsimpen(Parcel in) {
    }

    public static final Creator<motherboardsimpen> CREATOR = new Creator<motherboardsimpen>() {
        @Override
        public motherboardsimpen createFromParcel(Parcel in) {
            return new motherboardsimpen(in);
        }

        @Override
        public motherboardsimpen[] newArray(int size) {
            return new motherboardsimpen[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
