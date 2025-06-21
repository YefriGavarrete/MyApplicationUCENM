package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Configuration.Personas;
import com.example.myapplication.Configuration.SqliteConexion;
import com.example.myapplication.Configuration.Transacciones;

import java.util.ArrayList;

public class ActivitySpinner extends AppCompatActivity {


    SqliteConexion conexion;
    //el Spinner se utiliza como un combobox
    Spinner combopersonas;
    EditText spnombres, spapellidos, spcorreo;
    ArrayList<Personas> lista;
    ArrayList<String> ArregloLista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);

        combopersonas = (Spinner) findViewById(R.id.spinner);
        spnombres = (EditText) findViewById(R.id.spnombres);
        spapellidos = (EditText) findViewById(R.id.spapellidos);
        spcorreo = (EditText) findViewById(R.id.spcorreo);
        conexion = new SqliteConexion(this, Transacciones.NameDB, null, 1);
        ObtenerDatos();

            ArrayAdapter<CharSequence> adp = new ArrayAdapter(this,
                    android.R.layout.simple_spinner_item,
                    ArregloLista);
        combopersonas.setAdapter(adp);

        combopersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                try{
                    spnombres.setText(lista.get(i).getNombres());
                    spapellidos.setText(lista.get(i).getApellidos());
                    spcorreo.setText(lista.get(i).getCorreo());


                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void ObtenerDatos()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas persona = null;
//        lista new ArrayList<Personas>();
        lista = new ArrayList<Personas>();
        Cursor cursor = db.rawQuery(Transacciones.SelectPersonas, null);


        while(cursor.moveToNext())
        {
            persona = new Personas();
            persona.setId(cursor.getInt(0));
            persona.setNombres(cursor.getString(1));
            persona.setApellidos(cursor.getString(2));
            persona.setCorreo(cursor.getString(3));
            persona.setTelefono(cursor.getString(4));

            lista.add(persona);

        }

        cursor.close();
        FillData();

    }


    private void FillData(){
        ArregloLista = new ArrayList<String>();
        for(int i = 0; i < ArregloLista.size(); i++){
            ArregloLista.add(lista.get(i).getNombres() + " |" +
                    lista.get(i).getApellidos());
        }

    }


}