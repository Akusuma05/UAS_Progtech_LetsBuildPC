package model;

import android.os.Parcel;
import android.os.Parcelable;

public class idpartsimpen implements Parcelable {
    public static int idpartsimpen;

    public idpartsimpen(int idpartsimpen) {
        this.idpartsimpen = idpartsimpen;
    }

    protected idpartsimpen(Parcel in) {
    }

    public static final Creator<idpartsimpen> CREATOR = new Creator<idpartsimpen>() {
        @Override
        public idpartsimpen createFromParcel(Parcel in) {
            return new idpartsimpen(in);
        }

        @Override
        public idpartsimpen[] newArray(int size) {
            return new idpartsimpen[size];
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
