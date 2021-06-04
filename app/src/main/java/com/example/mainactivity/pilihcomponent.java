package com.example.mainactivity;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

public class pilihcomponent extends Fragment implements OnCardListener {

    private String tipe = componenttypesimpen.tipepilihcomponent;
    private RecyclerView RecyclerView_pilih_component;
    private pilihcomponentadapter adapter;
    private ArrayList<CPU> listCPU;
    private ArrayList<CPU_Cooler> listCPU_Cooler;
    private ArrayList<GPU> listGPU;
    private ArrayList<Memory> listMemory;
    private ArrayList<Motherboard> listMotherboard;
    private ArrayList<PSU> listPSU;
    private ArrayList<Storage> listStorage;
    private ArrayList<Casepc> listCasePC;
    private OnCardListener cardListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pilihcomponent, container, false);

        //Deklarasi
        RecyclerView_pilih_component = v.findViewById(R.id.RecyclerView_pilih_component);
        listCPU = new ArrayList<CPU>();
        listCPU_Cooler = new ArrayList<CPU_Cooler>();
        listGPU = new ArrayList<GPU>();
        listMemory = new ArrayList<Memory>();
        listMotherboard = new ArrayList<Motherboard>();
        listPSU = new ArrayList<PSU>();
        listStorage = new ArrayList<Storage>();
        listCasePC = new ArrayList<Casepc>();
        adapter = new pilihcomponentadapter(listCPU, listCPU_Cooler, listGPU, listMemory, listMotherboard, listPSU, listStorage, listCasePC, this);

        //Setup Recycler View
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        RecyclerView_pilih_component.setLayoutManager(manager);
        RecyclerView_pilih_component.setAdapter(adapter);

        //Dummy data
        listCPU.add(new CPU("intel i3", "LGA1200",1,8,200,100,100000));
        listCPU.add(new CPU("intel i5", "LGA1200",1,8,200,100,100000));
        listCPU.add(new CPU("intel i7", "LGA1200",1,8,200,100,100000));
        listCPU_Cooler.add(new CPU_Cooler("noctua", "aircooler", 1,1,1,1));
        adapter.notifyDataSetChanged();
        return v;
    }


    @Override
    public void onCardClick(int position) {

    }
}