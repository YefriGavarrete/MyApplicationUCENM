package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Activitylist;


public class ActividadPrincipal extends AppCompatActivity {
    Button btnadd, btnspinner, btnlista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);

        btnadd = (Button) findViewById(R.id.btnadd);
        btnspinner = (Button) findViewById(R.id.btnspinner);


        btnadd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }

        });

        btnspinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent  = new Intent(getApplicationContext(), ActivitySpinner.class);
                startActivity(intent);
            }

        });
        btnlista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent  = new Intent(getApplicationContext(), Activitylist.class);
                startActivity(intent);
            }

        });
    }
}