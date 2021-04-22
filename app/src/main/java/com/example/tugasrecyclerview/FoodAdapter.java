package com.example.tugasrecyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{
    private List<FoodModel> models;

    public FoodAdapter(List<FoodModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {
        FoodModel model = models.get(position);
        holder.ivFoodPhoto.setBackgroundResource(model.getPhoto());
        holder.tvFoodName.setText(model.getName());
        holder.tvFoodDesc.setText(model.getDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(holder.itemView.getContext(),Details.class);
                i.putExtra("foto", model.getPhoto());
                i.putExtra("makanan", model.getName());
                i.putExtra("deskripsi", model.getDesc());
                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivFoodPhoto;
        TextView tvFoodName;
        TextView tvFoodDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoodPhoto = itemView.findViewById(R.id.iv_food_photo);
            tvFoodName = itemView.findViewById(R.id.tv_food_name);
            tvFoodDesc = itemView.findViewById(R.id.tv_food_desc);
        }
    }
}
