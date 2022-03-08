package com.example.epidemicsimulator;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SettingsOptionsFragment extends Fragment {

    private Button mRulesButton;


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


        return v;
    }
}