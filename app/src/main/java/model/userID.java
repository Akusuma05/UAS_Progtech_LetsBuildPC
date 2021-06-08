package model;

import android.os.Parcel;
import android.os.Parcelable;

public class userID implements Parcelable {
    private int userID;

    public userID(int userID) {
        this.userID = userID;
    }

    protected userID(Parcel in) {
        userID = in.readInt();
    }

    public static final Creator<userID> CREATOR = new Creator<userID>() {
        @Override
        public userID createFromParcel(Parcel in) {
            return new userID(in);
        }

        @Override
        public userID[] newArray(int size) {
            return new userID[size];
        }
    };

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userID);
    }
}
