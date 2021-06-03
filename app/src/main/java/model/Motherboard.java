package model;

import android.os.Parcel;
import android.os.Parcelable;

public class Motherboard implements Parcelable {
    private int id_motherboard, Harga_Motherboard;
    private String Nama_Motherboard, Form_Factor, Chipset, Socket;

    public Motherboard(int id_motherboard, int harga_Motherboard, String nama_Motherboard, String form_Factor, String chipset, String socket) {
        this.id_motherboard = id_motherboard;
        Harga_Motherboard = harga_Motherboard;
        Nama_Motherboard = nama_Motherboard;
        Form_Factor = form_Factor;
        Chipset = chipset;
        Socket = socket;
    }

    public Motherboard() {
        this.id_motherboard = 0;
        Harga_Motherboard = 0;
        Nama_Motherboard = "";
        Form_Factor = "";
        Chipset = "";
        Socket = "";
    }

    protected Motherboard(Parcel in) {
        id_motherboard = in.readInt();
        Harga_Motherboard = in.readInt();
        Nama_Motherboard = in.readString();
        Form_Factor = in.readString();
        Chipset = in.readString();
        Socket = in.readString();
    }

    public static final Creator<Motherboard> CREATOR = new Creator<Motherboard>() {
        @Override
        public Motherboard createFromParcel(Parcel in) {
            return new Motherboard(in);
        }

        @Override
        public Motherboard[] newArray(int size) {
            return new Motherboard[size];
        }
    };

    public int getId_motherboard() {
        return id_motherboard;
    }

    public void setId_motherboard(int id_motherboard) {
        this.id_motherboard = id_motherboard;
    }

    public int getHarga_Motherboard() {
        return Harga_Motherboard;
    }

    public void setHarga_Motherboard(int harga_Motherboard) {
        Harga_Motherboard = harga_Motherboard;
    }

    public String getNama_Motherboard() {
        return Nama_Motherboard;
    }

    public void setNama_Motherboard(String nama_Motherboard) {
        Nama_Motherboard = nama_Motherboard;
    }

    public String getForm_Factor() {
        return Form_Factor;
    }

    public void setForm_Factor(String form_Factor) {
        Form_Factor = form_Factor;
    }

    public String getChipset() {
        return Chipset;
    }

    public void setChipset(String chipset) {
        Chipset = chipset;
    }

    public String getSocket() {
        return Socket;
    }

    public void setSocket(String socket) {
        Socket = socket;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_motherboard);
        dest.writeInt(Harga_Motherboard);
        dest.writeString(Nama_Motherboard);
        dest.writeString(Form_Factor);
        dest.writeString(Chipset);
        dest.writeString(Socket);
    }
}
