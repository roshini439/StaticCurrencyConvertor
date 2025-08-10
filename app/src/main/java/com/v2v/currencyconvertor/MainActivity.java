package com.v2v.currencyconvertor;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputAmount;
    Button btnUsdToInr, btnInrToUsd;
    TextView resultText;

    // Fixed conversion rate
    final double USD_TO_INR = 83.0; // Example rate
    final double INR_TO_USD = 1 / USD_TO_INR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputAmount = findViewById(R.id.inputAmount);
        btnUsdToInr = findViewById(R.id.btnUsdToInr);
        btnInrToUsd = findViewById(R.id.btnInrToUsd);
        resultText = findViewById(R.id.resultText);

        btnUsdToInr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUsdToInr();
            }
        });

        btnInrToUsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertInrToUsd();
            }
        });
    }

    private void convertUsdToInr() {
        String input = inputAmount.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show();
            return;
        }
        double usd = Double.parseDouble(input);
        double inr = usd * USD_TO_INR;
        resultText.setText(String.format("%.2f USD = %.2f INR", usd, inr));
    }

    private void convertInrToUsd() {
        String input = inputAmount.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show();
            return;
        }
        double inr = Double.parseDouble(input);
        double usd = inr * INR_TO_USD;
        resultText.setText(String.format("%.2f INR = %.2f USD", inr, usd));
    }
}
