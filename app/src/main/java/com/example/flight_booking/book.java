package com.example.flight_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicReference;


public class book extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");

        Button search = findViewById(R.id.search);
        MultiAutoCompleteTextView from = findViewById(R.id.from);
        MultiAutoCompleteTextView to = findViewById(R.id.to);
        DatePicker date = findViewById(R.id.date);

        String[] suggestion = {"Bangalore","Delhi","Mumbai","Jaipur","Kolkata","Chennai","Hyderabad","Goa","Surat","Jodhpur","Kashmir","Patna","Ranchi","Bhubaneshwar","Udaipur","Mangalore","Lucknow","Ahmedabad"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,suggestion);
        from.setAdapter(adapter);
        to.setAdapter(adapter);

        from.setTokenizer(new SpaceTokenizer());
        to.setTokenizer(new SpaceTokenizer());


        int year, month, dayofmonth;
        Calendar calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        dayofmonth = calendar.get(Calendar.DAY_OF_MONTH);
        AtomicReference<String> selectedDate = new AtomicReference<>("");
        date.init(year, month, dayofmonth, (view, year1, monthOfYear, dayOfMonth) -> {
            selectedDate.set(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1);
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String from_ = from.getText().toString();
                String to_ = to.getText().toString();
                if(from_.equals(to_))
                {
                    Toast.makeText(book.this,"From and To cannot be same Address!!!", Toast.LENGTH_SHORT).show();
                }
                else {

                    String date_ = selectedDate.get();
                    Intent intent = new Intent(book.this, list_of_flight.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    intent.putExtra("from", from_);
                    intent.putExtra("to", to_);
                    intent.putExtra("date", date_);
                    startActivity(intent);
                }
            }
        });

    }
}