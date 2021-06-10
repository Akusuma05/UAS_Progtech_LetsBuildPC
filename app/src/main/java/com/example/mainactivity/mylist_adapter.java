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

    private int id;
    private ArrayList<Memory> listMemory;
    private ArrayList<MyList> listMylist;
    private OnCardListener cardListener;

    public mylist_adapter(int id, ArrayList<Memory> listMemory, ArrayList<MyList> listMylist, OnCardListener cardListener) {
        this.id = id;
        this.listMemory = listMemory;
        this.listMylist = listMylist;
        this.cardListener = cardListener;
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
            holder.harga_computer.setVisibility(View.VISIBLE);
            holder.textView_component_4.setVisibility(View.VISIBLE);
            holder.textView_component_3.setVisibility(View.VISIBLE);
            holder.textView_component_2.setVisibility(View.VISIBLE);
            holder.textView_component_1.setVisibility(View.VISIBLE);
            holder.textView_index_komputer.setVisibility(View.VISIBLE);
            holder.CardView_list_komputer.setVisibility(View.VISIBLE);
            holder.delete_icon.setVisibility(View.VISIBLE);

            String namamemory = "";

            for (int i = 0; i < listMemory.size(); i++){
                Memory temp = listMemory.get(i);
                if (listMylist.get(position).getMemory_id() == temp.getId_memory()){
                    namamemory = temp.getNama_Memory();
                    break;
                }
            }

            holder.textView_index_komputer.setText(String.valueOf(listMylist.get(position).getId_computer()));
            holder.textView_component_1.setText(listMylist.get(position).getCPU());
            holder.textView_component_2.setText(listMylist.get(position).getCPU_Cooler());
            holder.textView_component_3.setText(namamemory);
            holder.textView_component_4.setText(listMylist.get(position).getGPU());
            holder.harga_computer.setText("Rp." +String.valueOf(listMylist.get(position).getHarga_Total()));
        }else{
            holder.harga_computer.setVisibility(View.GONE);
            holder.textView_component_4.setVisibility(View.GONE);
            holder.textView_component_3.setVisibility(View.GONE);
            holder.textView_component_2.setVisibility(View.GONE);
            holder.textView_component_1.setVisibility(View.GONE);
            holder.textView_index_komputer.setVisibility(View.GONE);
            holder.CardView_list_komputer.setVisibility(View.GONE);
            holder.delete_icon.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return listMylist.size();
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
                    cardListener.onCardClick(listMylist.get(getAdapterPosition()).getId_computer());
                            listMylist.remove(getAdapterPosition());
                            notifyItemRemoved(getAdapterPosition());
                            notifyItemRangeChanged(getAdapterPosition(), listMylist.size());

                    };
                }
            );
        }
    }
}
