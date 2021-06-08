package model;

import android.os.Parcel;
import android.os.Parcelable;

public class gpusimpen implements Parcelable {
    public static String gpusimpen;

    public gpusimpen(String gpusimpen) {
        this.gpusimpen = gpusimpen;
    }

    protected gpusimpen(Parcel in) {
    }

    public static final Creator<gpusimpen> CREATOR = new Creator<gpusimpen>() {
        @Override
        public gpusimpen createFromParcel(Parcel in) {
            return new gpusimpen(in);
        }

        @Override
        public gpusimpen[] newArray(int size) {
            return new gpusimpen[size];
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
