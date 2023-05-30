package com.example.caloriecheck;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText ingredientNameEditText, ingredientAmountEditText;
    private Button addIngredientButton, calculateCaloriesButton;
    private RecyclerView ingredientListView;
    private TextView totalCaloriesTextView;

    public ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    public void addIngredient(Ingredient ingredient)
    {
        ingredients.add(ingredient);
    }


    private ArrayList<Ingredient> ingredientList;
    private IngredientAdapter ingredientAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views by ID
        ingredientNameEditText = findViewById(R.id.ingredientNameEditText);
        ingredientAmountEditText = findViewById(R.id.ingredientAmountEditText);
        addIngredientButton = findViewById(R.id.add_ingredient_button);
        calculateCaloriesButton = findViewById(R.id.calculateCaloriesButton);
        ingredientListView = findViewById(R.id.ingredientListView);
        totalCaloriesTextView = findViewById(R.id.resultTextView);

        // Initialize ingredient list and adapter
        ingredientList = new ArrayList<>();
        ingredientAdapter = new IngredientAdapter(this, ingredientList);
        ingredientListView.setAdapter(ingredientAdapter);

        // Set click listeners for buttons
        addIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddIngredientActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        calculateCaloriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotalCalories();
            }
        });
    }
    private void calculateTotalCalories() {
        double totalCalories = 0;
        for (Ingredient ingredient : ingredientList) {
            totalCalories += ingredient.getCalories();
        }
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("totalCalories", totalCalories);
        startActivity(intent);


    }
    addIngredient();



     //Inflate options menu
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //getMenuInflater().inflate(R.menu.main_menu, menu);
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
    //}

    // Handle options menu item clicks
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_clear:
//                clearIngredients();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

//    // Handle result of AddIngredientActivity
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1 && resultCode == RESULT_OK) {
//            String name = data.getStringExtra("name");
//            double amount = data.getDoubleExtra("amount", 0);
//            String unit = data.getStringExtra("unit");
//            double calories = data.getDoubleExtra("calories", 0);
//
//            Ingredient ingredient = new Ingredient(name, amount, unit, calories);
//            ingredientList.add(ingredient);
//            ingredientAdapter.notifyDataSetChanged();
//        }
//    }
//
//    // Calculate total calories and display on result activity
//
//
//    // Clear ingredient list and adapter
//    private void clearIngredients() {
//        ingredientList.clear();
//        ingredientAdapter.notifyDataSetChanged();
//    }
}

