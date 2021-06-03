package model;

import android.os.Parcel;
import android.os.Parcelable;

public class componenttypesimpen implements Parcelable {
    public static String tipepilihcomponent;

    public componenttypesimpen(String tipepilihcomponent) {
        this.tipepilihcomponent = tipepilihcomponent;
    }

    protected componenttypesimpen(Parcel in) {
    }

    public static final Creator<componenttypesimpen> CREATOR = new Creator<componenttypesimpen>() {
        @Override
        public componenttypesimpen createFromParcel(Parcel in) {
            return new componenttypesimpen(in);
        }

        @Override
        public componenttypesimpen[] newArray(int size) {
            return new componenttypesimpen[size];
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
