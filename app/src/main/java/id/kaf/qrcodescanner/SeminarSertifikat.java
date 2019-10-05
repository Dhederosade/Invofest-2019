package id.kaf.qrcodescanner;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import id.kaf.qrcodescanner.network.MyService;
import id.kaf.qrcodescanner.network.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeminarSertifikat extends AppCompatActivity implements View.OnClickListener {
    public static EditText kodeTiket;
    private Button btnSubmit, btnBack;

    private MyService service = ServiceGenerator.createService(MyService.class);
    private LinearLayout layoutSertifikatSeminar;
    private ProgressBar pgBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sertifikat_seminar);
        getSupportActionBar().setTitle("Sertifikat Seminar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnSubmit   = findViewById(R.id.btn_submit);
        btnBack     = findViewById(R.id.btn_back);
        kodeTiket   = findViewById(R.id.kode_tiket);
        layoutSertifikatSeminar = findViewById(R.id.layout_sertifikat_seminar);
        pgBar       = findViewById(R.id.progressBar);

        kodeTiket.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.kode_tiket:
                //cek permission camera
                if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.CAMERA}, 1);
                } else{
                    Intent intent = new Intent(SeminarSertifikat.this,
                            BarcodeScanner.class);
                    intent.putExtra("kategori", "seminar");
                    startActivity(intent);
                }

                break;
            case R.id.btn_submit:
                pgBar.setVisibility(View.VISIBLE);
                final String idTiket = String.valueOf(kodeTiket.getText());
                Call<String> call = service.sertifikat_seminar(idTiket);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        pgBar.setVisibility(View.GONE);
                        kodeTiket.setText("");
                        Snackbar snackbar = Snackbar.make(layoutSertifikatSeminar,
                                "Sukses untuk peserta: "+idTiket, Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        pgBar.setVisibility(View.GONE);
                        Snackbar snackbar = Snackbar.make(layoutSertifikatSeminar,
                                "Gagal : "+t, Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }
                });
                break;
            case R.id.btn_back:
                onBackPressed();
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
