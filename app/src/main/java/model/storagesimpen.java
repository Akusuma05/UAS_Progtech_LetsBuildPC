package model;

import android.os.Parcel;
import android.os.Parcelable;

public class storagesimpen implements Parcelable {
    public static int storagesimpen;

    public storagesimpen(int storagesimpen) {
        this.storagesimpen = storagesimpen;
    }

    protected storagesimpen(Parcel in) {
    }

    public static final Creator<storagesimpen> CREATOR = new Creator<storagesimpen>() {
        @Override
        public storagesimpen createFromParcel(Parcel in) {
            return new storagesimpen(in);
        }

        @Override
        public storagesimpen[] newArray(int size) {
            return new storagesimpen[size];
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
