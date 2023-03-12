package com.example.convert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final double USD_TO_EUR = 0.94;
    private static final double USD_TO_MAD = 10.34;
    private static final double EUR_TO_USD = 1.06;
    private static final double EUR_TO_MAD = 11.01;
    private static final double MAD_TO_USD = 0.097;
    private static final double MAD_TO_EUR = 0.091;

    private Spinner convertFromSpinner;
    private Spinner convertToSpinner;
    private EditText enterAmountEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertFromSpinner = findViewById(R.id.convert_from_spinner);
        convertToSpinner = findViewById(R.id.convert_to_spinner);
        enterAmountEditText = findViewById(R.id.enter_amount_edit_text);
        resultTextView = findViewById(R.id.result_text_view);
        String[] currencyOptions = {"USD", "EUR", "MAD"};
        ArrayAdapter<String> convertFromAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencyOptions);
        ArrayAdapter<String> convertToAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencyOptions);

        convertFromSpinner.setAdapter(convertFromAdapter);
        convertToSpinner.setAdapter(convertToAdapter);
        Button convertButton = findViewById(R.id.convert_button);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });
    }
    private void convertCurrency() {
        String convertFrom = convertFromSpinner.getSelectedItem().toString();
        String convertTo = convertToSpinner.getSelectedItem().toString();


        double amountToConvert = Double.parseDouble(enterAmountEditText.getText().toString());

       //mousaab

        double convertedAmount;
        if (convertFrom.equals("USD")) {
            if (convertTo.equals("EUR")) {
                convertedAmount = amountToConvert * USD_TO_EUR;
            } else if (convertTo.equals("MAD")){
                convertedAmount = amountToConvert * USD_TO_MAD;
            }
            else {
                convertedAmount = amountToConvert;
            }
        } else if (convertFrom.equals("EUR")) {
            if (convertTo.equals("USD")) {
                convertedAmount = amountToConvert * EUR_TO_USD;
            } else if (convertTo.equals("MAD")){
                convertedAmount = amountToConvert * EUR_TO_MAD;
            }
            else{
                convertedAmount = amountToConvert;
            }
        } else {
            if (convertTo.equals("USD")) {
                convertedAmount = amountToConvert * MAD_TO_USD;
            } else if (convertTo.equals("EUR")){
                convertedAmount = amountToConvert * MAD_TO_EUR;
            }
            else{
                convertedAmount = amountToConvert;
            }
        }
        String resultText = String.format("%.2f", convertedAmount) + " " + convertTo;
        resultTextView.setText(resultText);


    }
    }


