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

public class Fall23 extends AppCompatActivity {
    Toolbar toolbar;
    ArrayList<Product> list = new ArrayList<Product>();
    GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fall23);
        list.add(new Product(R.drawable.grid_fall23_1,"Moonstone","590"));
        list.add(new Product(R.drawable.grid_fall23_2,"Lemon Meringue","520"));
        list.add(new Product(R.drawable.grid_fall23_3,"Blush Bliss","700"));
        list.add(new Product(R.drawable.grid_fall23_4,"Pink Bloom","750"));
        toolbar = (Toolbar) findViewById(R.id.toolbar_grid);
        gv = findViewById(R.id.gridview);
        GV_Adapter adapter = new GV_Adapter(this,list);
        gv.setAdapter(adapter);
        toolbar.setTitle("Fall Collection '23");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}