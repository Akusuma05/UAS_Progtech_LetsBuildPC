package model;

import android.os.Parcel;
import android.os.Parcelable;

public class cpusimpen implements Parcelable {
    public static String cpusimpen;

    public cpusimpen(String cpusimpen) {
        this.cpusimpen = cpusimpen;
    }

    protected cpusimpen(Parcel in) {
    }

    public static final Creator<cpusimpen> CREATOR = new Creator<cpusimpen>() {
        @Override
        public cpusimpen createFromParcel(Parcel in) {
            return new cpusimpen(in);
        }

        @Override
        public cpusimpen[] newArray(int size) {
            return new cpusimpen[size];
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
