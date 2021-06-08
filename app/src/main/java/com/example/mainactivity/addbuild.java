package com.example.mainactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.CPU;
import model.CPU_Cooler;
import model.Casepc;
import model.GPU;
import model.Memory;
import model.Motherboard;
import model.MyList;
import model.PSU;
import model.Storage;
import model.casepcsimpen;
import model.componenttype;
import model.componenttypesimpen;
import model.cpucoolersimpen;
import model.cpusimpen;
import model.gpusimpen;
import model.idpartsimpen;
import model.memorysimpen;
import model.motherboardsimpen;
import model.psusimpen;
import model.storagesimpen;
import model.user;
import model.userIDsimpen;

public class addbuild extends Fragment {
    private ArrayList<CPU> listCPU;
    private ArrayList<CPU_Cooler> listCPU_Cooler;
    private ArrayList<GPU> listGPU;
    private ArrayList<Memory> listMemory;
    private ArrayList<Motherboard> listMotherboard;
    private ArrayList<PSU> listPSU;
    private ArrayList<Storage> listStorage;
    private ArrayList<Casepc> listCasePC;
    private ArrayList<MyList> listpc = new ArrayList<MyList>();
    private TextView nama_cpu_build, harga_cpu_build, nama_cpucooler_build, harga_cpucooler_build, nama_Motherboard_build, harga_Motherboard_build, nama_Memory_build, harga_Memory_build,
            nama_Storage_build, harga_Storage_build, nama_GPU_build, harga_GPU_build, nama_Case_build, harga_Case_build, nama_PSU_build, harga_PSU_build, rpCPU, rpCPUCooler, rpMotherboard,
            rpMemory, rpStorage, rpGPU, rpCase, rpPSU;
    private Button button_add_CPU, button_add_CPUCooler, button_add_Motherboard, button_add_Memory, button_add_Storage, button_add_GPU, button_add_Case, button_add_PSU, button_save_build,
            button_edit_CPU, button_edit_CPUCooler, button_edit_Motherboard, button_edit_Memory, button_edit_GPU, button_edit_Case, button_edit_PSU, button_edit_Storage;
    private int id = idpartsimpen.idpartsimpen;
    private int hargatotal = 0;
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

        listCPU = new ArrayList<CPU>();
        listCPU_Cooler = new ArrayList<CPU_Cooler>();
        listGPU = new ArrayList<GPU>();
        listMemory = new ArrayList<Memory>();
        listMotherboard = new ArrayList<Motherboard>();
        listPSU = new ArrayList<PSU>();
        listStorage = new ArrayList<Storage>();
        listCasePC = new ArrayList<Casepc>();


        //Main
        Readmylist();
        loadCPUdata();
        loadCPUCooler();
        loadGPU();
        loadmemory();
        loadmotherboard();
        loadPSU();
        loadStorage();
        loadCasepc();
        addcpu();
        addcpucooler();
        addmotherboard();
        addgpu();
        addpsu();
        addstorage();
        addcase();
        addmemory();
        editcpu();
        editcpucooler();
        editmotherboard();
        editgpu();
        editpsu();
        editstorage();
        editcase();
        editmemory();
        savebutton();

        return v;
    }

    private void editmemory() {
        button_edit_Memory.setOnClickListener(new View.OnClickListener() {
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

    private void editcase() {
        button_edit_Case.setOnClickListener(new View.OnClickListener() {
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

    private void editstorage() {
        button_edit_Storage.setOnClickListener(new View.OnClickListener() {
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

    private void editpsu() {
        button_edit_PSU.setOnClickListener(new View.OnClickListener() {
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

    private void editgpu() {
        button_edit_GPU.setOnClickListener(new View.OnClickListener() {
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

    private void editmotherboard() {
        button_edit_Motherboard.setOnClickListener(new View.OnClickListener() {
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

    private void editcpucooler() {
        button_edit_CPUCooler.setOnClickListener(new View.OnClickListener() {
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

    private void editcpu() {
        button_edit_CPU.setOnClickListener(new View.OnClickListener() {
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

    private void Readmylist() {
        String url = "http://192.168.1.14/letsbuildpc/readmylist.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonmylist = response.getJSONArray("cpu");
                            for (int i = 0; i < jsonmylist.length(); i++) {
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

    private void loadCPUdata() {
        String url = "http://192.168.1.14/letsbuildpc/readCPU.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsoncpu = response.getJSONArray("cpu");
                            for (int i = 0; i < jsoncpu.length(); i++) {
                                JSONObject objcpu = jsoncpu.getJSONObject(i);
                                CPU cpu = new CPU();
                                cpu.setId_CPU(objcpu.getInt("id_CPU"));
                                cpu.setNama_CPU(objcpu.getString("Nama_CPU"));
                                cpu.setCore_Count(objcpu.getInt("Core_Count"));
                                cpu.setCore_Clock(objcpu.getInt("Core_Clock"));
                                cpu.setTDP(objcpu.getInt("TDP"));
                                cpu.setSocket(objcpu.getString("Socket"));
                                cpu.setHarga(objcpu.getInt("Harga"));
                                listCPU.add(cpu);
                            }
                            if (cpusimpen.cpusimpen != "") {
                                nama_cpu_build.setVisibility(View.VISIBLE);
                                harga_cpu_build.setVisibility(View.VISIBLE);
                                rpCPU.setVisibility(View.VISIBLE);
                                button_edit_CPU.setVisibility(View.VISIBLE);
                                button_add_CPU.setVisibility(View.INVISIBLE);

                                nama_cpu_build.setText(cpusimpen.cpusimpen);
                                for (int i = 0; i < listCPU.size(); i++) {
                                    if (cpusimpen.cpusimpen.equals(listCPU.get(i).getNama_CPU())) ;
                                    harga_cpu_build.setText(String.valueOf(listCPU.get(i).getHarga()));
                                    hargatotal = hargatotal + listCPU.get(i).getHarga();
                                }
                            } else {
                                nama_cpu_build.setVisibility(View.INVISIBLE);
                                harga_cpu_build.setVisibility(View.INVISIBLE);
                                rpCPU.setVisibility(View.INVISIBLE);
                                button_add_CPU.setVisibility(View.VISIBLE);
                                button_edit_CPU.setVisibility(View.INVISIBLE);
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

    private void loadCPUCooler() {
        String url = "http://192.168.1.14/letsbuildpc/readcooler.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsoncpucooler = response.getJSONArray("cpu_cooler");
                            for (int i = 0; i < jsoncpucooler.length(); i++) {
                                JSONObject objcpucooler = jsoncpucooler.getJSONObject(i);
                                CPU_Cooler cooler = new CPU_Cooler();
                                cooler.setId_cpucooler(objcpucooler.getInt("id_cpucooler"));
                                cooler.setNama_Cooler(objcpucooler.getString("Nama_Cooler"));
                                cooler.setCooler_Type(objcpucooler.getString("Cooler_Type"));
                                cooler.setFan_RPM(objcpucooler.getInt("Fan_RPM"));
                                cooler.setNoise_Level(objcpucooler.getInt("Noise_Level"));
                                cooler.setHarga_Cooler(objcpucooler.getInt("Harga_Cooler"));
                                listCPU_Cooler.add(cooler);
                            }
                            if (cpucoolersimpen.cpucoolersimpen != "") {
                                nama_cpucooler_build.setVisibility(View.VISIBLE);
                                harga_cpucooler_build.setVisibility(View.VISIBLE);
                                rpCPUCooler.setVisibility(View.VISIBLE);
                                button_edit_CPUCooler.setVisibility(View.VISIBLE);
                                button_add_CPUCooler.setVisibility(View.INVISIBLE);

                                nama_cpucooler_build.setText(cpucoolersimpen.cpucoolersimpen);
                                for (int i = 0; i < listCPU_Cooler.size(); i++) {
                                    if (cpucoolersimpen.cpucoolersimpen.equals(listCPU_Cooler.get(i).getNama_Cooler())) ;
                                    harga_cpucooler_build.setText(String.valueOf(listCPU_Cooler.get(i).getHarga_Cooler()));
                                    hargatotal = hargatotal + listCPU_Cooler.get(i).getHarga_Cooler();
                                }
                            } else {
                                nama_cpucooler_build.setVisibility(View.INVISIBLE);
                                harga_cpucooler_build.setVisibility(View.INVISIBLE);
                                rpCPUCooler.setVisibility(View.INVISIBLE);
                                button_add_CPUCooler.setVisibility(View.VISIBLE);
                                button_edit_CPUCooler.setVisibility(View.INVISIBLE);
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

    private void loadGPU() {
        String url = "http://192.168.1.14/letsbuildpc/readgpu.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsongpu = response.getJSONArray("gpu");
                            for (int i = 0; i < jsongpu.length(); i++) {
                                JSONObject objgpu = jsongpu.getJSONObject(i);
                                GPU gpu = new GPU();
                                gpu.setId_gpu(objgpu.getInt("id_gpu"));
                                gpu.setNama_GPU(objgpu.getString("Nama_GPU"));
                                gpu.setChipset_GPU(objgpu.getString("Chipset_GPU"));
                                gpu.setCore_Clock_GPU(objgpu.getInt("Core_Clock_GPU"));
                                gpu.setBoost_Clock_GPU(objgpu.getInt("Boost_Clock_GPU"));
                                gpu.setMemory_GPU(objgpu.getInt("Memory_GPU"));
                                gpu.setTDP_GPU(objgpu.getInt("TDP_GPU"));
                                gpu.setHarga_GPU(objgpu.getInt("Harga_GPU"));
                                listGPU.add(gpu);
                            }

                            if (gpusimpen.gpusimpen != "") {
                                nama_GPU_build.setVisibility(View.VISIBLE);
                                harga_GPU_build.setVisibility(View.VISIBLE);
                                rpGPU.setVisibility(View.VISIBLE);
                                button_edit_GPU.setVisibility(View.VISIBLE);
                                button_add_GPU.setVisibility(View.INVISIBLE);

                                nama_GPU_build.setText(gpusimpen.gpusimpen);

                                for (int i = 0; i < listGPU.size(); i++) {
                                    if (gpusimpen.gpusimpen.equals(listGPU.get(i).getNama_GPU())) ;
                                    harga_GPU_build.setText(String.valueOf(listGPU.get(i).getHarga_GPU()));
                                    hargatotal = hargatotal + listGPU.get(i).getHarga_GPU();
                                }
                            } else {
                                button_edit_GPU.setVisibility(View.INVISIBLE);
                                button_add_GPU.setVisibility(View.VISIBLE);
                                rpGPU.setVisibility(View.INVISIBLE);
                                nama_GPU_build.setVisibility(View.INVISIBLE);
                                harga_GPU_build.setVisibility(View.INVISIBLE);
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

    private void loadmemory() {
        String url = "http://192.168.1.14/letsbuildpc/readmemory.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonmemory = response.getJSONArray("memory");
                            for (int i = 0; i < jsonmemory.length(); i++) {
                                JSONObject objmemory = jsonmemory.getJSONObject(i);
                                Memory memory = new Memory();
                                memory.setId_memory(objmemory.getInt("id_memory"));
                                memory.setNama_Memory(objmemory.getString("Nama_Memory"));
                                memory.setSize(objmemory.getString("Size"));
                                memory.setSpeed(objmemory.getInt("Speed"));
                                memory.setHarga(objmemory.getInt("Harga"));
                                listMemory.add(memory);
                            }
                            if (memorysimpen.memorysimpen != 0) {
                                nama_Memory_build.setVisibility(View.VISIBLE);
                                nama_Memory_build.setVisibility(View.VISIBLE);
                                rpMemory.setVisibility(View.VISIBLE);
                                button_edit_Memory.setVisibility(View.VISIBLE);
                                button_add_Memory.setVisibility(View.INVISIBLE);

                                for (int i = 0; i < listMemory.size(); i++) {
                                    if (memorysimpen.memorysimpen == listMemory.get(i).getId_memory());
                                    nama_Memory_build.setText(listMemory.get(i).getNama_Memory());
                                    harga_Memory_build.setText(String.valueOf(listMemory.get(i).getHarga()));
                                    hargatotal = hargatotal + listMemory.get(i).getHarga();
                                    break;
                                }
                            } else {
                                button_edit_Memory.setVisibility(View.INVISIBLE);
                                button_add_Memory.setVisibility(View.VISIBLE);
                                rpMemory.setVisibility(View.INVISIBLE);
                                nama_Memory_build.setVisibility(View.INVISIBLE);
                                harga_Memory_build.setVisibility(View.INVISIBLE);
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

    private void loadmotherboard() {
        String url = "http://192.168.1.14/letsbuildpc/readmotherboard.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonmotherboard = response.getJSONArray("motherboard");
                            for (int i = 0; i < jsonmotherboard.length(); i++) {
                                JSONObject objmotherboard = jsonmotherboard.getJSONObject(i);
                                Motherboard motherboard = new Motherboard();
                                motherboard.setId_motherboard(objmotherboard.getInt("id_motherboard"));
                                motherboard.setNama_Motherboard(objmotherboard.getString("Nama_Motherboard"));
                                motherboard.setForm_Factor(objmotherboard.getString("Form_Factor"));
                                motherboard.setChipset(objmotherboard.getString("Chipset"));
                                motherboard.setSocket(objmotherboard.getString("Socket"));
                                motherboard.setHarga_Motherboard(objmotherboard.getInt("Harga_Motherboard"));
                                listMotherboard.add(motherboard);
                            }
                            if (motherboardsimpen.motherboardsimpen != "") {
                                nama_Motherboard_build.setVisibility(View.VISIBLE);
                                harga_Motherboard_build.setVisibility(View.VISIBLE);
                                rpMotherboard.setVisibility(View.VISIBLE);
                                button_edit_Motherboard.setVisibility(View.VISIBLE);
                                button_add_Motherboard.setVisibility(View.INVISIBLE);

                                nama_Motherboard_build.setText(motherboardsimpen.motherboardsimpen);

                                for (int i = 0; i < listMotherboard.size(); i++) {
                                    if (motherboardsimpen.motherboardsimpen.equals(listMotherboard.get(i).getNama_Motherboard()))
                                        ;
                                    harga_Motherboard_build.setText(String.valueOf(listMotherboard.get(i).getHarga_Motherboard()));
                                    hargatotal = hargatotal + listMotherboard.get(i).getHarga_Motherboard();
                                }
                            } else {
                                nama_Motherboard_build.setVisibility(View.INVISIBLE);
                                harga_Motherboard_build.setVisibility(View.INVISIBLE);
                                button_edit_Motherboard.setVisibility(View.INVISIBLE);
                                rpMotherboard.setVisibility(View.INVISIBLE);
                                button_add_Motherboard.setVisibility(View.VISIBLE);
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

    private void loadPSU() {
        String url = "http://192.168.1.14/letsbuildpc/readpsu.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonpsu = response.getJSONArray("psu");
                            for (int i = 0; i < jsonpsu.length(); i++) {
                                JSONObject objpsu = jsonpsu.getJSONObject(i);
                                PSU psu = new PSU();
                                psu.setId_psu(objpsu.getInt("id_psu"));
                                psu.setNama_PSU(objpsu.getString("Nama_PSU"));
                                psu.setForm_Factor_PSU(objpsu.getString("Form_Factor_PSU"));
                                psu.setModular(objpsu.getString("Modular"));
                                psu.setEfficiency_Rating(objpsu.getString("Efficiency_Rating"));
                                psu.setWattage_PSU(objpsu.getInt("Wattage_PSU"));
                                psu.setHarga_PSU(objpsu.getInt("Harga_PSU"));
                                listPSU.add(psu);
                            }
                            if (psusimpen.psusimpen != "") {
                                nama_PSU_build.setVisibility(View.VISIBLE);
                                harga_PSU_build.setVisibility(View.VISIBLE);
                                rpPSU.setVisibility(View.VISIBLE);
                                button_edit_PSU.setVisibility(View.VISIBLE);
                                button_add_PSU.setVisibility(View.INVISIBLE);

                                nama_PSU_build.setText(psusimpen.psusimpen);

                                for (int i = 0; i < listPSU.size(); i++) {
                                    if (psusimpen.psusimpen.equals(listPSU.get(i).getNama_PSU())) ;
                                    harga_PSU_build.setText(String.valueOf(listPSU.get(i).getHarga_PSU()));
                                    hargatotal = hargatotal + listPSU.get(i).getHarga_PSU();
                                }
                            } else {
                                nama_PSU_build.setVisibility(View.INVISIBLE);
                                harga_PSU_build.setVisibility(View.INVISIBLE);
                                rpPSU.setVisibility(View.INVISIBLE);
                                button_add_PSU.setVisibility(View.VISIBLE);
                                button_edit_PSU.setVisibility(View.INVISIBLE);
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

    private void loadStorage() {
        String url = "http://192.168.1.14/letsbuildpc/readstorage.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonstorage = response.getJSONArray("storage");
                            for (int i = 0; i < jsonstorage.length(); i++) {
                                JSONObject objstorage = jsonstorage.getJSONObject(i);
                                Storage storage = new Storage();
                                storage.setId_storage(objstorage.getInt("id_storage"));
                                storage.setNama_Storage(objstorage.getString("Nama_Storage"));
                                storage.setStorage_Type(objstorage.getString("Storage_Type"));
                                storage.setForm_Factor(objstorage.getString("Form_Factor"));
                                storage.setHarga_Storage(objstorage.getInt("Harga_Storage"));
                                storage.setSize_Storage(objstorage.getInt("Size_Storage"));
                                listStorage.add(storage);
                            }
                            if (storagesimpen.storagesimpen != 0) {
                                nama_Storage_build.setVisibility(View.VISIBLE);
                                nama_Storage_build.setVisibility(View.VISIBLE);
                                rpStorage.setVisibility(View.VISIBLE);
                                button_edit_Storage.setVisibility(View.VISIBLE);
                                button_add_Storage.setVisibility(View.INVISIBLE);

                                for (int i = 0; i < listStorage.size(); i++) {
                                    if (storagesimpen.storagesimpen == listStorage.get(i).getId_storage()) ;
                                    nama_Storage_build.setText(listStorage.get(i).getNama_Storage());
                                    harga_Storage_build.setText(String.valueOf(listStorage.get(i).getHarga_Storage()));
                                    hargatotal = hargatotal + listStorage.get(i).getHarga_Storage();
                                }
                            } else {
                                button_edit_Storage.setVisibility(View.INVISIBLE);
                                button_add_Storage.setVisibility(View.VISIBLE);
                                rpStorage.setVisibility(View.INVISIBLE);
                                nama_Storage_build.setVisibility(View.INVISIBLE);
                                harga_Storage_build.setVisibility(View.INVISIBLE);
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

    private void loadCasepc() {
        String url = "http://192.168.1.14/letsbuildpc/readcasepc.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsoncasepc = response.getJSONArray("casepc");
                            for (int i = 0; i < jsoncasepc.length(); i++) {
                                JSONObject objcasepc = jsoncasepc.getJSONObject(i);
                                Casepc casepc = new Casepc();
                                casepc.setId_casepc(objcasepc.getInt("id_casepc"));
                                casepc.setNama_Case(objcasepc.getString("Nama_Case"));
                                casepc.setForm_Factor_Case(objcasepc.getString("Form_Factor_Case"));
                                casepc.setSide_Panel_Windows(objcasepc.getString("Side_Panel_Windows"));
                                casepc.setColor(objcasepc.getString("Color"));
                                casepc.setHarga_Case(objcasepc.getInt("Harga_Case"));
                                listCasePC.add(casepc);
                            }
                            if (casepcsimpen.casepcsimpen != "") {
                                nama_Case_build.setVisibility(View.VISIBLE);
                                harga_Case_build.setVisibility(View.VISIBLE);
                                rpCase.setVisibility(View.VISIBLE);
                                button_edit_Case.setVisibility(View.VISIBLE);
                                button_add_Case.setVisibility(View.INVISIBLE);

                                nama_Case_build.setText(casepcsimpen.casepcsimpen);

                                for (int i = 0; i < listCasePC.size(); i++) {
                                    if (casepcsimpen.casepcsimpen.equals(listCasePC.get(i).getNama_Case()))
                                        ;
                                    harga_Case_build.setText(String.valueOf(listCasePC.get(i).getHarga_Case()));
                                    hargatotal = hargatotal + listCasePC.get(i).getHarga_Case();
                                }
                            } else {
                                button_edit_Case.setVisibility(View.INVISIBLE);
                                button_add_Case.setVisibility(View.VISIBLE);
                                rpCase.setVisibility(View.INVISIBLE);
                                nama_Case_build.setVisibility(View.INVISIBLE);
                                harga_Case_build.setVisibility(View.INVISIBLE);
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
        MyList mylist = new MyList(cpusimpen.cpusimpen, cpucoolersimpen.cpucoolersimpen, motherboardsimpen.motherboardsimpen, gpusimpen.gpusimpen, casepcsimpen.casepcsimpen, psusimpen.psusimpen, memorysimpen.memorysimpen, storagesimpen.storagesimpen, userIDsimpen.useridsimpen, hargatotal);
        createuser(mylist);
    }

    private void createuser(MyList temp) {
        String url = "http://192.168.1.14/letsbuildpc/Createmylist.php";
        RequestQueue myRequest = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getContext(), "Komputer Berhasil dirakit", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("CPU", temp.getCPU());
                data.put("CPU_Cooler", temp.getCPU_Cooler());
                data.put("Motherboard", temp.getMotherboard());
                data.put("Memory_id", String.valueOf(temp.getMemory_id()));
                data.put("Storage_id", String.valueOf(temp.getStorage_id()));
                data.put("GPU", temp.getGPU());
                data.put("Casepc", temp.getCasepc());
                data.put("PSU", temp.getPSU());
                data.put("User_id", String.valueOf(temp.getUser_ID()));
                data.put("Harga_Total", String.valueOf(temp.getHarga_Total()));

                return data;
            }
        };
        myRequest.add(request);
    }

}