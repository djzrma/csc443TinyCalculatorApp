package com.kindustry.tinycalculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        symbolButtonActions();
    }

    //1 method call for all Symbol Buttons (saves repeated lines of code)
    private void symbolButtonActions(){
        // declarations used by each button
        EditText firstNumber = findViewById(R.id.firstNumberTextField);
        EditText secondNumber = findViewById(R.id.secondNumberTextField);
        TextView result = findViewById(R.id.resultTextView);
        double firstNumberDouble = Double.parseDouble(firstNumber.getText().toString());
        double secondNumberDouble = Double.parseDouble(secondNumber.getText().toString());
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        //onClick action for additionButton
        Button add = findViewById(R.id.additionSymbolButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //formating double to 2 decimal places
                double sumDouble = firstNumberDouble + secondNumberDouble;
                String sum = decimalFormat.format(sumDouble);
                result.setText(sum);
            }
        });

        //onClick action for subtractionButton
        Button subtract = findViewById(R.id.subtractionSymbolButton);
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double differenceDouble = firstNumberDouble - secondNumberDouble;
                String difference = decimalFormat.format(differenceDouble);
                result.setText(difference);
            }
        });

        //onClick action for multiplicationButton
        Button multiply = findViewById(R.id.multiplicationSymbolButton);
         multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double productDouble = firstNumberDouble * secondNumberDouble;
                String product = decimalFormat.format(productDouble);
                result.setText(product);
            }
        });

        //onClick action for divisionButton
        Button divide = findViewById(R.id.divisionSymbolButton);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double quotientDouble = firstNumberDouble / secondNumberDouble;
                String quotient = decimalFormat.format(quotientDouble);
                result.setText(quotient);
            }
        });
    }
}