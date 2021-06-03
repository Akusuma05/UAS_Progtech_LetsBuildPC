package com.example.mainactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import model.pickpc;
import model.pickpcArray;

public class addbuild extends Fragment {
    private ArrayList<pickpc> listpc = pickpcArray.pcpart;
    private TextView nama_cpu_build, harga_cpu_build, nama_cpucooler_build, harga_cpucooler_build, nama_Motherboard_build, harga_Motherboard_build, nama_Memory_build, harga_Memory_build,
            nama_Storage_build, harga_Storage_build, nama_GPU_build, harga_GPU_build, nama_Case_build, harga_Case_build, nama_PSU_build, harga_PSU_build, rpCPU, rpCPUCooler, rpMotherboard,
            rpMemory, rpStorage, rpGPU, rpCase, rpPSU;
    private Button button_add_CPU, button_add_CPUCooler, button_add_Motherboard, button_add_Memory, button_add_Storage, button_add_GPU, button_add_Case, button_add_PSU, button_save_build,
            button_edit_CPU, button_edit_CPUCooler, button_edit_Motherboard, button_edit_Memory, button_edit_GPU, button_edit_Case, button_edit_PSU, button_edit_Storage;
    private int id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_addbuild, container, false);

        //Deklarasi
        nama_cpu_build = v.findViewById(R.id.nama_cpu_build);
        harga_cpu_build = v.findViewById(R.id.harga_cpu_build);
        nama_cpucooler_build = v.findViewById(R.id.nama_cpucooler_build);
        harga_cpucooler_build = v.findViewById(R.id.harga_cpucooler_build);
        nama_Motherboard_build = v.findViewById(R.id.nama_Motherboard_build);
        harga_Motherboard_build = v.findViewById(R.id.harga_Motherboard_build);
        nama_Memory_build = v.findViewById(R.id.nama_Memory_build);
        harga_Memory_build = v.findViewById(R.id.harga_Memory_build);
        nama_Storage_build = v.findViewById(R.id.nama_Storage_build);
        harga_Storage_build = v.findViewById(R.id.harga_Storage_build);
        nama_GPU_build = v.findViewById(R.id.nama_GPU_build);
        harga_GPU_build = v.findViewById(R.id.harga_GPU_build);
        nama_Case_build = v.findViewById(R.id.nama_Case_build);
        harga_Case_build = v.findViewById(R.id.harga_Case_build);
        button_add_CPU = v.findViewById(R.id.button_add_CPU);
        nama_PSU_build = v.findViewById(R.id.nama_PSU_build);
        harga_PSU_build = v.findViewById(R.id.harga_PSU_build);

        button_edit_CPU = v.findViewById(R.id.button_edit_CPU);
        button_edit_CPUCooler = v.findViewById(R.id.button_edit_CPUCooler);
        button_edit_Motherboard = v.findViewById(R.id.button_edit_Motherboard);
        button_edit_Memory = v.findViewById(R.id.button_edit_Memory);
        button_edit_GPU = v.findViewById(R.id.button_edit_GPU);
        button_edit_Case = v.findViewById(R.id.button_edit_Case);
        button_edit_PSU = v.findViewById(R.id.button_edit_PSU);
        button_edit_Storage = v.findViewById(R.id.button_edit_Storage);
        button_save_build = v.findViewById(R.id.button_save_build);

        button_add_CPU = v.findViewById(R.id.button_add_CPU);
        button_add_CPUCooler = v.findViewById(R.id.button_add_CPUCooler);
        button_add_Motherboard = v.findViewById(R.id.button_add_Motherboard);
        button_add_Memory = v.findViewById(R.id.button_add_Memory);
        button_add_Storage = v.findViewById(R.id.button_add_Storage);
        button_add_GPU = v.findViewById(R.id.button_add_GPU);
        button_add_Case = v.findViewById(R.id.button_add_Case);
        button_add_PSU = v.findViewById(R.id.button_add_PSU);

        rpCPU = v.findViewById(R.id.rpCPU);
        rpCPUCooler = v.findViewById(R.id.rpCPUCooler);
        rpMotherboard = v.findViewById(R.id.rpMotherboard);
        rpMemory = v.findViewById(R.id.rpMemory);
        rpStorage = v.findViewById(R.id.rpStorage);
        rpGPU = v.findViewById(R.id.rpGPU);
        rpCase = v.findViewById(R.id.rpCase);
        rpPSU = v.findViewById(R.id.rpPSU);


        if (listpc.size() == 0){
            id = 1;
        }else{
            id = listpc.get(listpc.size()).getId()+1;
            pickpc list1 = new pickpc(id);
            listpc.add(list1);
        }

        //Main
        DisableTextView();
        addcpu();
        addcpucooler();
        addmotherboard();
        addgpu();
        addpsu();
        addstorage();
        addcase();
        addmemory();
        savebutton();

        return v;
    }

    private void DisableTextView() {
        if (listpc.size() == 0){
            //Text View
            nama_cpu_build.setVisibility(View.INVISIBLE);
            harga_cpu_build.setVisibility(View.INVISIBLE);
            nama_cpucooler_build.setVisibility(View.INVISIBLE);
            harga_cpucooler_build.setVisibility(View.INVISIBLE);
            nama_Motherboard_build.setVisibility(View.INVISIBLE);
            harga_Motherboard_build.setVisibility(View.INVISIBLE);
            nama_Memory_build.setVisibility(View.INVISIBLE);
            harga_Memory_build.setVisibility(View.INVISIBLE);
            nama_Storage_build.setVisibility(View.INVISIBLE);
            harga_Storage_build.setVisibility(View.INVISIBLE);
            nama_GPU_build.setVisibility(View.INVISIBLE);
            harga_GPU_build.setVisibility(View.INVISIBLE);
            nama_Case_build.setVisibility(View.INVISIBLE);
            harga_Case_build.setVisibility(View.INVISIBLE);
            nama_PSU_build.setVisibility(View.INVISIBLE);
            harga_PSU_build.setVisibility(View.INVISIBLE);

            rpCPU.setVisibility(View.INVISIBLE);
            rpCPUCooler.setVisibility(View.INVISIBLE);
            rpMotherboard.setVisibility(View.INVISIBLE);
            rpMemory.setVisibility(View.INVISIBLE);
            rpStorage.setVisibility(View.INVISIBLE);
            rpGPU.setVisibility(View.INVISIBLE);
            rpCase.setVisibility(View.INVISIBLE);
            rpPSU.setVisibility(View.INVISIBLE);

            //Button
            button_add_CPU.setVisibility(View.VISIBLE);
            button_add_CPUCooler.setVisibility(View.VISIBLE);
            button_add_Motherboard.setVisibility(View.VISIBLE);
            button_add_Memory.setVisibility(View.VISIBLE);
            button_add_Storage.setVisibility(View.VISIBLE);
            button_add_GPU.setVisibility(View.VISIBLE);
            button_add_Case.setVisibility(View.VISIBLE);
            button_add_PSU.setVisibility(View.VISIBLE);

            button_edit_CPU.setVisibility(View.INVISIBLE);
            button_edit_CPUCooler.setVisibility(View.INVISIBLE);
            button_edit_Motherboard.setVisibility(View.INVISIBLE);
            button_edit_Memory.setVisibility(View.INVISIBLE);
            button_edit_Storage.setVisibility(View.INVISIBLE);
            button_edit_GPU.setVisibility(View.INVISIBLE);
            button_edit_Case.setVisibility(View.INVISIBLE);
            button_edit_PSU.setVisibility(View.INVISIBLE);
        }else{
            pickpc templistpc = listpc.get(id-1);

            if(templistpc.getCPU()!=""){
                nama_cpu_build.setVisibility(View.VISIBLE);
                harga_cpu_build.setVisibility(View.VISIBLE);
                rpCPU.setVisibility(View.VISIBLE);
                button_edit_CPU.setVisibility(View.VISIBLE);
                button_add_CPU.setVisibility(View.INVISIBLE);

                nama_cpu_build.setText(templistpc.getCPU());
                harga_cpu_build.setText(templistpc.getHargaCPU());
            }

            if (templistpc.getCPU_Cooler()!=""){
                nama_cpucooler_build.setVisibility(View.VISIBLE);
                harga_cpucooler_build.setVisibility(View.VISIBLE);
                rpCPUCooler.setVisibility(View.VISIBLE);
                button_edit_CPUCooler.setVisibility(View.VISIBLE);
                button_add_CPUCooler.setVisibility(View.INVISIBLE);

                nama_cpu_build.setText(templistpc.getCPU_Cooler());
                harga_cpu_build.setText(templistpc.getHargaCPU_Cooler());
            }

            if (templistpc.getMotherboard()!=""){
                nama_Motherboard_build.setVisibility(View.VISIBLE);
                nama_Motherboard_build.setVisibility(View.VISIBLE);
                rpMotherboard.setVisibility(View.VISIBLE);
                button_edit_Motherboard.setVisibility(View.VISIBLE);
                button_add_Motherboard.setVisibility(View.INVISIBLE);

                nama_Motherboard_build.setText(templistpc.getMotherboard());
                harga_Motherboard_build.setText(templistpc.getHargaMotherboard());
            }

            if (templistpc.getMemory()!=""){
                nama_Memory_build.setVisibility(View.VISIBLE);
                nama_Memory_build.setVisibility(View.VISIBLE);
                rpMemory.setVisibility(View.VISIBLE);
                button_edit_Memory.setVisibility(View.VISIBLE);
                button_add_Memory.setVisibility(View.INVISIBLE);

                nama_Memory_build.setText(templistpc.getMemory());
                harga_Memory_build.setText(templistpc.getHargaMemory());
            }

            if (templistpc.getStorage()!=""){
                nama_Storage_build.setVisibility(View.VISIBLE);
                nama_Storage_build.setVisibility(View.VISIBLE);
                rpStorage.setVisibility(View.VISIBLE);
                button_edit_Storage.setVisibility(View.VISIBLE);
                button_add_Storage.setVisibility(View.INVISIBLE);

                nama_Storage_build.setText(templistpc.getStorage());
                harga_Storage_build.setText(templistpc.getHargaStorage());
            }

            if (templistpc.getGPU()!=""){
                nama_GPU_build.setVisibility(View.VISIBLE);
                nama_GPU_build.setVisibility(View.VISIBLE);
                rpGPU.setVisibility(View.VISIBLE);
                button_edit_GPU.setVisibility(View.VISIBLE);
                button_add_GPU.setVisibility(View.INVISIBLE);

                nama_GPU_build.setText(templistpc.getGPU());
                harga_GPU_build.setText(templistpc.getHargaGPU());
            }

            if (templistpc.getCase()!=""){
                nama_Case_build.setVisibility(View.VISIBLE);
                nama_Case_build.setVisibility(View.VISIBLE);
                rpCase.setVisibility(View.VISIBLE);
                button_edit_Case.setVisibility(View.VISIBLE);
                button_add_Case.setVisibility(View.INVISIBLE);

                nama_Case_build.setText(templistpc.getCase());
                harga_Case_build.setText(templistpc.getHargaCase());
            }
        }
    }

    private void addcpu() {
        button_add_CPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new componentlist();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void addcpucooler() {
        button_add_CPUCooler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new componentlist();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void addmemory() {
        button_add_Memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new componentlist();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void addmotherboard() {
        button_add_Motherboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new componentlist();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void addstorage() {
        button_add_Storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new componentlist();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void addpsu() {
        button_add_PSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new componentlist();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void addgpu() {
        button_add_GPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new componentlist();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void addcase() {
        button_add_Case.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new componentlist();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void savebutton() {

    }


}