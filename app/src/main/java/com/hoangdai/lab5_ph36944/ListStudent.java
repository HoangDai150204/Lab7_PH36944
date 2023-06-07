package com.hoangdai.lab5_ph36944;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class ListStudent extends AppCompatActivity {
    ListView lvstudent;
    Button btnadd;
    StudentListViewAdapter studentListViewAdapter;
    SearchView searchView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liststudent);
        lvstudent = findViewById(R.id.lvstudent);
        Toolbar toolbar = findViewById(R.id.lab61Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ArrayList<Student> arrst = new ArrayList<>();
        arrst.add(new Student("Hà Nội", "Nguyễn Văn A", "Hà Nội"));
        arrst.add(new Student("Đà Nẵng", "Nguyễn Thị B", "Đà Nẵng"));
        arrst.add(new Student("Tây Nguyên", "Hoàng Đình C", "Tây Nguyên"));
        arrst.add(new Student("Hồ Chí Minh", "Nguyễn Đình D", "Vĩnh Long"));
        arrst.add(new Student("Cần Thơ", "Trương Thị H", "Huế"));

        studentListViewAdapter = new StudentListViewAdapter(this, arrst);
        lvstudent.setAdapter(studentListViewAdapter);


        ActivityResultLauncher<Intent> getData = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()==2){
                            Intent intent=result.getData();//lấy về dữ liệu
                            Bundle bundle=intent.getExtras();//lấy về gói
                            String name = bundle.getString("name");
                            String address = bundle.getString("address");
                            String branch = bundle.getString("branch");
                            arrst.add(new Student(branch, name, address));
                            studentListViewAdapter.notifyDataSetChanged();
                        }
                    }
                }
        );

        //xử lý sự kiện
            btnadd = findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListStudent.this, AddStudent.class);
                getData.launch(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.lab61_menu,menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.search);
        searchView=(SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                studentListViewAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                studentListViewAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.lab61MenuDangXuat){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }else if(item.getItemId()==R.id.addst){
            Intent intent = new Intent(ListStudent.this, AddStudent.class);
            startActivity(intent);
        } else if(item.getItemId()==R.id.lab61MenuBangDiem){
            Toast.makeText(getApplicationContext(), "Bảng Điểm", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.lab61MenuDiemDanh){
            Toast.makeText(getApplicationContext(), "Điểm Danh", Toast.LENGTH_SHORT).show();
        } else if(item.getItemId()==R.id.lab61MenuLichHoc){
            Toast.makeText(getApplicationContext(), "Lịch Học", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
