package com.example.epidemicsimulator;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SettingsOptionsFragment extends Fragment {

    private Button mRulesButton;
    private Button mEventsButton;
    private Button mQuitButton;
    private Button mBackButton;


    public SettingsOptionsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_settings_options, container, false);

        // Rules Button
        mRulesButton=(Button)v.findViewById(R.id.rules_button);
        mRulesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(getActivity(),RulesActivity.class);
                startActivity(intent3);
            }});

        // Events Button
        mEventsButton=(Button)v.findViewById(R.id.events_button);
        mEventsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(getActivity(),EventsActivity.class);
                startActivity(intent4);
            }});

        // Quit Button
        mQuitButton=(Button)v.findViewById(R.id.quit_button);
        mQuitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent5=new Intent(getActivity(),QuitActivity.class);
                startActivity(intent5);
            }});

        // Back Button
        mBackButton=(Button)v.findViewById(R.id.backSetting_button);
        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent6=new Intent(getActivity(), MenuActivity.class);
                startActivity(intent6);

            }});



        return v;
    }
}