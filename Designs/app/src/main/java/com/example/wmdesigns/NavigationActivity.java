package com.example.wmdesigns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.wmdesigns.fragments.AboutUsFragment;
import com.example.wmdesigns.fragments.ContactUsFragment;
import com.example.wmdesigns.fragments.LookbookFragment;
import com.example.wmdesigns.fragments.OrderFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.uos.designs.R;

public class NavigationActivity extends AppCompatActivity {

    private BottomNavigationView bnv;
    private FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        bnv = findViewById(R.id.bottomnav);
        fl = findViewById(R.id.framelayout);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemID = item.getItemId();

                if(itemID == R.id.navAboutUs){
                    loadFragment(new AboutUsFragment(),false);
                }
                else if(itemID == R.id.navLookbook){
                    loadFragment(new LookbookFragment(),false);
                }
                else if (itemID == R.id.navOrder){
                    loadFragment(new OrderFragment(),false);
                }
                else // itemID == R.id.navContactUs
                {
                    loadFragment(new ContactUsFragment(),false);
                }
                return true;
            }
        });

        loadFragment(new AboutUsFragment(),true);
    }
    private void loadFragment(Fragment fragment, boolean isAppInitialized){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(isAppInitialized){
            ft.add(R.id.framelayout,fragment); }
        else {
            ft.replace(R.id.framelayout, fragment);
        }
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.logout)
            this.finish();
        return true;
    }
}