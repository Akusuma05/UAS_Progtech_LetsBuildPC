package com.example.mainactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

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

public class spinner_adapter extends RecyclerView.Adapter<spinner_adapter.SpinnerViewHolder> {

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

    public spinner_adapter(ArrayList<CPU> listCPU, ArrayList<CPU_Cooler> listCPU_Cooler, ArrayList<GPU> listGPU, ArrayList<Memory> listMemory, ArrayList<Motherboard> listMotherboard, ArrayList<PSU> listPSU, ArrayList<Storage> listStorage, ArrayList<Casepc> listCasePC, OnCardListener cardListener) {
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
    public SpinnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_more_component, parent, false);
        return new SpinnerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull spinner_adapter.SpinnerViewHolder holder, int position) {
        if (tipe.equals("CPU")) {

            holder.tipe_more_component.setText(listCPU.get(position).getNama_CPU());
            holder.harga_more_component.setText(String.valueOf(listCPU.get(position).getHarga()));
        }
        else if (tipe.equals("CPU cooler")) {

            holder.tipe_more_component.setText(listCPU_Cooler.get(position).getNama_Cooler());
            holder.harga_more_component.setText(String.valueOf(listCPU_Cooler.get(position).getHarga_Cooler()));
        }
        else if (tipe.equals("GPU")){

            holder.tipe_more_component.setText(listGPU.get(position).getNama_GPU());
            holder.harga_more_component.setText(String.valueOf(listGPU.get(position).getHarga_GPU()));
        }
        else if (tipe.equals("Memory")){

            holder.tipe_more_component.setText(listMemory.get(position).getNama_Memory());
            holder.harga_more_component.setText(String.valueOf(listMemory.get(position).getHarga()));
        }
        else if (tipe.equals("Motherboard")){

            holder.tipe_more_component.setText(listMotherboard.get(position).getNama_Motherboard());
            holder.harga_more_component.setText(String.valueOf(listMotherboard.get(position).getHarga_Motherboard()));
        }
        else if (tipe.equals("PSU")) {

            holder.tipe_more_component.setText(listPSU.get(position).getNama_PSU());
            holder.harga_more_component.setText(String.valueOf(listPSU.get(position).getHarga_PSU()));
        }
        else if (tipe.equals("Storage")) {

            holder.tipe_more_component.setText(listStorage.get(position).getNama_Storage());
            holder.harga_more_component.setText(String.valueOf(listStorage.get(position).getHarga_Storage()));
        }
        else if (tipe.equals("Case")){

            holder.tipe_more_component.setText(listCasePC.get(position).getNama_Case());
            holder.harga_more_component.setText(String.valueOf(listCasePC.get(position).getHarga_Case()));
        }
    }

    @Override
    public int getItemCount() {
        int size = 0;
        if (tipe.equals("CPU")){
            size = listCPU.size();
        }else if(tipe.equals("CPU cooler")){
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

    public class SpinnerViewHolder extends RecyclerView.ViewHolder {
        private TextView tipe_more_component, harga_more_component;
        private CardView CardView_more_component;

        public SpinnerViewHolder(@NonNull View itemView) {
            super(itemView);
            tipe_more_component = itemView.findViewById(R.id.tipe_more_component);
            harga_more_component = itemView.findViewById(R.id.harga_more_component);
            CardView_more_component = itemView.findViewById(R.id.CardView_more_component);

            CardView_more_component.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        cardListener.onCardClick(getAdapterPosition());
                    }
            });
        }
    }
}

