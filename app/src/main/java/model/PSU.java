package model;

import android.os.Parcel;
import android.os.Parcelable;

public class PSU implements Parcelable {
    private int id_psu, Wattage_PSU, Harga_PSU;
    private String Nama_PSU, Form_Factor_PSU, Modular, Efficiency_Rating;

    public PSU(int id_psu, int wattage_PSU, int harga_PSU, String nama_PSU, String form_Factor_PSU, String modular, String efficiency_Rating) {
        this.id_psu = id_psu;
        Wattage_PSU = wattage_PSU;
        Harga_PSU = harga_PSU;
        Nama_PSU = nama_PSU;
        Form_Factor_PSU = form_Factor_PSU;
        Modular = modular;
        Efficiency_Rating = efficiency_Rating;
    }

    public PSU() {
        this.id_psu = 0;
        Wattage_PSU = 0;
        Harga_PSU = 0;
        Nama_PSU = "";
        Form_Factor_PSU = "";
        Modular = "";
        Efficiency_Rating = "";
    }

    protected PSU(Parcel in) {
        id_psu = in.readInt();
        Wattage_PSU = in.readInt();
        Harga_PSU = in.readInt();
        Nama_PSU = in.readString();
        Form_Factor_PSU = in.readString();
        Modular = in.readString();
        Efficiency_Rating = in.readString();
    }

    public static final Creator<PSU> CREATOR = new Creator<PSU>() {
        @Override
        public PSU createFromParcel(Parcel in) {
            return new PSU(in);
        }

        @Override
        public PSU[] newArray(int size) {
            return new PSU[size];
        }
    };

    public int getId_psu() {
        return id_psu;
    }

    public void setId_psu(int id_psu) {
        this.id_psu = id_psu;
    }

    public int getWattage_PSU() {
        return Wattage_PSU;
    }

    public void setWattage_PSU(int wattage_PSU) {
        Wattage_PSU = wattage_PSU;
    }

    public int getHarga_PSU() {
        return Harga_PSU;
    }

    public void setHarga_PSU(int harga_PSU) {
        Harga_PSU = harga_PSU;
    }

    public String getNama_PSU() {
        return Nama_PSU;
    }

    public void setNama_PSU(String nama_PSU) {
        Nama_PSU = nama_PSU;
    }

    public String getForm_Factor_PSU() {
        return Form_Factor_PSU;
    }

    public void setForm_Factor_PSU(String form_Factor_PSU) {
        Form_Factor_PSU = form_Factor_PSU;
    }

    public String getModular() {
        return Modular;
    }

    public void setModular(String modular) {
        Modular = modular;
    }

    public String getEfficiency_Rating() {
        return Efficiency_Rating;
    }

    public void setEfficiency_Rating(String efficiency_Rating) {
        Efficiency_Rating = efficiency_Rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_psu);
        dest.writeInt(Wattage_PSU);
        dest.writeInt(Harga_PSU);
        dest.writeString(Nama_PSU);
        dest.writeString(Form_Factor_PSU);
        dest.writeString(Modular);
        dest.writeString(Efficiency_Rating);
    }
}
