package com.hoangdai.lab5_ph36944;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class WellcomeMainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView txtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome_main);
        //gắn animation vào activity
        imageView=findViewById(R.id.imageView);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.lab711);
        imageView.startAnimation(animation);
        txtv=findViewById(R.id.txtwellcome);
        Animation animation2=AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.lab712);
        txtv.startAnimation(animation2);

        //Chuyển sang activity khác sau 3 giây
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WellcomeMainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}