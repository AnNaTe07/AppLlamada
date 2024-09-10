package com.softannate.appllamada;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import java.net.URI;

public class Llamada extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        Boolean conectado = intent.getBooleanExtra("connected",false);
        if (conectado) {
           Intent intent1=new Intent(Intent.ACTION_CALL);
           intent1.setData(Uri.parse("tel:2664553747"));
           context.startActivity(intent1);
        }
    }
}