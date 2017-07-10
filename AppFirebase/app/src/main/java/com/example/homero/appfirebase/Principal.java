package com.example.homero.appfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class Principal extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
private GoogleApiClient googleApiClient;
    private static final int CODIGO = 777;
SignInButton sigInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        GoogleSignInOptions gso =
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();
        //keytool -list -v -keystore "%USERPROFILES%\.android\debug.keystore" -alias androiddebugkey -store android -keypass android
        sigInButton = (SignInButton)findViewById(R.id.signInButton);
        sigInButton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,CODIGO);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODIGO){
            GoogleSignInResult googleSignInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            logeo(googleSignInResult);
        }
    }
    public void logeo(GoogleSignInResult googleSignInResult){
        if(googleSignInResult.isSuccess()){
            abrirPantallaPrincipal();
        }else{
            Toast.makeText(this, "No se puede iniciar sesion", Toast.LENGTH_LONG).show();
        }
    }

    public void abrirPantallaPrincipal(){
        Intent intent = new Intent(this,Loggeado.class);
        startActivity(intent);
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
