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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

import model.account;
import model.user;
import model.userIDsimpen;

public class userinfo extends Fragment{
    private TextView  nama_user;
    private Button logout_button;
    private ArrayList<user> listuser = new ArrayList<user>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_userinfo, container, false);

        //Deklarasi
        logout_button = v.findViewById(R.id.logout_button);
        nama_user = v.findViewById(R.id.nama_user);
        loadDataDB();


        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Ngubah Sudah Login menjadi false
                for (int i = 0; i <listuser.size(); i++){
                    user tempuser = listuser.get(i);
                    if (tempuser.getSudahlogin().equals("yes")) {
                        updatesudahlogin(tempuser.getId_user());
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

    private void loadDataDB() {
        String url ="http://192.168.1.8/letsbuildpc/ReadUser.php";
        RequestQueue myQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonuser = response.getJSONArray("user");
                            for (int i = 0; i < jsonuser.length(); i++){
                                JSONObject objuser = jsonuser.getJSONObject(i);
                                user user1 = new user();
                                user1.setId_user(objuser.getInt("id_user"));
                                user1.setNama(objuser.getString("Nama"));
                                user1.setEmail(objuser.getString("Email"));
                                user1.setPassword(objuser.getString("Password"));
                                user1.setSudahlogin(objuser.getString("Sudah_Login"));
                                listuser.add(user1);
                            }

                            for (int i = 0; i <listuser.size(); i++){
                                user tempuser = listuser.get(i);
                                if (tempuser.getSudahlogin().equals("yes")){
                                    nama_user.setText(tempuser.getNama());
                                    userIDsimpen.useridsimpen = tempuser.getId_user();
                                }
                            }
//                            adapter.notifyDataSetChanged();
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

    private void updatesudahlogin(int id){
        String url = "http://192.168.1.8/letsbuildpc/Updatesudahloginuser.php";
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