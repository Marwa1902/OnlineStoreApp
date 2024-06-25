package com.example.wmdesigns.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.wmdesigns.gridviews.Fall22;
import com.example.wmdesigns.gridviews.Fall23;
import com.example.wmdesigns.gridviews.Spring23;
import com.example.wmdesigns.gridviews.Summer22;
import com.example.wmdesigns.gridviews.Summer23;
import com.example.wmdesigns.listview_adapter.CollectionAdapter;
import com.example.wmdesigns.listview_data.WMCollection;
import com.uos.designs.R;

import java.util.ArrayList;


public class LookbookFragment extends Fragment {

    CollectionAdapter adapter;
    ArrayList<WMCollection> collection_list = new ArrayList<WMCollection>();
    ListView lv;

    public LookbookFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        collection_list.add(new WMCollection(R.drawable.lv_summer22,"Summer '22"));
        collection_list.add(new WMCollection(R.drawable.lv_fall22,"Fall Collection '22"));
        collection_list.add(new WMCollection(R.drawable.lv_spring23,"Spring Collection '23"));
        collection_list.add(new WMCollection(R.drawable.lv_summer23,"Summer '23"));
        collection_list.add(new WMCollection(R.drawable.lv_fall23,"Fall Collection '23"));
        adapter = new CollectionAdapter(getContext(),R.layout.listview_item,collection_list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toolbar tb = requireActivity().findViewById(R.id.toolbar);
        tb.setTitle("Lookbook");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lookbook, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv = view.findViewById(R.id.listview);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==0){
                    startActivity(new Intent(getActivity(),Summer22.class));
                }else if(position ==1){
                    startActivity(new Intent(getActivity(),Fall22.class));
                }else if(position ==2){
                    startActivity(new Intent(getActivity(),Spring23.class));
                }else if(position ==3){
                    startActivity(new Intent(getActivity(),Summer23.class));
                }else{
                    startActivity(new Intent(getActivity(),Fall23.class));
                }
            }
        });
    }
}