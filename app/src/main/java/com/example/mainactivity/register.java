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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.regex.Pattern;

import model.account;
import model.user;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link register#newInstance} factory method to
 * create an instance of this fragment.
 */
public class register extends Fragment {
    private TextView relogin_button;
    private Button signup_button;
    private TextInputLayout input_nama_register, input_email_register, input_password_register;
    private Boolean validateEmail, validatePassword;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public register() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment register.
     */
    // TODO: Rename and change types and number of parameters
    public static register newInstance(String param1, String param2) {
        register fragment = new register();
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
        View v = inflater.inflate(R.layout.fragment_register, container, false);

        //Deklarasi
        relogin_button=v.findViewById(R.id.relogin_button);
        signup_button = v.findViewById(R.id.signup_button);
        input_nama_register=v.findViewById(R.id.input_nama_register);
        input_email_register = v.findViewById(R.id.input_email_register);
        input_password_register=v.findViewById(R.id.input_password_register);
        validateEmail = false;
        validatePassword = false;

        //Tombol Sign Up
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = input_email_register.getEditText().getText().toString().trim();
                String nama = input_nama_register.getEditText().getText().toString().trim();
                String password = input_password_register.getEditText().getText().toString().trim();

                if (validatePassword && validateEmail){
                    if (email.isEmpty()){
                        input_email_register.setError("Kosong");
                    }else{
                        input_email_register.setError("");
                    }

                    if (password.isEmpty()){
                        input_password_register.setError("Kosong");
                    }else{
                        input_password_register.setError("");
                    }
                    if (nama.isEmpty()){
                        input_nama_register.setError("Kosong");
                    }else{
                        input_nama_register.setError("");
                    }
                    if (!nama.isEmpty() && !password.isEmpty() && !email.isEmpty()){
                        //tambah data ke arraylist account java
                        user user = new user(nama, email, password, "no");
                        account.listuser.add(user);
                        Toast.makeText(getContext(), "Akun berhasil dibuat!", Toast.LENGTH_LONG).show();

                        //Pindah ke Fragment Login
                        Fragment fragment = new userinfo();
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                }else{
                    input_password_register.setError("Please correct the password column");
                    input_email_register.setError("Please Correct the email column");
                }
            }
        });

        //Text View Tulisan Login
        relogin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pindah ke Fragment Login
                Fragment fragment = new userinfo();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        input_email_register.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = input_email_register.getEditText().getText().toString().trim();

                Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("[a-zA-Z0-9+._%-+]{1,256}" + "@"
                        + "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" + "(" + "."
                        + "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" + ")+");
                if(email.isEmpty()){
                    input_email_register.setError("Isi form Email");
                    validateEmail = false;
                }else{
                    if (!EMAIL_ADDRESS_PATTERN.matcher(email).matches()){
                        input_email_register.setError("Format Email Salah");
                        validateEmail = false;
                    }else{
                        input_email_register.setError("");
                        validateEmail = true;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        input_password_register.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = input_password_register.getEditText().getText().toString().trim();

                Pattern PASSWORD_PATTERN
                        = Pattern.compile(
                        "[a-zA-Z0-9\\!\\@\\#\\$]{8,20}");

                if(password.isEmpty()){
                    input_password_register.setError("Isi form password");
                    validatePassword = false;
                }else{
                    if (!PASSWORD_PATTERN.matcher(password).matches()){
                        input_password_register.setError("Format Password Salah 1 huruf besar, !/@#$, 1 nomor dan minimum 8");
                        validatePassword = false;
                    }else{
                        input_password_register.setError("");
                        validatePassword = true;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return v;
    }
}