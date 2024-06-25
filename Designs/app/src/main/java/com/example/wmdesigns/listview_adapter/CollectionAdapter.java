package com.example.wmdesigns.listview_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.wmdesigns.listview_data.WMCollection;
import com.uos.designs.R;

import java.util.ArrayList;
import java.util.List;

public class CollectionAdapter extends ArrayAdapter<WMCollection> {
    Context context;
    List<WMCollection> objects = new ArrayList<WMCollection>();

    public CollectionAdapter(@NonNull Context context, int resource, @NonNull List<WMCollection> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_item,parent,false);
        }
        else
            view = convertView;

        WMCollection c = objects.get(position);
        ImageView iv = view.findViewById(R.id.imgview);
        TextView txt = view.findViewById(R.id.txtview);
        iv.setImageResource(c.getImageID());
        txt.setText(c.getTitle());
        return view;
    }
}
