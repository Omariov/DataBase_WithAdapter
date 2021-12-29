package com.example.mydbadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView lv=(ListView)findViewById(R.id.lv1);
        DBHelper db=new DBHelper(this);
        ArrayList<String> lst=new ArrayList<String>();
        lst=db.showAll();
        ArrayAdapter ad;
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lst));



    }

    public void back(View view) {
        finish();
    }
}