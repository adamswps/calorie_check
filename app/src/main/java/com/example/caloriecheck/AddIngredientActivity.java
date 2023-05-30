package com.example.caloriecheck;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddIngredientActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText amountEditText;
    private Spinner unitSpinner;
    private Button addButton;
    private double calories;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient);

        nameEditText = findViewById(R.id.ingredientNameEditText);
        amountEditText = findViewById(R.id.ingredientAmountEditText);
        unitSpinner = findViewById(R.id.unitSpinner);
        addButton = findViewById(R.id.addIngredientButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unit_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSpinner.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String amountString = amountEditText.getText().toString();
                String unit = unitSpinner.getSelectedItem().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(amountString)) {
                    Toast.makeText(AddIngredientActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                double amount = Double.parseDouble(amountString);

                Ingredient ingredient = new Ingredient(name, amount,unit, calories);

                Intent intent = new Intent();
                intent.putExtra("ingredient", name);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
