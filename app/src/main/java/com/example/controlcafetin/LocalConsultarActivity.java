package com.example.controlcafetin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LocalConsultarActivity extends Activity {
    ControlBD helper;
    EditText editLocal;
    EditText editNombre;
    EditText editApellido;
    EditText editSexo;
    EditText editIdlocal;
    /** Called when the activity is first created. */
    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_consultar);
        helper = new ControlBD(this);
        editLocal = (EditText) findViewById(R.id.editLocal);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
        editSexo = (EditText) findViewById(R.id.editSexo);
        editIdlocal = (EditText) findViewById(R.id.editidlocal);
    }
    public void consultarLocal(View v) {
        helper.abrir();
        Local local =
                helper.consultarLocal(editLocal.getText().toString());
        helper.cerrar();
        if(local == null)
            Toast.makeText(this, "Local con local " +
                    editLocal.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editNombre.setText(local.getNombre());
            editApellido.setText(local.getApellido());
            editSexo.setText(local.getSexo());
            editIdlocal.setText(String.valueOf(local.getidlocal()));
        }
    }

    public void limpiarTexto(View v){
        editLocal.setText("");
        editNombre.setText("");
        editApellido.setText("");
        editSexo.setText("");
        editIdlocal.setText("");
    }
}
