package model;

import android.os.Parcel;
import android.os.Parcelable;

public class cpucoolersimpen implements Parcelable {
    public static String cpucoolersimpen;

    public cpucoolersimpen(String cpucoolersimpen) {
        this.cpucoolersimpen = cpucoolersimpen;
    }


    protected cpucoolersimpen(Parcel in) {
    }

    public static final Creator<cpucoolersimpen> CREATOR = new Creator<cpucoolersimpen>() {
        @Override
        public cpucoolersimpen createFromParcel(Parcel in) {
            return new cpucoolersimpen(in);
        }

        @Override
        public cpucoolersimpen[] newArray(int size) {
            return new cpucoolersimpen[size];
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
