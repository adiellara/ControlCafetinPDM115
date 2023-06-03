package com.example.controlcafetin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LocalEliminarActivity extends Activity {
    EditText editDui;
    ControlBD controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_eliminar);
        controlhelper=new ControlBD (this);
        editDui=(EditText)findViewById(R.id.editDui);
    }

    public void eliminarLocal(View v){
        String regEliminadas;
        Local local=new Local();
        local.setDui(editDui.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(local);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}