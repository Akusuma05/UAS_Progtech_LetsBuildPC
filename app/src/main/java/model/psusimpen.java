package model;

import android.os.Parcel;
import android.os.Parcelable;

public class psusimpen implements Parcelable {
    public static String psusimpen;

    public psusimpen(String psusimpen) {
        this.psusimpen = psusimpen;
    }

    protected psusimpen(Parcel in) {
    }

    public static final Creator<psusimpen> CREATOR = new Creator<psusimpen>() {
        @Override
        public psusimpen createFromParcel(Parcel in) {
            return new psusimpen(in);
        }

        @Override
        public psusimpen[] newArray(int size) {
            return new psusimpen[size];
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
