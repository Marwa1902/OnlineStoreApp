package com.example.wmdesigns.gridviews;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import com.example.wmdesigns.fragments.OrderFragment;
import com.example.wmdesigns.gridview_adapter.GV_Adapter;
import com.example.wmdesigns.gridview_data.Product;
import com.uos.designs.R;

import java.util.ArrayList;

public class Summer23 extends AppCompatActivity {

    Toolbar toolbar;
    ArrayList<Product> list = new ArrayList<Product>();
    GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer23);
        list.add(new Product(R.drawable.grid_summer23_1, "Ivory", "540"));
        list.add(new Product(R.drawable.grid_summer23_2, "Lily", "480"));
        list.add(new Product(R.drawable.grid_summer23_3, "Mocha Charm", "620"));
        list.add(new Product(R.drawable.grid_summer23_4, "Pleated Blue", "480"));
        toolbar = (Toolbar) findViewById(R.id.toolbar_grid);
        gv = findViewById(R.id.gridview);
        GV_Adapter adapter = new GV_Adapter(this, list);
        gv.setAdapter(adapter);
        toolbar.setTitle("Summer Collection '23");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });
    }
}