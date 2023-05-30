package com.example.caloriecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // odbieranie danych z poprzedniego widoku
        Bundle bundle = getIntent().getExtras();
        double calories = bundle.getDouble("calories");

        // wyświetlenie wyniku obliczeń
        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText("Total calories: " + calories);
    }
}
