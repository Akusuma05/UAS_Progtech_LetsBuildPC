package model;

import android.os.Parcel;
import android.os.Parcelable;

public class Casepc implements Parcelable {
    private String Nama_Case, Form_Factor_Case, Side_Panel_Windows, Color;
    private int id_casepc, Harga_Case;

    public Casepc(String nama_Case, String form_Factor_Case, String side_Panel_Windows, String color, int id_casepc, int harga_Case) {
        Nama_Case = nama_Case;
        Form_Factor_Case = form_Factor_Case;
        Side_Panel_Windows = side_Panel_Windows;
        Color = color;
        this.id_casepc = id_casepc;
        Harga_Case = harga_Case;
    }

    public Casepc() {
        Nama_Case = "";
        Form_Factor_Case = "";
        Side_Panel_Windows = "";
        Color = "";
        this.id_casepc = 0;
        Harga_Case = 0;
    }

    protected Casepc(Parcel in) {
        Nama_Case = in.readString();
        Form_Factor_Case = in.readString();
        Side_Panel_Windows = in.readString();
        Color = in.readString();
        id_casepc = in.readInt();
        Harga_Case = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Nama_Case);
        dest.writeString(Form_Factor_Case);
        dest.writeString(Side_Panel_Windows);
        dest.writeString(Color);
        dest.writeInt(id_casepc);
        dest.writeInt(Harga_Case);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Casepc> CREATOR = new Creator<Casepc>() {
        @Override
        public Casepc createFromParcel(Parcel in) {
            return new Casepc(in);
        }

        @Override
        public Casepc[] newArray(int size) {
            return new Casepc[size];
        }
    };

    public String getNama_Case() {
        return Nama_Case;
    }

    public void setNama_Case(String nama_Case) {
        Nama_Case = nama_Case;
    }

    public String getForm_Factor_Case() {
        return Form_Factor_Case;
    }

    public void setForm_Factor_Case(String form_Factor_Case) {
        Form_Factor_Case = form_Factor_Case;
    }

    public String getSide_Panel_Windows() {
        return Side_Panel_Windows;
    }

    public void setSide_Panel_Windows(String side_Panel_Windows) {
        Side_Panel_Windows = side_Panel_Windows;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getId_casepc() {
        return id_casepc;
    }

    public void setId_casepc(int id_casepc) {
        this.id_casepc = id_casepc;
    }

    public int getHarga_Case() {
        return Harga_Case;
    }

    public void setHarga_Case(int harga_Case) {
        Harga_Case = harga_Case;
    }
}
