package com.example.dell.lavozdeljunco;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Contacto extends AppCompatActivity {
    public static final int MI_PERMISO=1;
    public static final int MI_PERMISODOS=1;
    Button b_call;
    Button b_calldos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        b_call= (Button) findViewById(R.id.b_contacto);

        b_calldos= (Button) findViewById(R.id.b_fijo);



        b_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent icall= new Intent(Intent.ACTION_CALL, Uri.parse("tel: +50497709696"));
                if (ActivityCompat.checkSelfPermission(Contacto.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){

                    if (ActivityCompat.shouldShowRequestPermissionRationale(Contacto.this, Manifest.permission.CALL_PHONE)){
                        new SweetAlertDialog(Contacto.this, SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("Atencion!")
                                .setContentText("Debe otorgar permisos para realizar llamadas")
                                .setConfirmText("Solicitar permisos")
                                .setCancelText("Cancelar")
                                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        sweetAlertDialog.cancel();
                                    }
                                })
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        sweetAlertDialog.cancel();
                                        ActivityCompat.requestPermissions(Contacto.this, new String[] {Manifest.permission.CALL_PHONE}, MI_PERMISO);
                                    }
                                })
                                .show();
                    }else{
                        ActivityCompat.requestPermissions(Contacto.this, new String[] {Manifest.permission.CALL_PHONE}, MI_PERMISO);
                    }


                }else{
                    startActivity(icall);
                }

            }

        });


        //LLAMADA AL FIJO

        b_calldos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent icall= new Intent(Intent.ACTION_CALL, Uri.parse("tel: +50426432525"));
                if (ActivityCompat.checkSelfPermission(Contacto.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){

                    if (ActivityCompat.shouldShowRequestPermissionRationale(Contacto.this, Manifest.permission.CALL_PHONE)){
                        new SweetAlertDialog(Contacto.this, SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("Atencion!")
                                .setContentText("Debe otorgar permisos para realizar llamadas")
                                .setConfirmText("Solicitar permisos")
                                .setCancelText("Cancelar")
                                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        sweetAlertDialog.cancel();
                                    }
                                })
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        sweetAlertDialog.cancel();
                                        ActivityCompat.requestPermissions(Contacto.this, new String[] {Manifest.permission.CALL_PHONE}, MI_PERMISO);
                                    }
                                })
                                .show();
                    }else{
                        ActivityCompat.requestPermissions(Contacto.this, new String[] {Manifest.permission.CALL_PHONE}, MI_PERMISO);
                    }


                }else{
                    startActivity(icall);
                }
            }
        });


    }
}
