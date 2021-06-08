package model;

import android.os.Parcel;
import android.os.Parcelable;

public class idpart implements Parcelable {
    int id;

    public idpart(int id) {
        this.id = id;
    }

    protected idpart(Parcel in) {
        id = in.readInt();
    }

    public static final Creator<idpart> CREATOR = new Creator<idpart>() {
        @Override
        public idpart createFromParcel(Parcel in) {
            return new idpart(in);
        }

        @Override
        public idpart[] newArray(int size) {
            return new idpart[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
    }
}
