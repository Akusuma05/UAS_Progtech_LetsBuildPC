package com.example.mainactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class mylist_adapter extends RecyclerView.Adapter<mylist_adapter.Viewholder> {

    private ArrayList<CPU> listCPU;
    private ArrayList<CPU_Cooler> listCPU_Cooler;
    private ArrayList<GPU> listGPU;
    private ArrayList<Memory> listMemory;
    private ArrayList<Motherboard> listMotherboard;
    private ArrayList<PSU> listPSU;
    private ArrayList<Storage> listStorage;
    private ArrayList<Casepc> listCasePC;
    private OnCardListener cardListener;

    public mylist_adapter(ArrayList<CPU> listCPU, ArrayList<CPU_Cooler> listCPU_Cooler, ArrayList<GPU> listGPU, ArrayList<Memory> listMemory, ArrayList<Motherboard> listMotherboard, ArrayList<PSU> listPSU, ArrayList<Storage> listStorage, ArrayList<Casepc> listCasePC, OnCardListener cardListener) {
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
    public mylist_adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_edit_component, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mylist_adapter.Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(@NonNull  View itemView) {
            super(itemView);
            //type_component =
        }
    }
}
