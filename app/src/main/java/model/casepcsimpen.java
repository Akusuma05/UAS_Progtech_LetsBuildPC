package model;

import android.os.Parcel;
import android.os.Parcelable;

public class casepcsimpen implements Parcelable {
    public static String casepcsimpen;

    public casepcsimpen(String casepcsimpen) {
        this.casepcsimpen = casepcsimpen;
    }

    protected casepcsimpen(Parcel in) {
    }

    public static final Creator<casepcsimpen> CREATOR = new Creator<casepcsimpen>() {
        @Override
        public casepcsimpen createFromParcel(Parcel in) {
            return new casepcsimpen(in);
        }

        @Override
        public casepcsimpen[] newArray(int size) {
            return new casepcsimpen[size];
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
