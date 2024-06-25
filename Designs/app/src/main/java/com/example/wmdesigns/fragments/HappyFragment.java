package com.example.wmdesigns.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.uos.designs.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HappyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HappyFragment extends Fragment {

    private Button insta, w;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HappyFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HappyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HappyFragment newInstance(String param1, String param2) {
        HappyFragment fragment = new HappyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_happy, container, false);


        insta = view.findViewById(R.id.Insta);
        w = view.findViewById(R.id.Whats);

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInsta();
            }
        });

        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendWhats();
            }
        });

        return view;
    }
    private void sendInsta() {
        String instaLink = "https://www.instagram.com/wmdesigns.ae/";



        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(instaLink));
        startActivity(intent);
    }

    private void sendWhats() {
        String whatsLink = "https://wa.me/message/KITQWWIHA7VPL1";

        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse(whatsLink));
        startActivity(intent);
    }
}