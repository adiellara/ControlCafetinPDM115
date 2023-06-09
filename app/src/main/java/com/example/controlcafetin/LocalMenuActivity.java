package com.example.controlcafetin;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LocalMenuActivity extends ListActivity {

    String[] menu={"Insertar Local","Eliminar Local","Consultar Local",
            "Actualizar Local"};
    String[]
            activities={"LocalInsertarActivity","LocalEliminarActivity","LocalConsultarActivity",
            "LocalActualizarActivity"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = getListView();
        listView.setBackgroundColor(Color.rgb(253, 215, 248));
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);

        String nombreValue=activities[position];

        l.getChildAt(position).setBackgroundColor(Color.rgb(206, 206, 255));

        try{
            Class<?> clase=Class.forName("com.example.controlcafetin."+nombreValue);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
