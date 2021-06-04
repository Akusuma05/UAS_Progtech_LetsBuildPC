package com.example.mainactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.CPU;
import model.CPU_Cooler;
import model.Casepc;
import model.GPU;
import model.Memory;
import model.Motherboard;
import model.PSU;
import model.Storage;
import model.componenttypesimpen;

public class pilihcomponentadapter extends RecyclerView.Adapter<pilihcomponentadapter.ViewHolder> {

    private ArrayList<CPU> listCPU;
    private ArrayList<CPU_Cooler> listCPU_Cooler;
    private ArrayList<GPU> listGPU;
    private ArrayList<Memory> listMemory;
    private ArrayList<Motherboard> listMotherboard;
    private ArrayList<PSU> listPSU;
    private ArrayList<Storage> listStorage;
    private ArrayList<Casepc> listCasePC;
    private OnCardListener cardListener;
    private String tipe = componenttypesimpen.tipepilihcomponent;

    public pilihcomponentadapter(ArrayList<CPU> listCPU, ArrayList<CPU_Cooler> listCPU_Cooler, ArrayList<GPU> listGPU, ArrayList<Memory> listMemory, ArrayList<Motherboard> listMotherboard, ArrayList<PSU> listPSU, ArrayList<Storage> listStorage, ArrayList<Casepc> listCasePC, OnCardListener cardListener) {
        this.listCPU = listCPU;
        this.listCPU_Cooler = listCPU_Cooler;
        this.listGPU = listGPU;
        this.listMemory = listMemory;
        this.listMotherboard = listMotherboard;
        this.listPSU = listPSU;
        this.listStorage = listStorage;
        this.listCasePC = listCasePC;
        this.cardListener = cardListener;
    }

    @NonNull
    @Override
    public pilihcomponentadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_pilihcomponen, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull pilihcomponentadapter.ViewHolder holder, int position) {
        if (tipe.equals("CPU")){
            holder.pilihkomponentextview1.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview2.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview3.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview4.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview5.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview6.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview7.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview8.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview9.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview10.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview11.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview12.setVisibility(View.VISIBLE);

            holder.pilihkomponentextview13.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview14.setVisibility(View.INVISIBLE);

            holder.pilihkomponentextview1.setText("Nama CPU");
            holder.pilihkomponentextview2.setText(listCPU.get(position).getNama_CPU());
            holder.pilihkomponentextview3.setText("Core Count");
            holder.pilihkomponentextview4.setText(String.valueOf(listCPU.get(position).getCore_Count()));
            holder.pilihkomponentextview5.setText("Core Clock");
            holder.pilihkomponentextview6.setText(String.valueOf(listCPU.get(position).getCore_Clock()));
            holder.pilihkomponentextview7.setText("TDP");
            holder.pilihkomponentextview8.setText(String.valueOf(listCPU.get(position).getTDP()));
            holder.pilihkomponentextview9.setText("Socket");
            holder.pilihkomponentextview10.setText(listCPU.get(position).getSocket());
            holder.pilihkomponentextview11.setText("Harga");
            holder.pilihkomponentextview12.setText(String.valueOf(listCPU.get(position).getHarga()));

        }else if(tipe.equals("CPUCooler")){
            holder.pilihkomponentextview1.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview2.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview3.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview4.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview5.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview6.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview7.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview8.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview9.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview10.setVisibility(View.VISIBLE);

            holder.pilihkomponentextview11.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview12.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview13.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview14.setVisibility(View.INVISIBLE);

            holder.pilihkomponentextview1.setText("Nama Cooler");
            holder.pilihkomponentextview2.setText(listCPU_Cooler.get(position).getNama_Cooler());
            holder.pilihkomponentextview3.setText("Cooler Type");
            holder.pilihkomponentextview4.setText(listCPU_Cooler.get(position).getCooler_Type());
            holder.pilihkomponentextview5.setText("Fan RPM");
            holder.pilihkomponentextview6.setText(String.valueOf(listCPU_Cooler.get(position).getFan_RPM()));
            holder.pilihkomponentextview7.setText("Noise Level");
            holder.pilihkomponentextview8.setText(String.valueOf(listCPU_Cooler.get(position).getNoise_Level()));
            holder.pilihkomponentextview9.setText("Harga");
            holder.pilihkomponentextview10.setText(String.valueOf(listCPU_Cooler.get(position).getHarga_Cooler()));
        }else if(tipe.equals("Memory")){
            holder.pilihkomponentextview1.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview2.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview3.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview4.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview5.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview6.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview7.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview8.setVisibility(View.VISIBLE);

            holder.pilihkomponentextview9.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview10.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview11.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview12.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview13.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview14.setVisibility(View.INVISIBLE);

            holder.pilihkomponentextview1.setText("Nama Memory");
            holder.pilihkomponentextview2.setText(listMemory.get(position).getNama_Memory());
            holder.pilihkomponentextview3.setText("Size");
            holder.pilihkomponentextview4.setText(listMemory.get(position).getSize());
            holder.pilihkomponentextview5.setText("Speed");
            holder.pilihkomponentextview6.setText(String.valueOf(listMemory.get(position).getSpeed()));
            holder.pilihkomponentextview7.setText("Harga");
            holder.pilihkomponentextview8.setText(String.valueOf(listMemory.get(position).getHarga()));

        }else if(tipe.equals("Motherboard")){
            holder.pilihkomponentextview1.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview2.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview3.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview4.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview5.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview6.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview7.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview8.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview9.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview10.setVisibility(View.VISIBLE);

            holder.pilihkomponentextview11.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview12.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview13.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview14.setVisibility(View.INVISIBLE);

            holder.pilihkomponentextview1.setText("Nama");
            holder.pilihkomponentextview2.setText(listMotherboard.get(position).getNama_Motherboard());
            holder.pilihkomponentextview3.setText("Form Factor");
            holder.pilihkomponentextview4.setText(listMotherboard.get(position).getForm_Factor());
            holder.pilihkomponentextview5.setText("Chipset");
            holder.pilihkomponentextview6.setText(listMotherboard.get(position).getChipset());
            holder.pilihkomponentextview7.setText("Socket");
            holder.pilihkomponentextview8.setText(listMotherboard.get(position).getSocket());
            holder.pilihkomponentextview9.setText("Harga");
            holder.pilihkomponentextview10.setText(String.valueOf(listMotherboard.get(position).getHarga_Motherboard()));

        }else if(tipe.equals("Storage")){
            holder.pilihkomponentextview1.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview2.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview3.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview4.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview5.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview6.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview7.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview8.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview9.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview10.setVisibility(View.VISIBLE);

            holder.pilihkomponentextview11.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview12.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview13.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview14.setVisibility(View.INVISIBLE);

            holder.pilihkomponentextview1.setText("Nama Storage");
            holder.pilihkomponentextview2.setText(listStorage.get(position).getNama_Storage());
            holder.pilihkomponentextview3.setText("Storage Type");
            holder.pilihkomponentextview4.setText(listStorage.get(position).getStorage_Type());
            holder.pilihkomponentextview5.setText("Form Factor");
            holder.pilihkomponentextview6.setText(listStorage.get(position).getForm_Factor());
            holder.pilihkomponentextview7.setText("Size Storage");
            holder.pilihkomponentextview8.setText(String.valueOf(listStorage.get(position).getSize_Storage()));
            holder.pilihkomponentextview9.setText("Harga");
            holder.pilihkomponentextview10.setText(String.valueOf(listStorage.get(position).getHarga_Storage()));

        }else if(tipe.equals("PSU")){
            holder.pilihkomponentextview1.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview2.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview3.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview4.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview5.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview6.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview7.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview8.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview9.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview10.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview11.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview12.setVisibility(View.VISIBLE);

            holder.pilihkomponentextview13.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview14.setVisibility(View.INVISIBLE);

            holder.pilihkomponentextview1.setText("Nama PSU");
            holder.pilihkomponentextview2.setText(listPSU.get(position).getNama_PSU());
            holder.pilihkomponentextview3.setText("Form Factor");
            holder.pilihkomponentextview4.setText(listPSU.get(position).getForm_Factor_PSU());
            holder.pilihkomponentextview5.setText("Modular");
            holder.pilihkomponentextview6.setText(listPSU.get(position).getModular());
            holder.pilihkomponentextview7.setText("Efficiency Rating");
            holder.pilihkomponentextview8.setText(listPSU.get(position).getEfficiency_Rating());
            holder.pilihkomponentextview9.setText("Wattage");
            holder.pilihkomponentextview10.setText(String.valueOf(listPSU.get(position).getWattage_PSU()));
            holder.pilihkomponentextview11.setText("Harga");
            holder.pilihkomponentextview12.setText(String.valueOf(listPSU.get(position).getHarga_PSU()));

        }else if(tipe.equals("GPU")){
            holder.pilihkomponentextview1.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview2.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview3.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview4.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview5.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview6.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview7.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview8.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview9.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview10.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview11.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview12.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview13.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview14.setVisibility(View.VISIBLE);

            holder.pilihkomponentextview1.setText("Nama GPU");
            holder.pilihkomponentextview2.setText(listGPU.get(position).getNama_GPU());
            holder.pilihkomponentextview3.setText("Core Clock");
            holder.pilihkomponentextview4.setText(String.valueOf(listGPU.get(position).getCore_Clock_GPU()));
            holder.pilihkomponentextview5.setText("Boost Clock");
            holder.pilihkomponentextview6.setText(String.valueOf(listGPU.get(position).getBoost_Clock_GPU()));
            holder.pilihkomponentextview7.setText("Memory");
            holder.pilihkomponentextview8.setText(String.valueOf(listGPU.get(position).getMemory_GPU()));
            holder.pilihkomponentextview9.setText("TDP");
            holder.pilihkomponentextview10.setText(String.valueOf(listGPU.get(position).getTDP_GPU()));
            holder.pilihkomponentextview11.setText("Chipset");
            holder.pilihkomponentextview12.setText(listGPU.get(position).getChipset_GPU());
            holder.pilihkomponentextview13.setText("Harga");
            holder.pilihkomponentextview14.setText(String.valueOf(listGPU.get(position).getHarga_GPU()));
        }else if(tipe.equals("Case")){
            holder.pilihkomponentextview1.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview2.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview3.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview4.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview5.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview6.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview7.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview8.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview9.setVisibility(View.VISIBLE);
            holder.pilihkomponentextview10.setVisibility(View.VISIBLE);

            holder.pilihkomponentextview11.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview12.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview13.setVisibility(View.INVISIBLE);
            holder.pilihkomponentextview14.setVisibility(View.INVISIBLE);

            holder.pilihkomponentextview1.setText("Nama");
            holder.pilihkomponentextview2.setText(listCasePC.get(position).getNama_Case());
            holder.pilihkomponentextview3.setText("Form Factor Case");
            holder.pilihkomponentextview4.setText(listCasePC.get(position).getForm_Factor_Case());
            holder.pilihkomponentextview5.setText("Side Panel Windows");
            holder.pilihkomponentextview6.setText(listCasePC.get(position).getSide_Panel_Windows());
            holder.pilihkomponentextview7.setText("Color");
            holder.pilihkomponentextview8.setText(listCasePC.get(position).getColor());
            holder.pilihkomponentextview9.setText("Harga");
            holder.pilihkomponentextview10.setText(String.valueOf(listCasePC.get(position).getHarga_Case()));
        }
    }

    @Override
    public int getItemCount() {
        int size = 0;
        if (tipe.equals("CPU")){
            size = listCPU.size();
        }else if(tipe.equals("CPUCooler")){
            size = listCPU_Cooler.size();
        }else if(tipe.equals("Memory")){
            size = listMemory.size();
        }else if(tipe.equals("Motherboard")){
            size = listMotherboard.size();
        }else if(tipe.equals("Storage")){
            size = listStorage.size();
        }else if(tipe.equals("PSU")){
            size = listPSU.size();
        }else if(tipe.equals("GPU")){
            size = listGPU.size();
        }else if(tipe.equals("Case")){
            size = listCasePC.size();
        }
        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView pilihkomponentextview1,pilihkomponentextview2,pilihkomponentextview3,pilihkomponentextview4,pilihkomponentextview5,pilihkomponentextview6,pilihkomponentextview7,
                         pilihkomponentextview8,pilihkomponentextview9,pilihkomponentextview10,pilihkomponentextview11,pilihkomponentextview12,pilihkomponentextview13,pilihkomponentextview14;
        private Button Add_pilih_komponen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pilihkomponentextview1 = itemView.findViewById(R.id.pilihkomponentextview1);
            pilihkomponentextview2 = itemView.findViewById(R.id.pilihkomponentextview2);
            pilihkomponentextview3 = itemView.findViewById(R.id.pilihkomponentextview3);
            pilihkomponentextview4 = itemView.findViewById(R.id.pilihkomponentextview4);
            pilihkomponentextview5 = itemView.findViewById(R.id.pilihkomponentextview5);
            pilihkomponentextview6 = itemView.findViewById(R.id.pilihkomponentextview6);
            pilihkomponentextview7 = itemView.findViewById(R.id.pilihkomponentextview7);
            pilihkomponentextview8 = itemView.findViewById(R.id.pilihkomponentextview8);
            pilihkomponentextview9 = itemView.findViewById(R.id.pilihkomponentextview9);
            pilihkomponentextview10 = itemView.findViewById(R.id.pilihkomponentextview10);
            pilihkomponentextview11 = itemView.findViewById(R.id.pilihkomponentextview11);
            pilihkomponentextview12 = itemView.findViewById(R.id.pilihkomponentextview12);
            pilihkomponentextview13 = itemView.findViewById(R.id.pilihkomponentextview13);
            pilihkomponentextview14 = itemView.findViewById(R.id.pilihkomponentextview14);

            Add_pilih_komponen = itemView.findViewById(R.id.Add_pilih_komponen);

            Add_pilih_komponen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cardListener.onCardClick(getAdapterPosition());
                }
            });
        }
    }
}
