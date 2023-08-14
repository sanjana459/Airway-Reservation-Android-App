package com.example.flight_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class check extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");

        ListView listView;
        myDatabaseHelper db = new myDatabaseHelper(this);
        ArrayList<String> arr_list = db.getHistory(username,password);
        String[] arr = new String[arr_list.size()];

        for(int i=0;i<arr_list.size();i++)
        {
            arr[arr_list.size()-i-1] = arr_list.get(i);
        }


        listView = findViewById(R.id.check);
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(ad);
    }
}