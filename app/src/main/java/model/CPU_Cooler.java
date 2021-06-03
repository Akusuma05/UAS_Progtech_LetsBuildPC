package model;

import android.os.Parcel;
import android.os.Parcelable;

public class CPU_Cooler implements Parcelable {
    private String Nama_Cooler, Cooler_Type;
    private int id_cpucooler, Fan_RPM, Noise_Level, Harga_Cooler;

    public CPU_Cooler(String nama_Cooler, String cooler_Type, int id_cpucooler, int fan_RPM, int noise_Level, int harga_Cooler) {
        Nama_Cooler = nama_Cooler;
        Cooler_Type = cooler_Type;
        this.id_cpucooler = id_cpucooler;
        Fan_RPM = fan_RPM;
        Noise_Level = noise_Level;
        Harga_Cooler = harga_Cooler;
    }

    public CPU_Cooler() {
        Nama_Cooler = "";
        Cooler_Type = "";
        this.id_cpucooler = 0;
        Fan_RPM = 0;
        Noise_Level = 0;
        Harga_Cooler = 0;
    }

    protected CPU_Cooler(Parcel in) {
        Nama_Cooler = in.readString();
        Cooler_Type = in.readString();
        id_cpucooler = in.readInt();
        Fan_RPM = in.readInt();
        Noise_Level = in.readInt();
        Harga_Cooler = in.readInt();
    }

    public static final Creator<CPU_Cooler> CREATOR = new Creator<CPU_Cooler>() {
        @Override
        public CPU_Cooler createFromParcel(Parcel in) {
            return new CPU_Cooler(in);
        }

        @Override
        public CPU_Cooler[] newArray(int size) {
            return new CPU_Cooler[size];
        }
    };

    public String getNama_Cooler() {
        return Nama_Cooler;
    }

    public void setNama_Cooler(String nama_Cooler) {
        Nama_Cooler = nama_Cooler;
    }

    public String getCooler_Type() {
        return Cooler_Type;
    }

    public void setCooler_Type(String cooler_Type) {
        Cooler_Type = cooler_Type;
    }

    public int getId_cpucooler() {
        return id_cpucooler;
    }

    public void setId_cpucooler(int id_cpucooler) {
        this.id_cpucooler = id_cpucooler;
    }

    public int getFan_RPM() {
        return Fan_RPM;
    }

    public void setFan_RPM(int fan_RPM) {
        Fan_RPM = fan_RPM;
    }

    public int getNoise_Level() {
        return Noise_Level;
    }

    public void setNoise_Level(int noise_Level) {
        Noise_Level = noise_Level;
    }

    public int getHarga_Cooler() {
        return Harga_Cooler;
    }

    public void setHarga_Cooler(int harga_Cooler) {
        Harga_Cooler = harga_Cooler;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Nama_Cooler);
        dest.writeString(Cooler_Type);
        dest.writeInt(id_cpucooler);
        dest.writeInt(Fan_RPM);
        dest.writeInt(Noise_Level);
        dest.writeInt(Harga_Cooler);
    }
}
