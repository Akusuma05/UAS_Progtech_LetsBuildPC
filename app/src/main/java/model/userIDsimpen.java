package model;

import android.os.Parcel;
import android.os.Parcelable;

public class userIDsimpen implements Parcelable {
    public static int useridsimpen;

    public userIDsimpen(int useridsimpen) {
        this.useridsimpen = useridsimpen;
    }


    protected userIDsimpen(Parcel in) {
    }

    public static final Creator<userIDsimpen> CREATOR = new Creator<userIDsimpen>() {
        @Override
        public userIDsimpen createFromParcel(Parcel in) {
            return new userIDsimpen(in);
        }

        @Override
        public userIDsimpen[] newArray(int size) {
            return new userIDsimpen[size];
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
