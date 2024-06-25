package com.example.wmdesigns.gridviews;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import com.example.wmdesigns.gridview_adapter.GV_Adapter;
import com.example.wmdesigns.gridview_data.Product;
import com.uos.designs.R;

import java.util.ArrayList;

public class Summer22 extends AppCompatActivity {

    Toolbar toolbar;
    ArrayList<Product> list = new ArrayList<Product>();
    GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer22);
        list.add(new Product(R.drawable.grid_summer22_1,"The Golden Kaftan","250"));
        list.add(new Product(R.drawable.grid_summer22_2,"Ava Dress Green","475"));
        list.add(new Product(R.drawable.grid_summer22_3,"Ava Dress Yellow","475"));
        list.add(new Product(R.drawable.grid_summer22_4,"Azalea Kaftan","675"));
        list.add(new Product(R.drawable.grid_summer22_5,"Navy Royalty Kaftan","650"));
        toolbar = (Toolbar) findViewById(R.id.toolbar_grid);
        gv = findViewById(R.id.gridview);
        GV_Adapter adapter = new GV_Adapter(this,list);
        gv.setAdapter(adapter);
        toolbar.setTitle("Summer Collection '22");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        }
}