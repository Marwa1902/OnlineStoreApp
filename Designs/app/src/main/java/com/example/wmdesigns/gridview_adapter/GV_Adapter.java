package com.example.wmdesigns.gridview_adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentTransaction;

import com.example.wmdesigns.fragments.OrderFragment;
import com.example.wmdesigns.gridview_data.Product;
import com.uos.designs.R;

import java.util.ArrayList;
import java.util.List;

public class GV_Adapter extends BaseAdapter {
    Context context;
    List<Product> objects = new ArrayList<Product>();
    public GV_Adapter(Context context, List<Product> objects) {
        this.context = context;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.gridview_item,parent,false);
        }
        else
            view = convertView;

        Product p = objects.get(position);
        ImageView iv = view.findViewById(R.id.imageview);
        TextView p_name = view.findViewById(R.id.nameTextView);
        TextView p_price = view.findViewById(R.id.priceTextView);

        iv.setImageResource(p.getImageID());
        p_name.setText("Name: "+p.getItem_name());
        p_price.setText("Price: "+p.getItem_price()+" AED");

        return view;
    }
}
