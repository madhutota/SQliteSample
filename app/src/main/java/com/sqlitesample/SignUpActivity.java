package com.sqlitesample;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sqlitesample.sql.DataBaseHelper;

public class SignUpActivity extends AppCompatActivity {

    private EditText userFirstname;
    private EditText userLastname;
    private EditText useremil;
    private EditText userpass;
    private EditText userReenterpass;
    private EditText userPhoneNumber;
    private Button button;

    DataBaseHelper dataBaseHelper;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        iniTUi();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void iniTUi() {

        dataBaseHelper = new DataBaseHelper(this);

        userFirstname = findViewById(R.id.et_first);
        userLastname = findViewById(R.id.et_last);
        useremil = findViewById(R.id.et_email);
        userpass = findViewById(R.id.et_pass);
        userPhoneNumber = findViewById(R.id.et_phone);
        userReenterpass = findViewById(R.id.et_repss);
        button = findViewById(R.id.btn_sumit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fname = userFirstname.getText().toString();
                String lname = userLastname.getText().toString();
                String email = useremil.getText().toString();
                String userpa = userpass.getText().toString();
                String userrePass = userReenterpass.getText().toString();
                String phoneNumber = userPhoneNumber.getText().toString();

                dataBaseHelper.addUser(new UserModel(fname, lname, phoneNumber, userpa, email));


            }
        });


       /* if (!TextUtils.isEmpty(userpass.getText().toString())
                && !TextUtils.isEmpty(userReenterpass.getText().toString())
                && Objects.equals(userpass.getText().toString(), userReenterpass.getText().toString())) {


            *//*Utility.setPrefStringData(this, Utility.EMAIL, useremil.getText().toString());
            Utility.setPrefStringData(this, Utility.PASS, useremil.getText().toString());*//*
        }*/

    }
}
