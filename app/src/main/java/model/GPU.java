package model;

import android.os.Parcel;
import android.os.Parcelable;

public class GPU implements Parcelable {
    private int id_gpu, Core_Clock_GPU, Boost_Clock_GPU, Memory_GPU, TDP_GPU, Harga_GPU;
    private String Nama_GPU, Chipset_GPU;

    public GPU(int id_gpu, int core_Clock_GPU, int boost_Clock_GPU, int memory_GPU, int TDP_GPU, int harga_GPU, String nama_GPU, String chipset_GPU) {
        this.id_gpu = id_gpu;
        Core_Clock_GPU = core_Clock_GPU;
        Boost_Clock_GPU = boost_Clock_GPU;
        Memory_GPU = memory_GPU;
        this.TDP_GPU = TDP_GPU;
        Harga_GPU = harga_GPU;
        Nama_GPU = nama_GPU;
        Chipset_GPU = chipset_GPU;
    }

    public GPU() {
        this.id_gpu = 0;
        Core_Clock_GPU = 0;
        Boost_Clock_GPU = 0;
        Memory_GPU = 0;
        this.TDP_GPU = 0;
        Harga_GPU = 0;
        Nama_GPU = "";
        Chipset_GPU = "";
    }

    protected GPU(Parcel in) {
        id_gpu = in.readInt();
        Core_Clock_GPU = in.readInt();
        Boost_Clock_GPU = in.readInt();
        Memory_GPU = in.readInt();
        TDP_GPU = in.readInt();
        Harga_GPU = in.readInt();
        Nama_GPU = in.readString();
        Chipset_GPU = in.readString();
    }

    public static final Creator<GPU> CREATOR = new Creator<GPU>() {
        @Override
        public GPU createFromParcel(Parcel in) {
            return new GPU(in);
        }

        @Override
        public GPU[] newArray(int size) {
            return new GPU[size];
        }
    };

    public int getId_gpu() {
        return id_gpu;
    }

    public void setId_gpu(int id_gpu) {
        this.id_gpu = id_gpu;
    }

    public int getCore_Clock_GPU() {
        return Core_Clock_GPU;
    }

    public void setCore_Clock_GPU(int core_Clock_GPU) {
        Core_Clock_GPU = core_Clock_GPU;
    }

    public int getBoost_Clock_GPU() {
        return Boost_Clock_GPU;
    }

    public void setBoost_Clock_GPU(int boost_Clock_GPU) {
        Boost_Clock_GPU = boost_Clock_GPU;
    }

    public int getMemory_GPU() {
        return Memory_GPU;
    }

    public void setMemory_GPU(int memory_GPU) {
        Memory_GPU = memory_GPU;
    }

    public int getTDP_GPU() {
        return TDP_GPU;
    }

    public void setTDP_GPU(int TDP_GPU) {
        this.TDP_GPU = TDP_GPU;
    }

    public int getHarga_GPU() {
        return Harga_GPU;
    }

    public void setHarga_GPU(int harga_GPU) {
        Harga_GPU = harga_GPU;
    }

    public String getNama_GPU() {
        return Nama_GPU;
    }

    public void setNama_GPU(String nama_GPU) {
        Nama_GPU = nama_GPU;
    }

    public String getChipset_GPU() {
        return Chipset_GPU;
    }

    public void setChipset_GPU(String chipset_GPU) {
        Chipset_GPU = chipset_GPU;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_gpu);
        dest.writeInt(Core_Clock_GPU);
        dest.writeInt(Boost_Clock_GPU);
        dest.writeInt(Memory_GPU);
        dest.writeInt(TDP_GPU);
        dest.writeInt(Harga_GPU);
        dest.writeString(Nama_GPU);
        dest.writeString(Chipset_GPU);
    }
}
