package id.kaf.qrcodescanner;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class BarcodeScanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScanner;
    private String kategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scanner);

        Intent intent = getIntent();
        kategori = intent.getStringExtra("kategori");

        ViewGroup contentFrame = findViewById(R.id.content_frame);
        mScanner = new ZXingScannerView(this);
        contentFrame.addView(mScanner);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScanner.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScanner.setResultHandler(this);
        mScanner.startCamera();
    }

    @Override
    public void handleResult(Result result) {
        if(kategori.equals("workshop")){
            Workshop.kodeTiket.setText(result.getText());
        } else if(kategori.equals("seminar")){
            Seminar.kodeTiket.setText(result.getText());
        } else if(kategori.equals("talkshow")){
            Talkshow.kodeTiket.setText(result.getText());
        }
        this.finish();
    }
}
