package com.masai.a118july_recyclerview_2_birds_grid_view_css_you_1;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    private ArrayList<Menu> menuList; //Global object declared
    private ItemClickListener itemClickListener;

    public MenuAdapter(ArrayList<Menu> menuList,
                       ItemClickListener itemClickListener) {
        this.menuList = menuList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("Lloyd", "onCreate View holder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MenuViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Log.d("Lloyd", "onBind View holder");

        Menu menu = menuList.get(position);
        holder.setData(menu);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
}
