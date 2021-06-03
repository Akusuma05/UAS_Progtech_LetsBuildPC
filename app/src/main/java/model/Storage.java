package model;

import android.os.Parcel;
import android.os.Parcelable;

public class Storage implements Parcelable {
    private int id_storage, Harga_Storage, Size_Storage;
    private String Nama_Storage, Storage_Type, Form_Factor;

    public Storage(int id_storage, int harga_Storage, int size_Storage, String nama_Storage, String storage_Type, String form_Factor) {
        this.id_storage = id_storage;
        Harga_Storage = harga_Storage;
        Size_Storage = size_Storage;
        Nama_Storage = nama_Storage;
        Storage_Type = storage_Type;
        Form_Factor = form_Factor;
    }

    public Storage() {
        this.id_storage = 0;
        Harga_Storage = 0;
        Size_Storage = 0;
        Nama_Storage = "";
        Storage_Type = "";
        Form_Factor = "";
    }

    protected Storage(Parcel in) {
        id_storage = in.readInt();
        Harga_Storage = in.readInt();
        Size_Storage = in.readInt();
        Nama_Storage = in.readString();
        Storage_Type = in.readString();
        Form_Factor = in.readString();
    }

    public static final Creator<Storage> CREATOR = new Creator<Storage>() {
        @Override
        public Storage createFromParcel(Parcel in) {
            return new Storage(in);
        }

        @Override
        public Storage[] newArray(int size) {
            return new Storage[size];
        }
    };

    public int getId_storage() {
        return id_storage;
    }

    public void setId_storage(int id_storage) {
        this.id_storage = id_storage;
    }

    public int getHarga_Storage() {
        return Harga_Storage;
    }

    public void setHarga_Storage(int harga_Storage) {
        Harga_Storage = harga_Storage;
    }

    public int getSize_Storage() {
        return Size_Storage;
    }

    public void setSize_Storage(int size_Storage) {
        Size_Storage = size_Storage;
    }

    public String getNama_Storage() {
        return Nama_Storage;
    }

    public void setNama_Storage(String nama_Storage) {
        Nama_Storage = nama_Storage;
    }

    public String getStorage_Type() {
        return Storage_Type;
    }

    public void setStorage_Type(String storage_Type) {
        Storage_Type = storage_Type;
    }

    public String getForm_Factor() {
        return Form_Factor;
    }

    public void setForm_Factor(String form_Factor) {
        Form_Factor = form_Factor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_storage);
        dest.writeInt(Harga_Storage);
        dest.writeInt(Size_Storage);
        dest.writeString(Nama_Storage);
        dest.writeString(Storage_Type);
        dest.writeString(Form_Factor);
    }
}
