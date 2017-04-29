package com.example.dell.lavozdeljunco;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.pm.ActivityInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class MainActivity extends AppCompatActivity {



    Button b_sintonizar;


    MediaPlayer mediaplay;

    boolean prepared = false;
    boolean started = false;


    String stream = "http://stream.playerlive.info:8040/lvj.aac";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//TODO STREAMING


        Toast.makeText(this, "Espere alrededor de 20 segundos,estamos sintonizando", Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        b_sintonizar = (Button) findViewById(R.id.b_sintonizar);
        b_sintonizar.setEnabled(false);
        b_sintonizar.setText("LOADING");

        mediaplay = new MediaPlayer();
        mediaplay.setAudioStreamType(AudioManager.STREAM_MUSIC);

        new PlayerTask().execute(stream);

        b_sintonizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (started) {
                    started = false;
                    mediaplay.pause();
                    b_sintonizar.setText("PLAY");
                } else {
                    started = true;
                    mediaplay.start();
                    b_sintonizar.setText("PAUSE");
                }




            }
        });


    }




    class PlayerTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {

            try {
                mediaplay.setDataSource(params[0]);
                mediaplay.prepare();
                prepared = true;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return prepared;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            mediaplay.start();
            b_sintonizar.setEnabled(true);
            b_sintonizar.setText("PLAY");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (started) {
            mediaplay.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (started) {
            mediaplay.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (prepared) {
            mediaplay.release();
        }
    }

    public void callhistory(View view){
        Intent i= new Intent(this, Historia.class);
        startActivity(i);
    }
    public void callprogra(View view){
        Intent URLprogra = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lavozdeljunco.com/programacion.php"));
        startActivity(URLprogra);
    }

    public void callface(View view){
        Intent URLface = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Radio-La-Voz-Del-JuncoSanta-B%C3%A2rbara-Honduras-259885350843007/?fref=ts"));
        startActivity(URLface);
    }

    public void callinsta(View view){
        Intent URLinsta = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/vozdeljunco54/?hl=es"));
        startActivity(URLinsta);
    }

    public void callhistoria(View view){
        Intent URLhistoria = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lavozdeljunco.com/historia.php"));
        startActivity(URLhistoria);
    }

    public void calldirectorio(View view){
        Intent URLdirectorio = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lavozdeljunco.com/djs.php"));
        startActivity(URLdirectorio);
    }



    public void callcall(View view){
        Intent i= new Intent(this, Contacto.class);
        startActivity(i);
    }



}
