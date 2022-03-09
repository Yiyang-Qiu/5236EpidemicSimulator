package com.example.epidemicsimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class QuitActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quit);

        fragmentManager = getSupportFragmentManager();

        FragmentManager fm= getSupportFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.fragment_container5);
        if(fragment==null){
            fragment=new QuitDetailFragment();
            fm.beginTransaction().add(R.id.fragment_container5,fragment).commit();
        }
    }
}