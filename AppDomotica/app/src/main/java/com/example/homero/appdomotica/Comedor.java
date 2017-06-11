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
 * {@link Comedor.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Comedor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Comedor extends Fragment {

    private ToggleButton luz;
    private ToggleButton luz2;
    Boolean datosBackend[] = new Boolean[2];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vista = inflater.inflate(R.layout.fragment_comedor, container, false);
        obtenerDatosBackend();
        luz = (ToggleButton)vista.findViewById(R.id.tglComedorLuz);
        luz.setChecked(datosBackend[0]);
        luz2 = (ToggleButton)vista.findViewById(R.id.tglComedorLuz2);
        luz2.setChecked(datosBackend[1]);

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

        luz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(datosBackend[1]){
                    Toast.makeText(vista.getContext(),"Luz 2 "+ luz2.getText(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(vista.getContext(),"Luz 2 "+ luz2.getText(),Toast.LENGTH_LONG).show();
                }
                datosBackend[1]=!datosBackend[1];
            }

        });



        return vista;
    }

    void obtenerDatosBackend(){
        Random rnd = new Random();
        datosBackend[0] = rnd.nextBoolean();
        datosBackend[1] = rnd.nextBoolean();

    }


}
