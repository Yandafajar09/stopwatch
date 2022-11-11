package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    TextView textTimeResult;
    int pressTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textTimeResult = (TextView) findViewById(R.id.textHasil);
        pressTime = 0;
        //bagian ini mengambil data dari extra yang dikirim dari stopWatch
        activity
        Intent iResult = getIntent();
        Bundle b = iResult.getExtras();
        //Memeriksa apakah intent memiliki ekstra
        if(b!=null) {
            String timeResult = (String) b.get("resultTime");
            if (timeResult != null) {
                textTimeResult.setText("Catatan Waktu \n " + timeResult);
            } else {
                textTimeResult.setText("Catatan Waktu \n " + "00:00:00");
            }
        }
    }
    public void pindah (View v){
        Intent i = new Intent(this, StopWatch.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed(){
        if(pressTime == 0){
            Toast t = Toast.makeText(this, "Tekan tombol kembali untukkeluar", Toast.LENGTH_SHORT);
                    t.show();
            pressTime = pressTime+1;
        }else{
            finish();
            super.onBackPressed();
        }
    }



}

