package com.example.mainactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import model.CPU;
import model.MyList;
import model.componenttype;
import model.componenttypesimpen;

public class addbuild extends Fragment {
    private ArrayList<MyList> listpc = new ArrayList<MyList>();
    private TextView nama_cpu_build, harga_cpu_build, nama_cpucooler_build, harga_cpucooler_build, nama_Motherboard_build, harga_Motherboard_build, nama_Memory_build, harga_Memory_build,
            nama_Storage_build, harga_Storage_build, nama_GPU_build, harga_GPU_build, nama_Case_build, harga_Case_build, nama_PSU_build, harga_PSU_build, rpCPU, rpCPUCooler, rpMotherboard,
            rpMemory, rpStorage, rpGPU, rpCase, rpPSU;
    private Button button_add_CPU, button_add_CPUCooler, button_add_Motherboard, button_add_Memory, button_add_Storage, button_add_GPU, button_add_Case, button_add_PSU, button_save_build,
            button_edit_CPU, button_edit_CPUCooler, button_edit_Motherboard, button_edit_Memory, button_edit_GPU, button_edit_Case, button_edit_PSU, button_edit_Storage;
    private int id;
    private String type;

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


        //Main
        Readmylist();
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

    private void Readmylist() {
        String url ="http://192.168.1.14/letsbuildpc/readmylist.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonmylist = response.getJSONArray("cpu");
                            for (int i = 0; i < jsonmylist.length(); i++){
                                JSONObject objcpu = jsonmylist.getJSONObject(i);
                                MyList myList = new MyList();
                                myList.setId_computer(objcpu.getInt("id_computer"));
                                myList.setCPU(objcpu.getString("CPU"));
                                myList.setCPU_Cooler(objcpu.getString("CPU_Cooler"));
                                myList.setMotherboard(objcpu.getString("Motherboard"));
                                myList.setMemory_id(objcpu.getInt("Memory_id"));
                                myList.setGPU(objcpu.getString("GPU"));
                                myList.setCasepc(objcpu.getString("Casepc"));
                                myList.setPSU(objcpu.getString("PSU"));
                                myList.setUser_ID(objcpu.getInt("User_id"));
                                myList.setHarga_Total(objcpu.getInt("Harga_Total"));
                                listpc.add(myList);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );
        myQueue.add(request);
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
            for (int i = 0; i < listpc.size(); i++){
                MyList templistpc = listpc.get(i);
                if (templistpc.getUser_ID() == )
            }

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
                componenttype componenttype = new componenttype("CPU");
                componenttypesimpen.tipepilihcomponent = "CPU";
                Fragment fragment = new pilihcomponent();
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
                componenttype componenttype = new componenttype("CPUCooler");
                componenttypesimpen.tipepilihcomponent = "CPUCooler";
                Fragment fragment = new pilihcomponent();
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
                componenttype componenttype = new componenttype("Memory");
                componenttypesimpen.tipepilihcomponent = "Memory";
                Fragment fragment = new pilihcomponent();
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
                componenttype componenttype = new componenttype("Motherboard");
                componenttypesimpen.tipepilihcomponent = "Motherboard";
                Fragment fragment = new pilihcomponent();
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
                componenttype componenttype = new componenttype("Storage");
                componenttypesimpen.tipepilihcomponent = "Storage";
                Fragment fragment = new pilihcomponent();
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
                componenttype componenttype = new componenttype("PSU");
                componenttypesimpen.tipepilihcomponent = "PSU";
                Fragment fragment = new pilihcomponent();
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
                componenttype componenttype = new componenttype("GPU");
                componenttypesimpen.tipepilihcomponent = "GPU";
                Fragment fragment = new pilihcomponent();
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
                componenttype componenttype = new componenttype("Case");
                componenttypesimpen.tipepilihcomponent = "Case";
                Fragment fragment = new pilihcomponent();
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