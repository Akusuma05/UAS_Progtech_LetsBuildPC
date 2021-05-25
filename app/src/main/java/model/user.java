package model;

import android.os.Parcel;
import android.os.Parcelable;

public class user implements Parcelable {
    private String nama, email, password, sudahlogin;

    public user(String nama, String email, String password, String sudahlogin) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.sudahlogin = sudahlogin;
    }

    protected user(Parcel in) {
        nama = in.readString();
        email = in.readString();
        password = in.readString();
        sudahlogin = in.readString();
    }

    public static final Creator<user> CREATOR = new Creator<user>() {
        @Override
        public user createFromParcel(Parcel in) {
            return new user(in);
        }

        @Override
        public user[] newArray(int size) {
            return new user[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSudahlogin() {
        return sudahlogin;
    }

    public void setSudahlogin(String sudahlogin) {
        this.sudahlogin = sudahlogin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(sudahlogin);
    }
}
