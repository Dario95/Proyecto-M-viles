package com.example.homero.appdomotica;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class InformacionGeneral extends AppCompatActivity {
    private TextView lucesEncendidas;
    private TextView gastoMensual;
    private TextView tv;
    private TextView cocina;
    private TextView temperatura;
    private String datosBackend[] = new String[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_general);
       //obtener elementos del activity
        Button btnControl = (Button) findViewById(R.id.btnControl);
        lucesEncendidas = (TextView) findViewById(R.id.txtLuces);
        cocina = (TextView) findViewById(R.id.txtCocina);
        tv = (TextView) findViewById(R.id.txtTv);
        temperatura = (TextView) findViewById(R.id.txtTemp);
        gastoMensual = (TextView) findViewById(R.id.txtGasto);

        //Obtener datos del backend
        obtenerDatosBackend();

        //setTexts
        lucesEncendidas.setText(datosBackend[0]);
        cocina.setText(datosBackend[1]);
        tv.setText(datosBackend[2]);
        temperatura.setText(datosBackend[3]);
        gastoMensual.setText(datosBackend[4]);

        btnControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformacionGeneral.this, Principal.class);

                startActivity(intent);
            }

        });
    }

    void obtenerDatosBackend(){
        Random rnd = new Random();
        datosBackend[0]=rnd.nextInt(8)+"";

        if(rnd.nextBoolean()){
            datosBackend[1]="Encendida";
        }else{
            datosBackend[1]="Apagada";
        }

        if(rnd.nextBoolean()){
            datosBackend[2]=rnd.nextInt(2)+" encendida(s)";
        }else{
            datosBackend[2]="Apagadas";
        }
        datosBackend[3]=String.format("%.2f",(15*rnd.nextDouble()+13))+" ºC";
        datosBackend[4]=String.format("%.2f",1000*rnd.nextDouble())+" Kwh";

    }
}
