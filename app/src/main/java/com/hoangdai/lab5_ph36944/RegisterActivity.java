package com.hoangdai.lab5_ph36944;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    public static String KEY_USERNAME = "username";
    public static String KEY_PASSWORD = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRegister = findViewById(R.id.btnRegister);

        EditText edtUsername = findViewById(R.id.edt_username);
        EditText edtPassword = findViewById(R.id.edt_password);
        EditText edtRetypePass = findViewById(R.id.edt_retypepassword);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate ô trống nhập
                String sUsername = edtUsername.getText().toString();
                String sPassword = edtPassword.getText().toString();
                String sRetyPass = edtRetypePass.getText().toString();

                if(sUsername == null || sUsername.equals("")){
                    Toast.makeText(getApplicationContext(), "Cần nhập Username!", Toast.LENGTH_SHORT).show();
                } else if(sPassword == null || sPassword.equals("")){
                    Toast.makeText(getApplicationContext(), "Cần nhập Password!", Toast.LENGTH_SHORT).show();
                } else if(sRetyPass == null || sRetyPass.equals("")){
                    Toast.makeText(getApplicationContext(), "Cần nhập lại Password!", Toast.LENGTH_SHORT).show();
                } else if(!sRetyPass.equals(sPassword)){
                    Toast.makeText(getApplicationContext(), "Password nhập lại chưa đúng!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

                    intent.putExtra(KEY_USERNAME, sUsername);
                    intent.putExtra(KEY_PASSWORD, sPassword);

                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}