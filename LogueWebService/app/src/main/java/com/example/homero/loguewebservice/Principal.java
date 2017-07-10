package com.example.homero.loguewebservice;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class Principal extends AppCompatActivity {
    Button ingresar;
    Handler handler = new Handler();
    EditText usuario;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        ingresar = (Button)findViewById(R.id.btnIngresar);
        usuario = (EditText)findViewById(R.id.editText);
        pass = (EditText)findViewById(R.id.editText2);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"192.17",Toast.LENGTH_LONG).show();
                new WebServicesSOAP().execute(usuario.getText().toString(),pass.getText().toString());
            }
        });
    }

    private class WebServicesSOAP extends AsyncTask{

        private final String NAMESPACE = "http://epn.soap.com/";
        private final String NOMBREMETODO = "logeo";
        private final String URI = "http://172.29.11.68:24220/ClaseSoapitoService/ClaseSoapito?WSDL";
        private final String ACCION_SOAP = NAMESPACE+NOMBREMETODO;
        private String respuesta = "";

        @Override
        protected Object doInBackground(Object[] params){
            System.out.print("Entre"+params[0]);
            final SoapObject request = new SoapObject(NAMESPACE,NOMBREMETODO);

            request.addProperty("user",params[0]);
            request.addProperty("password",params[1]);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
            envelope.dotNet = false;
            envelope.setOutputSoapObject(request);

            //
            HttpTransportSE transportSE = new HttpTransportSE(URI);
            try {
                transportSE.call(ACCION_SOAP,envelope);
                //Respuesta del web service
                SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
                respuesta = response.toString();


                //rutina
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mostrarMensaje(respuesta);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
            return respuesta;
        }

    }
    public void mostrarMensaje(String mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }
}
