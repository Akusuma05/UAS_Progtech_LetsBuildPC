package model;

import android.os.Parcel;
import android.os.Parcelable;

public class Memory implements Parcelable {
    private int id_memory,  Speed, Harga;
    private String Size, Nama_Memory;

    public Memory(int id_memory, int speed, int harga, String size, String nama_Memory) {
        this.id_memory = id_memory;
        Speed = speed;
        Harga = harga;
        Size = size;
        Nama_Memory = nama_Memory;
    }

    public Memory() {
        this.id_memory = 0;
        Speed = 0;
        Harga = 0;
        Size = "";
        Nama_Memory = "";
    }

    protected Memory(Parcel in) {
        id_memory = in.readInt();
        Speed = in.readInt();
        Harga = in.readInt();
        Size = in.readString();
        Nama_Memory = in.readString();
    }

    public static final Creator<Memory> CREATOR = new Creator<Memory>() {
        @Override
        public Memory createFromParcel(Parcel in) {
            return new Memory(in);
        }

        @Override
        public Memory[] newArray(int size) {
            return new Memory[size];
        }
    };

    public int getId_memory() {
        return id_memory;
    }

    public void setId_memory(int id_memory) {
        this.id_memory = id_memory;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int harga) {
        Harga = harga;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getNama_Memory() {
        return Nama_Memory;
    }

    public void setNama_Memory(String nama_Memory) {
        Nama_Memory = nama_Memory;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_memory);
        dest.writeInt(Speed);
        dest.writeInt(Harga);
        dest.writeString(Size);
        dest.writeString(Nama_Memory);
    }
}
