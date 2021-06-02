package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

import model.account;
import model.user;

public class register extends AppCompatActivity {

    private TextView relogin_button;
    private Button signup_button;
    private TextInputLayout input_nama_register, input_email_register, input_password_register;
    private Boolean validateEmail, validatePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Menghilangkan Action Bar
        getSupportActionBar().hide();

        //Deklarasi
        relogin_button = findViewById(R.id.relogin_button);
        signup_button = findViewById(R.id.signup_button);
        input_nama_register = findViewById(R.id.input_nama_register);
        input_email_register = findViewById(R.id.input_email_register);
        input_password_register= findViewById(R.id.input_password_register);
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
                        Toast.makeText(getBaseContext(), "Akun berhasil dibuat!", Toast.LENGTH_LONG).show();

                        //Intent ke Login
                        Intent intent = new Intent(getBaseContext(), Login.class);
                        finish();
                        startActivity(intent);
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
                //Intent ke Login
                Intent intent = new Intent(getBaseContext(), Login.class);
                finish();
                startActivity(intent);
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

    }
}