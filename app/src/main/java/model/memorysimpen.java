package model;

import android.os.Parcel;
import android.os.Parcelable;

public class memorysimpen implements Parcelable {
    public static int memorysimpen;

    public memorysimpen(int memorysimpen) {
        this.memorysimpen = memorysimpen;
    }

    protected memorysimpen(Parcel in) {
    }

    public static final Creator<memorysimpen> CREATOR = new Creator<memorysimpen>() {
        @Override
        public memorysimpen createFromParcel(Parcel in) {
            return new memorysimpen(in);
        }

        @Override
        public memorysimpen[] newArray(int size) {
            return new memorysimpen[size];
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
