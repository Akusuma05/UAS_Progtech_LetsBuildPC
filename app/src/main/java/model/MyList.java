package model;

import android.os.Parcel;
import android.os.Parcelable;

public class MyList implements Parcelable {
    private String CPU, CPU_Cooler, Motherboard, GPU, Casepc, PSU;
    private int id_computer, Memory_id, Storage_id, User_ID, Harga_Total;

    public MyList() {
        this.CPU = "";
        this.CPU_Cooler = "";
        Motherboard = "";
        this.GPU = "";
        Casepc = "";
        this.PSU = "";
        this.id_computer = 0;
        Memory_id = 0;
        Storage_id = 0;
        User_ID = 0;
        Harga_Total = 0;
    }

    public MyList(String CPU, String CPU_Cooler, String motherboard, String GPU, String casepc, String PSU, int memory_id, int storage_id, int user_ID, int harga_Total) {
        this.CPU = CPU;
        this.CPU_Cooler = CPU_Cooler;
        Motherboard = motherboard;
        this.GPU = GPU;
        Casepc = casepc;
        this.PSU = PSU;
        Memory_id = memory_id;
        Storage_id = storage_id;
        User_ID = user_ID;
        Harga_Total = harga_Total;


    }

    protected MyList(Parcel in) {
        CPU = in.readString();
        CPU_Cooler = in.readString();
        Motherboard = in.readString();
        GPU = in.readString();
        Casepc = in.readString();
        PSU = in.readString();
        id_computer = in.readInt();
        Memory_id = in.readInt();
        Storage_id = in.readInt();
        User_ID = in.readInt();
        Harga_Total = in.readInt();
    }

    public static final Creator<MyList> CREATOR = new Creator<MyList>() {
        @Override
        public MyList createFromParcel(Parcel in) {
            return new MyList(in);
        }

        @Override
        public MyList[] newArray(int size) {
            return new MyList[size];
        }
    };

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getCPU_Cooler() {
        return CPU_Cooler;
    }

    public void setCPU_Cooler(String CPU_Cooler) {
        this.CPU_Cooler = CPU_Cooler;
    }

    public String getMotherboard() {
        return Motherboard;
    }

    public void setMotherboard(String motherboard) {
        Motherboard = motherboard;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getCasepc() {
        return Casepc;
    }

    public void setCasepc(String casepc) {
        Casepc = casepc;
    }

    public String getPSU() {
        return PSU;
    }

    public void setPSU(String PSU) {
        this.PSU = PSU;
    }

    public int getId_computer() {
        return id_computer;
    }

    public void setId_computer(int id_computer) {
        this.id_computer = id_computer;
    }

    public int getMemory_id() {
        return Memory_id;
    }

    public void setMemory_id(int memory_id) {
        Memory_id = memory_id;
    }

    public int getStorage_id() {
        return Storage_id;
    }

    public void setStorage_id(int storage_id) {
        Storage_id = storage_id;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public int getHarga_Total() {
        return Harga_Total;
    }

    public void setHarga_Total(int harga_Total) {
        Harga_Total = harga_Total;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(CPU);
        dest.writeString(CPU_Cooler);
        dest.writeString(Motherboard);
        dest.writeString(GPU);
        dest.writeString(Casepc);
        dest.writeString(PSU);
        dest.writeInt(id_computer);
        dest.writeInt(Memory_id);
        dest.writeInt(Storage_id);
        dest.writeInt(User_ID);
        dest.writeInt(Harga_Total);
    }
}
