package com.i4bchile.multipleitems;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class ResultActivity extends AppCompatActivity {

    Button openWeb;
    Button shareInfo;
    String sitioWeb;
    boolean imagenCargada;

    private void iniciarBotones() {
        openWeb=findViewById(R.id.bt_openweb);
        shareInfo=findViewById(R.id.bt_ShareInfo);
        openWeb.setOnClickListener(new View.OnClickListener() {
                        @Override
            public void onClick(View v) {
                            String url=sitioWeb;
                            Intent abrirWeb = new Intent(Intent.ACTION_VIEW);
                            abrirWeb.setData(Uri.parse(url));
                            startActivity(abrirWeb);
            }
        });
        shareInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,sitioWeb);
                sendIntent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);


            }
        });
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle datosMainActivity = getIntent().getExtras();
        final String website = Objects.requireNonNull(datosMainActivity).getString( "WEBSITE" );
        sitioWeb=website;
        final boolean cargaImagen = Objects.requireNonNull(datosMainActivity).getBoolean( "IMAGEN CARGADA" );
        imagenCargada=cargaImagen;
        iniciarBotones();
    }
}