package com.example.controlcafetin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LocalInsertarActivity extends Activity {
    ControlBD helper;
    EditText editDui;
    EditText editNombre;
    EditText editApellido;
    EditText editSexo;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_insertar);
        helper = new ControlBD(this);
        editDui = (EditText) findViewById(R.id.editDui);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
        editSexo = (EditText) findViewById(R.id.editSexo);
    }
    public void insertarLocal(View v) {
        String dui=editDui.getText().toString();
        String nombre=editNombre.getText().toString();
        String apellido=editApellido.getText().toString();
        String sexo=editSexo.getText().toString();
        String regInsertados;
        Local local=new Local();
        local.setDui(dui);
        local.setNombre(nombre);
        local.setApellido(apellido);
        local.setSexo(sexo);
        local.setidlocal(0);
        helper.abrir();
        regInsertados=helper.insertar(local);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();

    }
    public void limpiarTexto(View v) {
        editDui.setText("");
        editNombre.setText("");
        editApellido.setText("");
        editSexo.setText("");
    }
}