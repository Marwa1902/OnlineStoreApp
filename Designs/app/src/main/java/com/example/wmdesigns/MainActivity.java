package com.example.wmdesigns;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wmdesigns.fragments.LogFragment;
import com.example.wmdesigns.fragments.RegFragment;
import com.uos.designs.R;

public class MainActivity extends AppCompatActivity {

    private String[] fashionQuotes = {
            "Fashion is about dressing according to what’s fashionable. Style is more about being yourself.",
            "Elegance is the only beauty that never fades.",
            "Fashion is an instant language.",
            // Add more quotes as needed
    };

    Button buttonLogin, buttonReg;
    private DataBase db;
    private SQLiteDatabase sql_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button lButton = findViewById(R.id.btLog);
        Button rButton = findViewById(R.id.btReg);

        lButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView3, new LogFragment())  // Instantiate the fragment
                        .setReorderingAllowed(true)
                        .addToBackStack("tagForNewFrag")
                        .commit();
            }
        });

        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView3, new RegFragment())  // Instantiate the fragment
                        .setReorderingAllowed(true)
                        .addToBackStack("tagForNewFrag")
                        .commit();
            }
        });
    }
}