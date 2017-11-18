package com.sqlitesample;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.sqlitesample.helper.InputValidation;
import com.sqlitesample.sql.DataBaseHelper;

public class MainActivity extends AppCompatActivity {
    private EditText et_user_name;
    private EditText et_password;

    private Button btn_login;
    private Button btn_sign_up;
    private Button btn_new_user;
    private Button btn_get_all_users;
    private LinearLayout ll_parent;


    private Button button;
    DataBaseHelper dataBaseHelper;
    private InputValidation inputValidation;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_parent = findViewById(R.id.ll_parent);
        iniTUi();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void iniTUi() {
        et_user_name = findViewById(R.id.et_user_name);
        et_password = findViewById(R.id.et_password);

        dataBaseHelper = new DataBaseHelper(this);
        inputValidation = new InputValidation(this);


        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifySqlite();

            }
        });
        btn_sign_up = findViewById(R.id.btn_sign_up);
        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });
        btn_new_user = findViewById(R.id.btn_new_user);
        btn_new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_get_all_users = findViewById(R.id.btn_get_all_users);
        btn_get_all_users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void verifySqlite() {
        if (!inputValidation.isInputEditTextFilled(et_user_name, getString(R.string.no_pass))) {
            return;
        }


        if (!inputValidation.isInputEditTextEmailFilled(et_user_name, getString(R.string.no_email))) {
            return;
        }

        if (!inputValidation.isInputEditTextFilled(et_password, getString(R.string.no_email))) {
            return;
        }

        if (dataBaseHelper.checkUserEmailAndPassword(et_user_name.getText().toString().trim(),
                et_password.getText().toString().trim())) {

            startActivity(new Intent(this, ListActivity.class));

        } else {
            Snackbar snackbar = Snackbar.make(ll_parent, "Validation Filed", Snackbar.LENGTH_INDEFINITE);
            snackbar.show();

            et_user_name.setText(null);
            et_password.setText(null);
        }


    }
}