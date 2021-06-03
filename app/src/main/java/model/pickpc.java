package model;

import android.os.Parcel;
import android.os.Parcelable;

public class pickpc implements Parcelable {
    private int id, hargaCPU, hargaCPU_Cooler, hargaMotherboard, hargaMemory, hargaStorage, hargaGPU, hargaCase, hargaPSU;
    private String CPU, CPU_Cooler, Motherboard, Memory, Storage, GPU, Case, PSU;

    public pickpc(int id, int hargaCPU, int hargaCPU_Cooler, int hargaMotherboard, int hargaMemory, int hargaStorage, int hargaGPU, int hargaCase, int hargaPSU, String CPU, String CPU_Cooler, String motherboard, String memory, String storage, String GPU, String aCase, String PSU) {
        this.id = id;
        this.hargaCPU = hargaCPU;
        this.hargaCPU_Cooler = hargaCPU_Cooler;
        this.hargaMotherboard = hargaMotherboard;
        this.hargaMemory = hargaMemory;
        this.hargaStorage = hargaStorage;
        this.hargaGPU = hargaGPU;
        this.hargaCase = hargaCase;
        this.hargaPSU = hargaPSU;
        this.CPU = CPU;
        this.CPU_Cooler = CPU_Cooler;
        Motherboard = motherboard;
        Memory = memory;
        Storage = storage;
        this.GPU = GPU;
        Case = aCase;
        this.PSU = PSU;
    }

    public pickpc() {
        this.id = 0;
        this.hargaCPU = 0;
        this.hargaCPU_Cooler = 0;
        this.hargaMotherboard = 0;
        this.hargaMemory = 0;
        this.hargaStorage = 0;
        this.hargaGPU = 0;
        this.hargaCase = 0;
        this.hargaPSU = 0;
        this.CPU = "";
        this.CPU_Cooler = "";
        Motherboard = "";
        Memory = "";
        Storage = "";
        this.GPU = "";
        Case = "";
        this.PSU = "";
    }

    public pickpc(int id) {
        this.id = id;
        this.hargaCPU = 0;
        this.hargaCPU_Cooler = 0;
        this.hargaMotherboard = 0;
        this.hargaMemory = 0;
        this.hargaStorage = 0;
        this.hargaGPU = 0;
        this.hargaCase = 0;
        this.hargaPSU = 0;
        this.CPU = "";
        this.CPU_Cooler = "";
        Motherboard = "";
        Memory = "";
        Storage = "";
        this.GPU = "";
        Case = "";
        this.PSU = "";
    }

    protected pickpc(Parcel in) {
        id = in.readInt();
        hargaCPU = in.readInt();
        hargaCPU_Cooler = in.readInt();
        hargaMotherboard = in.readInt();
        hargaMemory = in.readInt();
        hargaStorage = in.readInt();
        hargaGPU = in.readInt();
        hargaCase = in.readInt();
        hargaPSU = in.readInt();
        CPU = in.readString();
        CPU_Cooler = in.readString();
        Motherboard = in.readString();
        Memory = in.readString();
        Storage = in.readString();
        GPU = in.readString();
        Case = in.readString();
        PSU = in.readString();
    }

    public static final Creator<pickpc> CREATOR = new Creator<pickpc>() {
        @Override
        public pickpc createFromParcel(Parcel in) {
            return new pickpc(in);
        }

        @Override
        public pickpc[] newArray(int size) {
            return new pickpc[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHargaCPU() {
        return hargaCPU;
    }

    public void setHargaCPU(int hargaCPU) {
        this.hargaCPU = hargaCPU;
    }

    public int getHargaCPU_Cooler() {
        return hargaCPU_Cooler;
    }

    public void setHargaCPU_Cooler(int hargaCPU_Cooler) {
        this.hargaCPU_Cooler = hargaCPU_Cooler;
    }

    public int getHargaMotherboard() {
        return hargaMotherboard;
    }

    public void setHargaMotherboard(int hargaMotherboard) {
        this.hargaMotherboard = hargaMotherboard;
    }

    public int getHargaMemory() {
        return hargaMemory;
    }

    public void setHargaMemory(int hargaMemory) {
        this.hargaMemory = hargaMemory;
    }

    public int getHargaStorage() {
        return hargaStorage;
    }

    public void setHargaStorage(int hargaStorage) {
        this.hargaStorage = hargaStorage;
    }

    public int getHargaGPU() {
        return hargaGPU;
    }

    public void setHargaGPU(int hargaGPU) {
        this.hargaGPU = hargaGPU;
    }

    public int getHargaCase() {
        return hargaCase;
    }

    public void setHargaCase(int hargaCase) {
        this.hargaCase = hargaCase;
    }

    public int getHargaPSU() {
        return hargaPSU;
    }

    public void setHargaPSU(int hargaPSU) {
        this.hargaPSU = hargaPSU;
    }

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

    public String getMemory() {
        return Memory;
    }

    public void setMemory(String memory) {
        Memory = memory;
    }

    public String getStorage() {
        return Storage;
    }

    public void setStorage(String storage) {
        Storage = storage;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getCase() {
        return Case;
    }

    public void setCase(String aCase) {
        Case = aCase;
    }

    public String getPSU() {
        return PSU;
    }

    public void setPSU(String PSU) {
        this.PSU = PSU;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(hargaCPU);
        dest.writeInt(hargaCPU_Cooler);
        dest.writeInt(hargaMotherboard);
        dest.writeInt(hargaMemory);
        dest.writeInt(hargaStorage);
        dest.writeInt(hargaGPU);
        dest.writeInt(hargaCase);
        dest.writeInt(hargaPSU);
        dest.writeString(CPU);
        dest.writeString(CPU_Cooler);
        dest.writeString(Motherboard);
        dest.writeString(Memory);
        dest.writeString(Storage);
        dest.writeString(GPU);
        dest.writeString(Case);
        dest.writeString(PSU);
    }
}
