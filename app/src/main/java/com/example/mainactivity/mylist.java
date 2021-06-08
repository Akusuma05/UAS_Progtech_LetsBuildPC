package com.example.mainactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import model.componenttypesimpen;

public class mylist extends Fragment implements OnCardListener{

    //private String tipe = componenttypesimpen.tipepilihcomponent;
    private RecyclerView recyclerView_mylist;
    private mylist_adapter ml_adapter;
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
        View v = inflater.inflate(R.layout.fragment_mylist, container, false);

        recyclerView_mylist = v.findViewById(R.id.recyclerView_mylist);

        initview();
        setupRecyclerView();
//        loadCPUdata();
//        loadCPUCooler();
//        loadGPU();
        loadmemory();
//        loadmotherboard();
//        loadPSU();
        loadStorage();
//        loadCasepc();

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
        ml_adapter = new mylist_adapter(listCPU, listCPU_Cooler, listGPU, listMemory, listMotherboard, listPSU, listStorage, listCasePC, this);
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView_mylist.setLayoutManager(manager);
        recyclerView_mylist.setAdapter(ml_adapter);
    }

    @Override
    public void onCardClick(int position) {

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
                            ml_adapter.notifyDataSetChanged();
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
                            ml_adapter.notifyDataSetChanged();
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