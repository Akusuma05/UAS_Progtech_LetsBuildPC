package model;

import android.os.Parcel;
import android.os.Parcelable;

public class CPU implements Parcelable {
    private String Nama_CPU, Socket;
    private int id_CPU, Core_Count, Core_Clock, TDP, Harga;

    public CPU(String nama_CPU, String socket, int id_CPU, int core_Count, int core_Clock, int TDP, int harga) {
        Nama_CPU = nama_CPU;
        Socket = socket;
        this.id_CPU = id_CPU;
        Core_Count = core_Count;
        Core_Clock = core_Clock;
        this.TDP = TDP;
        Harga = harga;
    }

    public CPU() {
        Nama_CPU = "";
        Socket = "";
        this.id_CPU = 0;
        Core_Count = 0;
        Core_Clock = 0;
        this.TDP = 0;
        Harga = 0;
    }

    protected CPU(Parcel in) {
        Nama_CPU = in.readString();
        Socket = in.readString();
        id_CPU = in.readInt();
        Core_Count = in.readInt();
        Core_Clock = in.readInt();
        TDP = in.readInt();
        Harga = in.readInt();
    }

    public static final Creator<CPU> CREATOR = new Creator<CPU>() {
        @Override
        public CPU createFromParcel(Parcel in) {
            return new CPU(in);
        }

        @Override
        public CPU[] newArray(int size) {
            return new CPU[size];
        }
    };

    public String getNama_CPU() {
        return Nama_CPU;
    }

    public void setNama_CPU(String nama_CPU) {
        Nama_CPU = nama_CPU;
    }

    public String getSocket() {
        return Socket;
    }

    public void setSocket(String socket) {
        Socket = socket;
    }

    public int getId_CPU() {
        return id_CPU;
    }

    public void setId_CPU(int id_CPU) {
        this.id_CPU = id_CPU;
    }

    public int getCore_Count() {
        return Core_Count;
    }

    public void setCore_Count(int core_Count) {
        Core_Count = core_Count;
    }

    public int getCore_Clock() {
        return Core_Clock;
    }

    public void setCore_Clock(int core_Clock) {
        Core_Clock = core_Clock;
    }

    public int getTDP() {
        return TDP;
    }

    public void setTDP(int TDP) {
        this.TDP = TDP;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int harga) {
        Harga = harga;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Nama_CPU);
        dest.writeString(Socket);
        dest.writeInt(id_CPU);
        dest.writeInt(Core_Count);
        dest.writeInt(Core_Clock);
        dest.writeInt(TDP);
        dest.writeInt(Harga);
    }
}
