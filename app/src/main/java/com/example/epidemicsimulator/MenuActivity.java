package com.example.epidemicsimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        FragmentManager fm= getSupportFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.fragment_container1);
        if(fragment==null){
            fragment=new MenuFragment();
            fm.beginTransaction().add(R.id.fragment_container1,fragment).commit();
        }
    }
}