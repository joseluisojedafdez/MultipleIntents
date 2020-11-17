package com.i4bchile.multipleitems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    Button openWeb;
    Button shareInfo;

    private void iniciarBotones() {
        openWeb=findViewById(R.id.bt_openweb);
        shareInfo=findViewById(R.id.bt_ShareInfo);
        openWeb.setOnClickListener(new View.OnClickListener() {
                        @Override
            public void onClick(View v) {
                // aqui abre www.desafiolatam.com
            }
        });
        shareInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui abre un intent para compartir
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        iniciarBotones();
    }
}