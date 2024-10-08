package com.example.epidemicsimulator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button mStartButton;
    private Button mRankButton;
    private Button mSetButton;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_menu,container,false);

        // Start Button
        mStartButton=(Button)v.findViewById(R.id.start_button);
        mStartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getActivity(),RegisterActivity.class);
                startActivity(intent1);
            }});

        // Rank Button
        mRankButton=(Button)v.findViewById(R.id.rank_button);
        mRankButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                FragmentManager fm=getActivity().getSupportFragmentManager();
//                Fragment fragment=new RankFragment();
//                FragmentTransaction transaction=fm.beginTransaction();
//                transaction.replace(R.id.fragment_container1,fragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
                Intent intent1=new Intent(getActivity(),AddRanksActivity.class);
                startActivity(intent1);
            }});

        // Set Button
        mSetButton=(Button)v.findViewById(R.id.set_button);
        mSetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent2=new Intent(getActivity(),SettingsActivity.class);
                startActivity(intent2);

            }});


        return v;
    }
}