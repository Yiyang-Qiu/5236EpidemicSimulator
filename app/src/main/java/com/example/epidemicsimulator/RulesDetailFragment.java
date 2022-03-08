package com.example.epidemicsimulator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RulesDetailFragment extends Fragment {
    static final String TAG = "fragment_rules_detail";
    private Button mBackButton;
    public RulesDetailFragment() {
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
        View v =  inflater.inflate(R.layout.fragment_rules_detail, container, false);



        mBackButton=(Button)v.findViewById(R.id.back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RulesActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new SettingsOptionsFragment(),null).addToBackStack(null).commit();
            }
        });


        return v;
    }
}