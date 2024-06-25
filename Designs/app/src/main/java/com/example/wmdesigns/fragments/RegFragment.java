package com.example.wmdesigns.fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wmdesigns.DataBase;

import com.example.wmdesigns.REF;
import com.uos.designs.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegFragment extends Fragment implements REF {

    EditText user;
    EditText e_mail;
    EditText regpass;
    Button registerButton;

    private boolean validateInputs(String username, String password) {
        return !TextUtils.isEmpty(username) && !TextUtils.isEmpty(password);
    }


    private void saveUserToDatabase(String username, String password) {
        DataBase dbHelper = new DataBase(requireContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataBase.COLUMN_USERNAME, username);
        values.put(DataBase.COLUMN_PASSWORD, password);

        long newRowId = db.insert(DataBase.TABLE_USERS, null, values);

        // Handle the result of the insertion, e.g., show a Toast
        if (newRowId != -1) {
            Toast.makeText(requireContext(), "Registration successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(requireContext(), "Registration failed", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegFragment newInstance(String param1, String param2) {
        RegFragment fragment = new RegFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reg, container, false);

        user = view.findViewById(R.id.Username);
        regpass = view.findViewById(R.id.Pass);
        registerButton = view.findViewById(R.id.btnReg);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input
                String username = user.getText().toString();
                String password = regpass.getText().toString();

                // Validate and save user to the database
                if (validateInputs(username, password)) {
                    saveUserToDatabase(username, password);

                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView3, new LogFragment(), null)
                            .setReorderingAllowed(true)
                            .addToBackStack("tag")
                            .commit();
                }

            }
        });
        return view;
    }
}