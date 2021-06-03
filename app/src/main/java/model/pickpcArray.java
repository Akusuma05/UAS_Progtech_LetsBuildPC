package model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class pickpcArray implements Parcelable {
    public static ArrayList<pickpc> pcpart = new ArrayList<pickpc>();

    public pickpcArray(ArrayList<pickpc> pcpart) {
        this.pcpart = pcpart;
    }

    protected pickpcArray(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<pickpcArray> CREATOR = new Creator<pickpcArray>() {
        @Override
        public pickpcArray createFromParcel(Parcel in) {
            return new pickpcArray(in);
        }

        @Override
        public pickpcArray[] newArray(int size) {
            return new pickpcArray[size];
        }
    };
}
