package com.masai.a118july_recyclerview_2_birds_grid_view_css_you_1;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView Eagle;
    private RelativeLayout relativeLayout;
    private ItemClickListener itemClickListener;

    public MenuViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        imageView = itemView.findViewById(R.id.ivItem);
        Eagle = itemView.findViewById(R.id.tvName);
        relativeLayout = itemView.findViewById(R.id.relativeLayout);
    }

    //setting of data here
    public void setData(Menu menu) {
        imageView.setImageResource(menu.getImage());
        Eagle.setText(menu.getName());

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(menu, getAdapterPosition());
            }
        });
    }
}
