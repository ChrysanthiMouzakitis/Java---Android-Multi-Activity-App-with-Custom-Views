package com.example.customrecyclerlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageRecyclerAdapter.ViewHolder> {
    Context context;
    int layout;
    String [] foods;

    String [] subtitles;
    int [] imageIds;
    RecycleViewInterface recyclerViewInterface;

    public ImageRecyclerAdapter(Context context, int layout, String [] foods, String [] subtitles, int [] imageIds, RecycleViewInterface recyclerViewInterface){
        this.context = context;
        this.layout = layout;
        this.foods = foods;
        this.subtitles = subtitles;
        this.imageIds = imageIds;
        this.recyclerViewInterface = recyclerViewInterface;


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.label.setText(this.foods[position]);
        holder.icon.setImageResource(this.imageIds[position]);
        holder.subtitle.setText(this.subtitles[position]);


    }

    @Override
    public int getItemCount() {
        return this.foods.length;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the layout and return a viewholder
        View view = LayoutInflater.from(this.context).inflate(this.layout, parent, false);

        return new ImageRecyclerAdapter.ViewHolder(view, this.recyclerViewInterface);
    }

    // view holder inner class
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView label;

        TextView subtitle;
        ImageView icon;

        public ViewHolder(View item, RecycleViewInterface recyclerViewInterface){
            super(item);

            this.label = item.findViewById(R.id.textView);
            this.icon = item.findViewById(R.id.imageView);
            this.subtitle = item.findViewById(R.id.textViewSmall);

            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    recyclerViewInterface.onItemClick(position);
                }
            });

        }
    }
}
