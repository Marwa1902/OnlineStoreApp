package com.example.wmdesigns.gridviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.wmdesigns.gridview_adapter.GV_Adapter;
import com.example.wmdesigns.gridview_data.Product;
import com.uos.designs.R;

import java.util.ArrayList;

public class Spring23 extends AppCompatActivity {

    Toolbar toolbar;
    ArrayList<Product> list = new ArrayList<Product>();
    GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring23);
        list.add(new Product(R.drawable.grid_spring23_1,"Sand Tropez","590"));
        list.add(new Product(R.drawable.grid_spring23_2,"Crystal Rain","590"));
        list.add(new Product(R.drawable.grid_spring23_3,"Silverstone","600"));
        list.add(new Product(R.drawable.grid_spring23_4,"Glimmer","640"));
        list.add(new Product(R.drawable.grid_spring23_5,"Golden Pearl","800"));
        toolbar = (Toolbar) findViewById(R.id.toolbar_grid);
        gv = findViewById(R.id.gridview);
        GV_Adapter adapter = new GV_Adapter(this,list);
        gv.setAdapter(adapter);
        toolbar.setTitle("Spring Collection '23");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}