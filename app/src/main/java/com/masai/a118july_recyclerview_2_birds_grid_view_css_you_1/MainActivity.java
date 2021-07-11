package com.masai.a118july_recyclerview_2_birds_grid_view_css_you_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private ArrayList<Menu> menuList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvRecyclerView);
        buildRecyclerviewData();
        setRecyclerViewAdapter();
        initViews();
    }

    private void setRecyclerViewAdapter() {
        MenuAdapter menuAdapter = new MenuAdapter(menuList, this);
        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL); //this or MainActivity.this
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(menuAdapter);
    }

    private void buildRecyclerviewData() {
        menuList = new ArrayList<>();

       for(int i = 0; i < 100; i++) {
           if (i % 4 == 0) {
               Menu menu = new Menu(R.drawable.eagle2, "Eagle");
               menuList.add(menu);
           } else if (i % 4 == 1) {
               Menu menu = new Menu(R.drawable.crow2, "Crow");
               menuList.add(menu);
           } else if (i % 4 == 2) {
               Menu menu = new Menu(R.drawable.columbdia1,"Columdial");
               menuList.add(menu);
           } else {
               Menu menu = new Menu(R.drawable.hummigbird2,"Humming Bird");
               menuList.add(menu);
           }
       }
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rvRecyclerView);
    }

    @Override
    public void onItemClicked(Menu menu, int position) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Hey this is")
                .setMessage(
                        menu.getName()
                ).
                        setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        show();
    }
}