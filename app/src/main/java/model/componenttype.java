package model;

import android.os.Parcel;
import android.os.Parcelable;

public class componenttype implements Parcelable {
    String tipe;

    public componenttype(String tipe) {
        this.tipe = tipe;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    protected componenttype(Parcel in) {
        tipe = in.readString();
    }

    public static final Creator<componenttype> CREATOR = new Creator<componenttype>() {
        @Override
        public componenttype createFromParcel(Parcel in) {
            return new componenttype(in);
        }

        @Override
        public componenttype[] newArray(int size) {
            return new componenttype[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tipe);
    }
}
