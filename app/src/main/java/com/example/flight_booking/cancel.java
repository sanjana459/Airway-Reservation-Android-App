package com.example.flight_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class cancel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);

        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");

        ListView listView;
        myDatabaseHelper db = new myDatabaseHelper(this);
        ArrayList<String> arr_list = db.getHistory(username,password);
        String[] arr = new String[arr_list.size()];

        for(int i=0;i<arr_list.size();i++)
        {
            arr[arr_list.size()-i-1] = arr_list.get(i);
            arr[arr_list.size()-i-1] +="\n\n\t\t\t\t\t\tCANCEL";
        }


        listView = findViewById(R.id.history);
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(ad);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String s = adapterView.getItemAtPosition(i).toString();
            String updatedString = s.replaceAll("\\n\\n\\t\\t\\t\\t\\t\\tCANCEL$", "");
            int a = db.delete(username,password,updatedString);
            if(a == 0 )
                Toast.makeText(this, "Cancelled Successfully !!!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Cancel Failed", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}