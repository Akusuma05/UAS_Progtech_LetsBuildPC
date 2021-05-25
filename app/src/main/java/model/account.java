package model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class account implements Parcelable{
    public static ArrayList<user> listuser = new ArrayList<user>();

    public account(ArrayList<user> listuser) {
        this.listuser = listuser;
    }

    protected account(Parcel in) {
        listuser = in.createTypedArrayList(user.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(listuser);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<account> CREATOR = new Parcelable.Creator<account>() {
        @Override
        public account createFromParcel(Parcel in) {
            return new account(in);
        }

        @Override
        public account[] newArray(int size) {
            return new account[size];
        }
    };
}
