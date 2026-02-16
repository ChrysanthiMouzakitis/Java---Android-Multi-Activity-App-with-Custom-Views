package com.example.customrecyclerlist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    TextView nameTV, imageTV, descriptionTV, descriptionTV2,  ingredientTV, ingredientTV2, instructionTV, instructionTV2;
    Food food = null;
    Button webInfoBT = null;
    Button backToHomeBT = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // wire
        nameTV = findViewById(R.id.nameTextView);
        descriptionTV = findViewById(R.id.descriptionTextView);
        descriptionTV2 = findViewById(R.id.descriptionTextView2);
        ingredientTV = findViewById(R.id.ingredientsTextView);
        ingredientTV2 = findViewById(R.id.ingredientsTextView2);
        instructionTV = findViewById(R.id.instructionsTextView);
        instructionTV2 = findViewById(R.id.instructionsTextView2);

        webInfoBT = findViewById(R.id.button1);
        backToHomeBT = findViewById(R.id.button2);


        //get data
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        food = (Food) bundle.getSerializable("food");

        // populate widgets with data
        nameTV.setText(food.getName() + " Recipe");


        descriptionTV2.setText(food.getDescription());
        ingredientTV2.setText(food.getIngredients());
        instructionTV2.setText(food.getInstruction());


        // button events
        webInfoBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", food.getUrl());
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        backToHomeBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // make an explicit intent and a bundle
                Intent intent = new Intent(DetailsActivity.this, FoodActivity.class);
                Bundle bundle = new Bundle();

                // put the data into the bundle and the bundle into te intent
                bundle.putSerializable("food", food);
                intent.putExtras(bundle);

                // start activity
                startActivity(intent);

            }
        });

    }

}











