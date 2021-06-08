package com.example.mainactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

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
import model.userIDsimpen;

public class mylist_adapter extends RecyclerView.Adapter<mylist_adapter.MyListViewholder> {

    private int id = userIDsimpen.useridsimpen;
    private ArrayList<CPU> listCPU;
    private ArrayList<CPU_Cooler> listCPU_Cooler;
    private ArrayList<GPU> listGPU;
    private ArrayList<Memory> listMemory;
    private ArrayList<Motherboard> listMotherboard;
    private ArrayList<PSU> listPSU;
    private ArrayList<Storage> listStorage;
    private ArrayList<Casepc> listCasePC;
    private ArrayList<MyList> listMylist;
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
        this.listMylist = listMylist;
    }

    @NonNull


    @Override
    public mylist_adapter.MyListViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_list_komputer, parent, false);
        return new MyListViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mylist_adapter.MyListViewholder holder, int position) {
        if (listMylist.get(position).getUser_ID()==id){
            holder.textView_index_komputer.setText(String.valueOf(listMylist.get(position).getId_computer()));
            holder.textView_component_1.setText(listMylist.get(position).getCPU());
            holder.textView_component_2.setText(listMylist.get(position).getCPU_Cooler());
            holder.textView_component_3.setText(String.valueOf(listMylist.get(position).getMemory_id()));
            holder.textView_component_4.setText(String.valueOf(listMylist.get(position).getStorage_id()));
            holder.harga_computer.setText(String.valueOf(listMylist.get(position).getHarga_Total()));
        }
        holder.delete_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listMylist.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(), listMylist.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class MyListViewholder extends RecyclerView.ViewHolder {
        private TextView harga_computer, textView_component_1, textView_component_2, textView_component_3, textView_component_4, textView_index_komputer;
        private CardView CardView_list_komputer;
        private ImageView delete_icon;

        public MyListViewholder(@NonNull View itemView) {

            super(itemView);
            harga_computer = itemView.findViewById(R.id.harga_computer);
            textView_component_1 = itemView.findViewById(R.id.textView_component_1);
            textView_component_2 = itemView.findViewById(R.id.textView_component_2);
            textView_component_3 = itemView.findViewById(R.id.textView_component_3);
            textView_component_4 = itemView.findViewById(R.id.textView_component_4);
            textView_index_komputer = itemView.findViewById(R.id.textView_index_komputer);
            CardView_list_komputer = itemView.findViewById(R.id.CardView_list_komputer);
            delete_icon = itemView.findViewById(R.id.delete_icon);

            delete_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                            listMylist.remove(getAdapterPosition());
                            notifyItemRemoved(getAdapterPosition());
                            notifyItemRangeChanged(getAdapterPosition(), listMylist.size());

                    };
                }
            );
        }
    }
}
