package com.example.mainactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

import model.Memory;
import model.MyList;
import model.Storage;
import model.userIDsimpen;

public class mylist extends Fragment implements OnCardListener{

    private RecyclerView recyclerView_mylist;
    private mylist_adapter ml_adapter;
    private ArrayList<MyList> ML;
    private ArrayList<Storage> listStorage;
    private ArrayList<Memory> listMemory;
    private int userid = userIDsimpen.useridsimpen;
    private OnCardListener cardListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mylist, container, false);

        recyclerView_mylist = v.findViewById(R.id.recyclerView_mylist);

        initview();
        setupRecyclerView();
        Readmylist();
        loadmemory();

        return v;
    }

    private void initview(){
        ML = new ArrayList<MyList>();
        listStorage = new ArrayList<Storage>();
        listMemory = new ArrayList<Memory>();
        ml_adapter = new mylist_adapter(userid, listMemory, ML, this);
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView_mylist.setLayoutManager(manager);
        recyclerView_mylist.setAdapter(ml_adapter);
    }

    private void Readmylist() {
        String url = "http://192.168.1.8/letsbuildpc/readmylist.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonmylist = response.getJSONArray("mylist");
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
                                ML.add(myList);
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


    private void loadmemory() {
        String url ="http://192.168.1.8/letsbuildpc/readmemory.php";
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


    @Override
    public void onCardClick(int position) {
        int id = position;
        deletemylist(id);
    }

    private void deletemylist(int id){
        String url = "http://192.168.1.8/letsbuildpc/deletemylist.php";
        RequestQueue myRequest = Volley.newRequestQueue(getActivity().getApplicationContext());

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data =  new HashMap<>();
                data.put("id", String.valueOf(id));

                return data;
            }
        };
        myRequest.add(request);
    }


}