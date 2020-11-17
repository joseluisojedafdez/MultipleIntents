package com.i4bchile.multipleitems;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    boolean cargaImagen=false;
    Button sacarFoto;
    Button avanzar;
    ImageView imagenACargar;
    Intent takePictureIntent;

    private void dispatchTakePictureIntent() {
        takePictureIntent = new
                Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imagenACargar.setImageBitmap(imageBitmap);
        }
    }

    private void iniciarBotones() {

        sacarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
                cargaImagen=true;



            }
        });
        avanzar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (cargaImagen==true) {
                String website="https://desafiolatam.com";
                Intent resultadoActividad= new Intent(getApplication().
                        getBaseContext().
                        getApplicationContext(),
                        ResultActivity.class);
                resultadoActividad.putExtra( "WEBSITE" ,website);
                resultadoActividad.putExtra("IMAGEN CARGADA",cargaImagen);
                startActivity(resultadoActividad);

            }
            else {
                Toast.makeText(getApplicationContext(),"You should upload a picture before continuing", Toast.LENGTH_SHORT).show();

            }
        }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagenACargar=findViewById(R.id.img_ImagenCargada);
        sacarFoto = findViewById(R.id.bt_CargarImagen);
        avanzar=findViewById(R.id.bt_next);
        iniciarBotones();



    }
}