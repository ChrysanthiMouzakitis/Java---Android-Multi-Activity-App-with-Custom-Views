package com.example.customrecyclerlist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements RecycleViewInterface{

    RecyclerView list = null;
    ImageRecyclerAdapter adapter = null;
    //Buildings buildings = null;

    String [] foods = null;

    String [] subtitles = null;
    int    [] imageIds  = null;
    XMLFood data = null;

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

        list = findViewById(R.id.recyclerView);

        // get the data from model
        data = new XMLFood(this);
        foods = data.getNames();
        subtitles = data.getSubtitles();
        imageIds = data.getImageIds();
        //foods = new foods();
        adapter = new ImageRecyclerAdapter(getApplicationContext(), R.layout.row_layout, foods, subtitles, imageIds,this);

        list.setLayoutManager(new GridLayoutManager(this,2));
        list.setAdapter(adapter);


    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,"selected "+foods[position], Toast.LENGTH_SHORT).show();

        // make intent and bundle
        Intent intent = new Intent(MainActivity.this, FoodActivity.class);
        Bundle bundle = new Bundle();

        // crop the data for the intent
        //Building building = foods.getFood(position);

        // place data into bundle and bundle into intent
        bundle.putSerializable("food", data.getFood(position));
        intent.putExtras(bundle);

        // start activity
        startActivity(intent);
    }
}