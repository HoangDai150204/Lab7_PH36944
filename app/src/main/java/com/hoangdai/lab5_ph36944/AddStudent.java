package com.hoangdai.lab5_ph36944;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddStudent extends AppCompatActivity {
    String selectedItemSpinner = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstudent);

        Spinner spinner_coso = findViewById(R.id.spinner_coso);
        Button btnsubmit = findViewById(R.id.btnsubmit);
        EditText edt_name = findViewById(R.id.edtname);
        EditText edt_address = findViewById(R.id.edtaddress);

        ArrayList<School> list = new ArrayList<>();
        list.add(new School(R.drawable.ic_hanoi, "Hà Nội"));
        list.add(new School(R.drawable.ic_dannang, "Đà Nẵng"));
        list.add(new School(R.drawable.ic_taynguyen, "Tây Nguyên"));
        list.add(new School(R.drawable.ic_tphcm, "Hồ Chí Minh"));
        list.add(new School(R.drawable.ic_cantho, "Cần Thơ"));

        SchoolSpinnerAdapter schoolSpinnerAdapter = new SchoolSpinnerAdapter(this, list);
        spinner_coso.setAdapter(schoolSpinnerAdapter);

        //xử lý sự kiện khi người dùng chọn spinner
        spinner_coso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItemSpinner=((School)spinner_coso.getItemAtPosition(position)).getName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //xử lý sự kiện submit
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("name",edt_name.getText().toString());
                bundle.putString("address",edt_address.getText().toString());
                bundle.putString("branch", selectedItemSpinner);
                intent.putExtras(bundle);
                setResult(2, intent);
                finish();
            }
        });
    }
}