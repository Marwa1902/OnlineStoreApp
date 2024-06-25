package com.example.wmdesigns.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wmdesigns.DataBase;
import com.example.wmdesigns.NavigationActivity;
import com.uos.designs.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogFragment extends Fragment {

    //the animated button
    Button Log_btn;
    EditText loguser, logpass;
    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle savedInstanceState;
    private DataBase databaseHelper;


    public boolean VerifyUser(String username, String password) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String[] data = {
                DataBase.COLUMN_ID,
                DataBase.COLUMN_USERNAME,
                DataBase.COLUMN_PASSWORD
        };

        String selection = DataBase.COLUMN_USERNAME + " = ? AND " + DataBase.COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};

        Cursor c = db.query(
                DataBase.TABLE_USERS,
                data,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        boolean verify = c.getCount() > 0;

        c.close();
        db.close();

        return verify;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LogFragment newInstance(String param1, String param2) {
        LogFragment fragment = new LogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new DataBase(requireContext());
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log, container, false);

        Log_btn = view.findViewById(R.id.buttonLogin);
        loguser = view.findViewById(R.id.editTextUsername);
        logpass = view.findViewById(R.id.editTextPassword);

        Log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check the entered username and password
                String user = loguser.getText().toString();
                String pass = logpass.getText().toString();

                // Now verify the user
                if (VerifyUser(user, pass)) {
                    // Login successful
                    Toast.makeText(requireContext(), "Login successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(requireContext(), NavigationActivity.class);
                    startActivity(intent);
                } else {
                    // Login failed
                    Toast.makeText(requireContext(), "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}