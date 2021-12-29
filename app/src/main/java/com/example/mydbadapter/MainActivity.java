package com.example.mydbadapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nom,ville;
    Button insert, afficher;
    com.example.mydbadapter.DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom=findViewById(R.id.nom);
        ville=findViewById(R.id.ville);
        insert=findViewById(R.id.inserer);
        afficher=findViewById(R.id.afficher);
        db=new com.example.mydbadapter.DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomtxt=nom.getText().toString();
                String villetxt=ville.getText().toString();

                Boolean checkinsert = db.insertuserdata(nomtxt,villetxt);
                if(checkinsert==true) {
                    Toast.makeText(MainActivity.this, "insertion valide", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "insertion non valide", Toast.LENGTH_LONG).show();
                }


            }
        });

        afficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity2.class));


            }
        });


    }
}