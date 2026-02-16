package com.example.customrecyclerlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FoodActivity extends AppCompatActivity {

    TextView foodTV = null;

    TextView header = null;
    TextView foodTV2 = null;
    ImageView foodIM = null;
    Button moreInfoBT = null;
    Button backToHomeBT = null;

    Food food = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_food);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // wire
        foodIM = findViewById(R.id.imageView);
        header = findViewById(R.id.textView1);
        foodTV = findViewById(R.id.textView);
        foodTV2 = findViewById(R.id.textView2);
        moreInfoBT = findViewById(R.id.button);
        backToHomeBT = findViewById(R.id.button2);

        // get data
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        food = (Food)bundle.getSerializable("food");


        // populate object with data
        header.setText(food.getName()+" Recipe");
        foodTV.setText(food.getIngredients());
        foodTV2.setText("Ingredients: ");

        String imageName = food.getImage();
        imageName = imageName.substring(0,imageName.indexOf("."));
        int imageId = this.getResources().getIdentifier(imageName, "drawable", getPackageName());
        foodIM.setImageResource(imageId);

        moreInfoBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // make an explicit intent and a bundle
                Intent intent = new Intent(FoodActivity.this, DetailsActivity.class);
                Bundle bundle = new Bundle();

                // put the data into the bundle and the bundle into te intent
                bundle.putSerializable("food", food);
                intent.putExtras(bundle);

                // start activity
                startActivity(intent);

            }
        });


        backToHomeBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // make an explicit intent and a bundle
                Intent intent = new Intent(FoodActivity.this, MainActivity.class);
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









