package com.example.mainactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link userinfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class userinfo extends Fragment {
    private TextView registerhere_button, welcome, nama_user, dont_have_account;
    private Button login_button, logout_button;
    private ImageView logo_login;
    private TextInputLayout input_email_login, input_password_login;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public userinfo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment userinfo.
     */
    // TODO: Rename and change types and number of parameters
    public static userinfo newInstance(String param1, String param2) {
        userinfo fragment = new userinfo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_userinfo, container, false);
        registerhere_button = v.findViewById(R.id.registerhere_button);
        login_button = v.findViewById(R.id.login_button);
        logout_button = v.findViewById(R.id.logout_button);
        welcome = v.findViewById(R.id.welcome);
        nama_user = v.findViewById(R.id.nama_user);
        logo_login = v.findViewById(R.id.logo_login);
        input_email_login = v.findViewById(R.id.input_email_login);
        input_password_login = v.findViewById(R.id.input_password_login);
        dont_have_account = v.findViewById(R.id.dont_have_account);

        welcome.setVisibility(View.INVISIBLE);
        nama_user.setVisibility(View.INVISIBLE);
        logout_button.setVisibility(View.INVISIBLE);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerhere_button.setVisibility(View.INVISIBLE);
                login_button.setVisibility(View.INVISIBLE);
                logout_button.setVisibility(View.INVISIBLE);
                logo_login.setVisibility(View.INVISIBLE);
                input_email_login.setVisibility(View.INVISIBLE);
                input_password_login.setVisibility(View.INVISIBLE);
                dont_have_account.setVisibility(View.INVISIBLE);
                welcome.setVisibility(View.VISIBLE);
                nama_user.setVisibility(View.VISIBLE);
                logout_button.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), "Login Berhasil", Toast.LENGTH_LONG).show();
            }
        });

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerhere_button.setVisibility(View.VISIBLE);
                login_button.setVisibility(View.VISIBLE);
                logout_button.setVisibility(View.VISIBLE);
                logo_login.setVisibility(View.VISIBLE);
                input_email_login.setVisibility(View.VISIBLE);
                input_password_login.setVisibility(View.VISIBLE);
                dont_have_account.setVisibility(View.VISIBLE);
                welcome.setVisibility(View.INVISIBLE);
                nama_user.setVisibility(View.INVISIBLE);
                logout_button.setVisibility(View.INVISIBLE);
                Toast.makeText(getContext(), "Logout Berhasil", Toast.LENGTH_LONG).show();
            }
        });

        registerhere_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new register();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return v;
    }
}