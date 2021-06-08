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
import model.MyList;
import model.PSU;
import model.Storage;
import model.componenttypesimpen;
import model.user;

public class mylist extends Fragment implements OnCardListener{

    //private String tipe = componenttypesimpen.tipepilihcomponent;
    private RecyclerView recyclerView_mylist;
    private mylist_adapter ml_adapter;
    private ArrayList<MyList> ML;
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

        return v;
    }

    private void initview(){
        ML = new ArrayList<MyList>();
        ml_adapter = new mylist_adapter(ML, this);
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView_mylist.setLayoutManager(manager);
        recyclerView_mylist.setAdapter(ml_adapter);
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



    @Override
    public void onCardClick(int position) {

    }


}