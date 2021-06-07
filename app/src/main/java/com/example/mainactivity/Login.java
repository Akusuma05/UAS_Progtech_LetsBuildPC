package com.example.mainactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import model.account;
import model.user;

public class Login extends AppCompatActivity {
    private TextView registerhere_button, dont_have_account;
    private Button login_button;
    private ImageView logo_login;
    private TextInputLayout input_email_login, input_password_login;
    private ArrayList<user> listuser = new ArrayList<user>();
    private Boolean validateEmail, validatePassword;
    private int berhasil = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Deklarasi
        registerhere_button = findViewById(R.id.registerhere_button);
        login_button = findViewById(R.id.login_button);
        logo_login = findViewById(R.id.logo_login);
        input_email_login = findViewById(R.id.input_email_login);
        input_password_login = findViewById(R.id.input_password_login);
        dont_have_account = findViewById(R.id.dont_have_account);
        loadDataDB();


        //Menghilangkan Action Bar
        getSupportActionBar().hide();


        //Login Button
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), String.valueOf(listuser.size()), Toast.LENGTH_SHORT).show();


                String email = input_email_login.getEditText().getText().toString().trim();
                String password = input_password_login.getEditText().getText().toString().trim();

                if(validateEmail && validatePassword){
                    for (int i = 0; i <listuser.size(); i++) {
                        user tempuser = listuser.get(i);
                        if (tempuser.getEmail().equalsIgnoreCase(email) && tempuser.getPassword().equals(password)) {
                            Intent intent = new Intent(getBaseContext(), MainActivity.class);
                            updatesudahlogin(tempuser.getId_user());
                            finish();
                            startActivity(intent);
                            berhasil = 1;
                            Toast.makeText(getBaseContext(), "Login Sukses", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                    if (berhasil == 0){
                        Toast.makeText(getBaseContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    input_password_login.setError("Please correct the password column");
                    input_email_login.setError("Please Correct the email column");
                }
            }
        });



        registerhere_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pindah ke Activity Register
                Intent intent = new Intent(getBaseContext(), register.class);
                startActivity(intent);

            }
        });

        //Check email
        input_email_login.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = input_email_login.getEditText().getText().toString().trim();

                Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile("[a-zA-Z0-9+._%-+]{1,256}" + "@"
                        + "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" + "(" + "."
                        + "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" + ")+");
                if(email.isEmpty()){
                    input_email_login.setError("Please Fill Email Column");
                    validateEmail = false;
                }else{
                    if (!EMAIL_ADDRESS_PATTERN.matcher(email).matches()){
                        input_email_login.setError("Wrong format email");
                        validateEmail = false;
                    }else{
                        input_email_login.setError("");
                        validateEmail = true;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Check Password
        input_password_login.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = input_password_login.getEditText().getText().toString().trim();

                Pattern PASSWORD_PATTERN
                        = Pattern.compile(
                        "[a-zA-Z0-9\\!\\@\\#\\$]{8,20}");

                if(password.isEmpty()){
                    input_password_login.setError("Please Fill Password Column");
                    validatePassword = false;
                }else{
                    if (!PASSWORD_PATTERN.matcher(password).matches()){
                        input_password_login.setError("Wrong Format Password");
                        validatePassword = false;
                    }else{
                        input_password_login.setError("");
                        validatePassword = true;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    private void loadDataDB() {


        String url ="http://192.168.100.4/letsbuildpc/ReadUser.php";

        RequestQueue myQueue = Volley.newRequestQueue(this);
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


        String url = "http://192.168.100.4/letsbuildpc/Updatesudahloginuser.php";

        RequestQueue myRequest = Volley.newRequestQueue(this);

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