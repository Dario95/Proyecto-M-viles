package com.example.homero.appdomotica;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Sala.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Sala#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sala extends Fragment {
    private ToggleButton luz1;
    private ToggleButton luz2;
    private ToggleButton ventilador;
    private ToggleButton tv;
    Boolean datosBackend[] = new Boolean[4];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View vista = inflater.inflate(R.layout.fragment_sala, container, false);
        obtenerDatosBackend();
        luz1 = (ToggleButton)vista.findViewById(R.id.tglBtnLuz1);
        luz1.setChecked(datosBackend[0]);
        luz2 = (ToggleButton)vista.findViewById(R.id.tglBtnLuz2);
        luz2.setChecked(datosBackend[1]);
        ventilador = (ToggleButton)vista.findViewById(R.id.tglBtnVentilador);
        ventilador.setChecked(datosBackend[2]);
        tv = (ToggleButton)vista.findViewById(R.id.tglBtnTv);
        tv.setChecked(datosBackend[3]);


        luz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(datosBackend[0]){
                    Toast.makeText(vista.getContext(),"Luz 1 "+luz1.getText(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(vista.getContext(),"Luz 1 "+luz1.getText(),Toast.LENGTH_LONG).show();
                }
                datosBackend[0]=!datosBackend[0];
            }

        });

        luz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(datosBackend[1]){
                    Toast.makeText(vista.getContext(),"Luz 2 "+luz2.getText(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(vista.getContext(),"Luz 2 "+luz2.getText(),Toast.LENGTH_LONG).show();
                }
                datosBackend[1]=!datosBackend[1];
            }

        });

        ventilador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(datosBackend[2]){
                    Toast.makeText(vista.getContext(),"Ventilador "+ventilador.getText(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(vista.getContext(),"Ventilador "+ventilador.getText(),Toast.LENGTH_LONG).show();
                }
                datosBackend[2]=!datosBackend[2];
            }

        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(datosBackend[3]){
                    Toast.makeText(vista.getContext(),"Tv "+tv.getText(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(vista.getContext(),"Tv "+tv.getText(),Toast.LENGTH_LONG).show();
                }
                datosBackend[3]=!datosBackend[3];
            }

        });
        return vista;
    }
    void obtenerDatosBackend(){
        Random rnd = new Random();
        datosBackend[0] = rnd.nextBoolean();
        datosBackend[1] = rnd.nextBoolean();
        datosBackend[2] = rnd.nextBoolean();
        datosBackend[3] = rnd.nextBoolean();

    }


}
