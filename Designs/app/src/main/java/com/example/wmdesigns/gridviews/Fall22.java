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

public class Fall22 extends AppCompatActivity {

    Toolbar toolbar;
    ArrayList<Product> list = new ArrayList<Product>();
    GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fall22);
        list.add(new Product(R.drawable.grid_fall22_1,"Layered Bisht Cut Abaya","380"));
        list.add(new Product(R.drawable.grid_fall22_2,"Light Sky","600"));
        list.add(new Product(R.drawable.grid_fall22_3,"Luna","530"));
        list.add(new Product(R.drawable.grid_fall22_4,"Sahara","700"));
        list.add(new Product(R.drawable.grid_fall22_5,"Amber","450"));
        list.add(new Product(R.drawable.grid_fall22_6,"Ombre","430"));
        toolbar = (Toolbar) findViewById(R.id.toolbar_grid);
        gv = findViewById(R.id.gridview);
        GV_Adapter adapter = new GV_Adapter(this,list);
        gv.setAdapter(adapter);
        toolbar.setTitle("Fall Collection '22");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}