package com.example.epidemicsimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    public static FragmentManager fragmentManagersetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        fragmentManagersetting = getSupportFragmentManager();

        FragmentManager fm= getSupportFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.fragment_container2);
        if(fragment==null){
            fragment=new SettingsOptionsFragment();
            fm.beginTransaction().add(R.id.fragment_container2,fragment).commit();
        }
    }
}