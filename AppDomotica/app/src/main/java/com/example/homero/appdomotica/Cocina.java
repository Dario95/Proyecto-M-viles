package com.example.homero.appdomotica;

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
 * {@link Cocina.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Cocina#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cocina extends Fragment {

    private ToggleButton luz;
    private ToggleButton cocina;
    private ToggleButton radio;
    Boolean datosBackend[] = new Boolean[3];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vista = inflater.inflate(R.layout.fragment_cocina, container, false);
        obtenerDatosBackend();
        luz = (ToggleButton)vista.findViewById(R.id.tglCocinaLuz);
        luz.setChecked(datosBackend[0]);
        cocina = (ToggleButton)vista.findViewById(R.id.tglCocinaCocina);
        cocina.setChecked(datosBackend[1]);
        radio = (ToggleButton)vista.findViewById(R.id.tglCocinaRadio);
        radio.setChecked(datosBackend[2]);

        luz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(datosBackend[0]){
                    Toast.makeText(vista.getContext(),"Luz 1 "+luz.getText(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(vista.getContext(),"Luz 1 "+luz.getText(),Toast.LENGTH_LONG).show();
                }
                datosBackend[0]=!datosBackend[0];
            }

        });

        cocina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(datosBackend[1]){
                    Toast.makeText(vista.getContext(),"Cocina "+ cocina.getText(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(vista.getContext(),"Cocina "+ cocina.getText(),Toast.LENGTH_LONG).show();
                }
                datosBackend[1]=!datosBackend[1];
            }

        });

        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(datosBackend[2]){
                    Toast.makeText(vista.getContext(),"Radio "+ radio.getText(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(vista.getContext(),"Radio "+ radio.getText(),Toast.LENGTH_LONG).show();
                }
                datosBackend[2]=!datosBackend[2];
            }

        });

        return vista;
    }

    void obtenerDatosBackend(){
        Random rnd = new Random();
        datosBackend[0] = rnd.nextBoolean();
        datosBackend[1] = rnd.nextBoolean();
        datosBackend[2] = rnd.nextBoolean();

    }


}
