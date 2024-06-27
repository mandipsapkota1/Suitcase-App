package com.example.suitcase.Adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suitcase.ItemsModel;
import com.example.suitcase.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Items_Adapter extends RecyclerView.Adapter<Items_Adapter.ItemViewHolder> {
    private final RecyclerViewItemClick recyclerViewItemClick;
    private ArrayList<ItemsModel>itemsModels;

    public Items_Adapter(RecyclerViewItemClick recyclerViewItemClick) {
        this.recyclerViewItemClick = recyclerViewItemClick;
    }

    @NonNull
    @Override
    public Items_Adapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Items_Adapter.ItemViewHolder holder, int position) {
        ItemsModel itemsModel=itemsModels.get(position);

    }

    @Override
    public int getItemCount() {
        return itemsModels.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txt_name,txt_price,txt_Description;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_image);
            txt_name=itemView.findViewById(R.id.itemName);
            txt_price=itemView.findViewById(R.id.itemPrice);
            txt_Description=itemView.findViewById(R.id.itemDescription);
            itemView.setOnClickListener(this::itemViewOnClick);
        }

        private void itemViewOnClick(View view) {
            recyclerViewItemClick.onItemClick(view,getAdapterPosition());
        }
    }
}
