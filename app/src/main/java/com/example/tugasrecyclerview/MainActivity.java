package com.example.tugasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewFood;
    private List<FoodModel> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewFood = findViewById(R.id.rv_food);
        recyclerViewFood.setHasFixedSize(true);
        models.addAll(FoodDatabase.getListData());
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this));
        FoodAdapter adapter = new FoodAdapter(models);
        recyclerViewFood.setAdapter(adapter);
    }

}