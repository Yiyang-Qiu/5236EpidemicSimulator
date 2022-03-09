package com.example.epidemicsimulator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class QuitDetailFragment extends Fragment {

    private Button mQuitButton;
    private Button mBackButton;


    public QuitDetailFragment() {
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
        View v = inflater.inflate(R.layout.fragment_quit_detail, container, false);

        mQuitButton=(Button)v.findViewById(R.id.quitDialog_button);
        mQuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getChildFragmentManager();
                QuitDetailAlertDialogFragment dialog = new QuitDetailAlertDialogFragment();
                dialog.show(manager,"QUIT_Dialog");
            }
        });

        mBackButton=(Button)v.findViewById(R.id.back3_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuitActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container5, new SettingsOptionsFragment(),null).addToBackStack(null).commit();
            }
        });



        return v;
    }
}