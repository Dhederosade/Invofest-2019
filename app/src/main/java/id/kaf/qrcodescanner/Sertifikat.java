package id.kaf.qrcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


import id.kaf.qrcodescanner.R;
import id.kaf.qrcodescanner.network.MyService;
import id.kaf.qrcodescanner.network.ServiceGenerator;

public class Sertifikat extends AppCompatActivity implements View.OnClickListener{
    private Button btnWorkshop, btnTalkshow, btnSeminar ,btnBack;
    private MyService service = ServiceGenerator.createService(MyService.class);
    private LinearLayout layoutSertifikat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sertifikat);
        btnWorkshop = findViewById(R.id.btn_workshop_sertifikat);
        btnTalkshow = findViewById(R.id.btn_talkshow_sertifikat);
        btnSeminar  = findViewById(R.id.btn_seminar_sertifikat);
        btnBack     = findViewById(R.id.btn_back);

        btnWorkshop.setOnClickListener(this);
        btnTalkshow.setOnClickListener(this);
        btnSeminar.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        btnWorkshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Sertifikat.this, WorkshopSertifikat.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_workshop_sertifikat:
                Intent workshop = new Intent(Sertifikat.this, WorkshopSertifikat.class);
                startActivity(workshop);
                break;
            case R.id.btn_talkshow_sertifikat:
                Intent talkshow = new Intent(Sertifikat.this, TalkshowSertifikat.class);
                startActivity(talkshow);
                break;
            case R.id.btn_seminar_sertifikat:
                Intent seminar = new Intent(Sertifikat.this, SeminarSertifikat.class);
                startActivity(seminar);
                break;
            case R.id.btn_back:
                onBackPressed();
                break;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
