package com.example.mainactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class componentlist extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_componentlist, container, false);
        Spinner spinner_more = (Spinner) v.findViewById(R.id.spinner_more);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.components));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_more.setAdapter(adapter);

        RecyclerView recyclerview_complist;
        //ArrayList<> componentlists
        return v;
    }
}