package Lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.hoangdai.lab5_ph36944.R;

public class Lab72MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button btnfan,btnStop,btnFast,btnMedium;
    Button btnSlow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab72_main);
        imageView=findViewById(R.id.lab72img);
        btnfan=findViewById(R.id.lab72_btnfan);
        btnStop=findViewById(R.id.lab72_btnoff);
        btnFast=findViewById(R.id.lab72_btnfast);
        btnMedium=findViewById(R.id.lab72_btnmedium);
        btnSlow=findViewById(R.id.lab72_btnslow);
        btnfan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Định nghiã hành động quay
                Runnable runnable=new Runnable() {
                    @Override
                    public void run() {
                        imageView.animate()
                                .rotationBy(360)
                                .withEndAction(this)
                                .setDuration(900)
                                .setInterpolator(new LinearInterpolator())
                                .start();
                    }
                };
                //Cho image quay
                imageView.animate()
                        .rotationBy(360)
                        .withEndAction(runnable)
                        .setDuration(900)
                        .setInterpolator(new LinearInterpolator())
                        .start();
            }
        });

        btnSlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Định nghiã hành động quay
                Runnable runnable=new Runnable() {
                    @Override
                    public void run() {
                        imageView.animate()
                                .rotationBy(360)
                                .withEndAction(this)
                                .setDuration(700)
                                .setInterpolator(new LinearInterpolator())
                                .start();
                    }
                };
                //Cho image quay
                imageView.animate()
                        .rotationBy(360)
                        .withEndAction(runnable)
                        .setDuration(700)
                        .setInterpolator(new LinearInterpolator())
                        .start();
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Định nghiã hành động quay
                Runnable runnable=new Runnable() {
                    @Override
                    public void run() {
                        imageView.animate()
                                .rotationBy(360)
                                .withEndAction(this)
                                .setDuration(600)
                                .setInterpolator(new LinearInterpolator())
                                .start();
                    }
                };
                //Cho image quay
                imageView.animate()
                        .rotationBy(360)
                        .withEndAction(runnable)
                        .setDuration(600)
                        .setInterpolator(new LinearInterpolator())
                        .start();
            }
        });

        btnFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Định nghiã hành động quay
                Runnable runnable=new Runnable() {
                    @Override
                    public void run() {
                        imageView.animate()
                                .rotationBy(360)
                                .withEndAction(this)
                                .setDuration(400)
                                .setInterpolator(new LinearInterpolator())
                                .start();
                    }
                };
                //Cho image quay
                imageView.animate()
                        .rotationBy(360)
                        .withEndAction(runnable)
                        .setDuration(400)
                        .setInterpolator(new LinearInterpolator())
                        .start();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.animate().cancel();
            }
        });
    }
}