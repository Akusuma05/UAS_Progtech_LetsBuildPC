package com.example.mainactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.regex.Pattern;

import model.account;
import model.user;

public class userinfo extends Fragment {
    private TextView  welcome, nama_user;
    private Button logout_button;
    private ArrayList<user> listuser = account.listuser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_userinfo, container, false);

        //Deklarasi
        logout_button = v.findViewById(R.id.logout_button);
        welcome = v.findViewById(R.id.welcome);
        nama_user = v.findViewById(R.id.nama_user);
        for (int i = 0; i <listuser.size(); i++){
            user tempuser = listuser.get(i);
            if (tempuser.getSudahlogin().equals("yes")){
                nama_user.setText(tempuser.getNama());
            }
        }

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Ngubah Sudah Login menjadi false
                for (int i = 0; i <listuser.size(); i++){
                    user tempuser = listuser.get(i);
                    if (tempuser.getSudahlogin().equals("yes")) {
                        tempuser.setSudahlogin("no");
                        Intent intent = new Intent(getContext(), Login.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        break;
                    }
                }
                Toast.makeText(getContext(), "Logout Berhasil", Toast.LENGTH_LONG).show();
            }
        });



        return v;
    }
}