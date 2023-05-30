package com.example.caloriecheck;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder> {
    private List<Ingredient> ingredientList;

    public IngredientAdapter(MainActivity mainActivity, List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ingredient, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_spinner_item, parent, false);

        return new IngredientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        Ingredient ingredient = ingredientList.get(position);
        holder.bind(ingredient);
    }

    @Override
    public int getItemCount() {
        return ingredientList.size();
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientList.add(ingredient);
        notifyItemInserted(ingredientList.size() - 1);
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public class IngredientViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView amountTextView;

        public IngredientViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.ingredientNameEditText);
            amountTextView = itemView.findViewById(R.id.ingredientAmountEditText);
        }

        public void bind(Ingredient ingredient) {
            nameTextView.setText(ingredient.getName());
            amountTextView.setText(ingredient.getAmount() + " " + ingredient.getUnit());
        }
    }
}

