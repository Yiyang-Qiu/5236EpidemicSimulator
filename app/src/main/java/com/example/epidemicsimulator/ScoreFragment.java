package com.example.epidemicsimulator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

public class ScoreFragment extends Fragment {
    // Game over (win or lose). Calculate the score. Win: Congras || Lose: Play ending.
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_score, container, false);
        // retrieve day
        int mDay = getActivity().getIntent().getIntExtra("DAY",0);
        Player mPlayer=Player.get(getActivity());
        Toast.makeText(getActivity(),Integer.toString(mPlayer.getMHealth()),Toast.LENGTH_SHORT).show();
        return v;
    }
}
