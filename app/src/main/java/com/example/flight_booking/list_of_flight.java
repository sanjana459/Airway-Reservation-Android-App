package com.example.flight_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class list_of_flight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_flight);

        TextView indigo = findViewById(R.id.indigo);
        TextView airasia = findViewById(R.id.airasia);
        TextView spicejet = findViewById(R.id.spicejet);

        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
        String from = getIntent().getStringExtra("from");
        String to = getIntent().getStringExtra("to");
        String date = getIntent().getStringExtra("date");

        indigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = indigo.getText().toString();
                s += "\nFrom : "+from+"\nTo : "+to+"\nDate : "+date;
                Intent intent = new Intent(list_of_flight.this,book_final.class);
                intent.putExtra("value",s);
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
        airasia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = airasia.getText().toString();
                s += "\nFrom : "+from+"\nTo : "+to+"\nDate : "+date;
                Intent intent = new Intent(list_of_flight.this,book_final.class);
                intent.putExtra("value",s);
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
        spicejet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = spicejet.getText().toString();
                s += "\nFrom : "+from+"\nTo : "+to+"\nDate : "+date;
                Intent intent = new Intent(list_of_flight.this,book_final.class);
                intent.putExtra("value",s);
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }
}