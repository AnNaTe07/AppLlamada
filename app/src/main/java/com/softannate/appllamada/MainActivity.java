package com.softannate.appllamada;

import static android.Manifest.permission.CALL_PHONE;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Llamada llama;
    private AppCompatActivity binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solicitarPermiso();
        llama = new Llamada();

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(llama,new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));//cadena que identifica la accion, en documentacion de android
        //registerReceiver(llama,new IntentFilter("android.net.wifi.STATE_CHANGE"));//cadena que identifica la accion, en documentacion de android

    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(llama);//para desvincular el broadcast
    }

    private void solicitarPermiso(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && checkSelfPermission(CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{CALL_PHONE},1000);
        }
    }
}