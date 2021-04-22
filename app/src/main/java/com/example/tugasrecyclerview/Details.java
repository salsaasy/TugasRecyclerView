package com.example.tugasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    ImageView ivFoodPhoto;
    TextView tvFoodName;
    TextView tvFoodDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        
        ivFoodPhoto = findViewById(R.id.iv_detail_photo);
        tvFoodName = findViewById(R.id.tv_detail_name);
        tvFoodDesc = findViewById(R.id.tv_detail_desc);

        ivFoodPhoto.setImageResource(getIntent().getIntExtra("foto", 0));
        tvFoodName.setText(getIntent().getStringExtra("makanan"));
        tvFoodDesc.setText(getIntent().getStringExtra("deskripsi"));
    }

    public void backToMain(View view) {
        Intent i = new Intent(Details.this, MainActivity.class);
        startActivity(i);
    }
}