package id.kaf.qrcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnWorkshop, btnTalkshow, btnSeminar , btnSertifikat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWorkshop    = findViewById(R.id.btn_workshop);
        btnTalkshow    = findViewById(R.id.btn_talkshow);
        btnSeminar     = findViewById(R.id.btn_seminar);
        btnSertifikat  = findViewById(R.id.btn_sertifikat);

        btnWorkshop.setOnClickListener(this);
        btnTalkshow.setOnClickListener(this);
        btnSeminar.setOnClickListener(this);
        btnSertifikat.setOnClickListener(this);

        btnWorkshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Workshop.class);
                startActivity(i);
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_workshop:
                Intent workshop = new Intent(MainActivity.this, Workshop.class);
                startActivity(workshop);
                break;
            case R.id.btn_talkshow:
                Intent talkshow = new Intent(MainActivity.this, Talkshow.class);
                startActivity(talkshow);
                break;
            case R.id.btn_seminar:
                Intent seminar = new Intent(MainActivity.this, Seminar.class);
                startActivity(seminar);
                break;
            case R.id.btn_sertifikat:
                Intent sertifikat = new Intent(MainActivity.this, Sertifikat.class);
                startActivity(sertifikat);
        }
    }



}