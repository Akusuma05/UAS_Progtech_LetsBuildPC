package com.example.mainactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

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
import model.CPU_Cooler;
import model.Casepc;
import model.GPU;
import model.Memory;
import model.Motherboard;
import model.PSU;
import model.Storage;
import model.componenttype;
import model.componenttypesimpen;

public class componentlist extends Fragment implements OnCardListener {

    private String tipe = "";
    private RecyclerView recyclerview_complist;
    private spinner_adapter spin_adapter;
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
        View v = inflater.inflate(R.layout.fragment_componentlist, container, false);
        if (tipe.equals("")){
            model.componenttype componenttype = new componenttype("CPU cooler");
            componenttypesimpen.tipepilihcomponent = "CPU cooler";
            tipe = componenttypesimpen.tipepilihcomponent;
        }
        Spinner spinner_more = (Spinner) v.findViewById(R.id.spinner_more);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.components));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_more.setAdapter(adapter);

        String spinner_component = "";
        //^_^
        spinner_more.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                model.componenttype componenttype = new componenttype(spinner_more.getSelectedItem().toString());
                componenttypesimpen.tipepilihcomponent = spinner_more.getSelectedItem().toString();
                tipe = componenttypesimpen.tipepilihcomponent;
                Toast.makeText(getContext(), tipe, Toast.LENGTH_SHORT).show();
                initview();
                setupRecyclerView();
                loadCPUdata();
                loadCPUCooler();
                loadGPU();
                loadmemory();
                loadmotherboard();
                loadPSU();
                loadStorage();
                loadCasepc();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        recyclerview_complist = v.findViewById(R.id.recyclerview_complist);
        //ArrayList<> componentlists
        initview();
        setupRecyclerView();
        loadCPUdata();
        loadCPUCooler();
        loadGPU();
        loadmemory();
        loadmotherboard();
        loadPSU();
        loadStorage();
        loadCasepc();
        return v;
    }

    private void initview(){
        listCPU = new ArrayList<CPU>();
        listCPU_Cooler = new ArrayList<CPU_Cooler>();
        listGPU = new ArrayList<GPU>();
        listMemory = new ArrayList<Memory>();
        listMotherboard = new ArrayList<Motherboard>();
        listPSU = new ArrayList<PSU>();
        listStorage = new ArrayList<Storage>();
        listCasePC = new ArrayList<Casepc>();
        spin_adapter = new spinner_adapter(listCPU, listCPU_Cooler, listGPU, listMemory, listMotherboard, listPSU, listStorage, listCasePC, this);
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerview_complist.setLayoutManager(manager);
        recyclerview_complist.setAdapter(spin_adapter);
    }

    @Override
    public void onCardClick(int position) {

    }

    private void loadCPUdata() {
        String url ="http://192.168.100.4/letsbuildpc/readCPU.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsoncpu = response.getJSONArray("cpu");
                            for (int i = 0; i < jsoncpu.length(); i++){
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
                            spin_adapter.notifyDataSetChanged();
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
        String url ="http://192.168.100.4/letsbuildpc/readcooler.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsoncpucooler = response.getJSONArray("cpu_cooler");
                            for (int i = 0; i < jsoncpucooler.length(); i++){
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
                            spin_adapter.notifyDataSetChanged();
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
        String url ="http://192.168.100.4/letsbuildpc/readgpu.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsongpu = response.getJSONArray("gpu");
                            for (int i = 0; i < jsongpu.length(); i++){
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
                            spin_adapter.notifyDataSetChanged();
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
        String url ="http://192.168.100.4/letsbuildpc/readmemory.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonmemory = response.getJSONArray("memory");
                            for (int i = 0; i < jsonmemory.length(); i++){
                                JSONObject objmemory = jsonmemory.getJSONObject(i);
                                Memory memory = new Memory();
                                memory.setId_memory(objmemory.getInt("id_memory"));
                                memory.setNama_Memory(objmemory.getString("Nama_Memory"));
                                memory.setSize(objmemory.getString("Size"));
                                memory.setSpeed(objmemory.getInt("Speed"));
                                memory.setHarga(objmemory.getInt("Harga"));
                                listMemory.add(memory);
                            }
                            spin_adapter.notifyDataSetChanged();
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
        String url ="http://192.168.100.4/letsbuildpc/readmotherboard.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonmotherboard = response.getJSONArray("motherboard");
                            for (int i = 0; i < jsonmotherboard.length(); i++){
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
                            spin_adapter.notifyDataSetChanged();
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
        String url ="http://192.168.100.4/letsbuildpc/readpsu.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonpsu = response.getJSONArray("psu");
                            for (int i = 0; i < jsonpsu.length(); i++){
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
                            spin_adapter.notifyDataSetChanged();
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
        String url ="http://192.168.100.4/letsbuildpc/readstorage.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonstorage = response.getJSONArray("storage");
                            for (int i = 0; i < jsonstorage.length(); i++){
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
                            spin_adapter.notifyDataSetChanged();
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
        String url ="http://192.168.100.4/letsbuildpc/readcasepc.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsoncasepc = response.getJSONArray("casepc");
                            for (int i = 0; i < jsoncasepc.length(); i++){
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
                            spin_adapter.notifyDataSetChanged();
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

}