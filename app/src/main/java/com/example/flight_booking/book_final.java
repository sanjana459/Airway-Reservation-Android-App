package com.example.flight_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class book_final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_final);

        myDatabaseHelper dbHelper = new myDatabaseHelper(this);

        String s = getIntent().getStringExtra("value");
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");

        TextView t = findViewById(R.id.value);
        t.setText(s);

        Button book = findViewById(R.id.book);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int b = dbHelper.insert_history(username,password,s);
                if(b == 0) {
                    Intent intent = new Intent(book_final.this,payment.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(book_final.this, "Booking Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }
}