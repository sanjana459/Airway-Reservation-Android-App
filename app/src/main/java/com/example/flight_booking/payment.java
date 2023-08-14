package com.example.flight_booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView gpay = findViewById(R.id.gpay);
        TextView phonepe = findViewById(R.id.phonepe);
        TextView paytm = findViewById(R.id.paytm);
        TextView credpay = findViewById(R.id.credpay);
        Button pay = findViewById(R.id.pay);

        gpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gpay.setText("Pay Using");
                gpay.setBackground(Drawable.createFromPath("@drawable/grey"));
            }
        });
        phonepe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phonepe.setText("Pay Using");
                phonepe.setBackground(Drawable.createFromPath("@drawable/grey"));
            }
        });
        paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paytm.setText("Pay Using");
                paytm.setBackground(Drawable.createFromPath("@drawable/grey"));
            }
        });
        credpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credpay.setText("Pay Using");
                credpay.setBackground(Drawable.createFromPath("@drawable/grey"));
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(payment.this, "Paid Successfully!!!", Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(payment.this,mainscreen.class);
//                startActivity(intent);
            }
        });
    }
}