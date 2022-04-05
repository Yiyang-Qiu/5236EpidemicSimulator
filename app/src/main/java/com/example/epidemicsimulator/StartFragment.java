package com.example.epidemicsimulator;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class StartFragment extends Fragment {
    private Player mPlayer;
    int count;
    final int COUNT=3;   // items can be taken at start

    Button mFoodButton, mDrinkButton, mWeaponButton, mMedicineButton, mToyButton;
    TextView text;
    String tempText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_start, container, false);
        mPlayer=Player.get(getActivity());  // can be used to get player's health, items, etc...
        //retrieve username
        String username=(String)getActivity().getIntent().getStringExtra("USERNAME");
        mPlayer.setUsername(username);
        count=COUNT;
        text = (TextView)v.findViewById(R.id.count);
        tempText=text.getText().toString();  // Here is the original text in the textview
        text.setText(ReplaceCharInString.replace(tempText,Integer.toString(count)));
        // Food Button
        mFoodButton=(Button)v.findViewById(R.id.food_button);
        mFoodButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                count--;
                mPlayer.setFood(mPlayer.getFood()+1);
                checkCount();
            }});

        // Drink Button
        mDrinkButton=(Button)v.findViewById(R.id.drink_button);
        mDrinkButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                count--;
                mPlayer.setDrink(mPlayer.getDrink()+1);
                checkCount();
            }});

        // Toy Button
        mToyButton=(Button)v.findViewById(R.id.toy_button);
        mToyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                count--;
                mPlayer.setToy(mPlayer.getToy()+1);
                checkCount();
            }});

        // Weapon Button
        mWeaponButton=(Button)v.findViewById(R.id.weapon_button);
        mWeaponButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                count--;
                mPlayer.setWeapon(mPlayer.getWeapon()+1);
                checkCount();
            }});

        // Drink Button
        mMedicineButton=(Button)v.findViewById(R.id.medicine_button);
        mMedicineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                count--;
                mPlayer.setMedicine(mPlayer.getMedicine()+1);
                checkCount();
            }});


        return v;
    }

    private void checkCount(){
        if(count==0){
            FragmentManager fm=getActivity().getSupportFragmentManager();
            Fragment fragment=new GameFragment();
            FragmentTransaction transaction=fm.beginTransaction();
            transaction.replace(R.id.fragment_container,fragment);
            transaction.addToBackStack(null);
            transaction.commit();
            Toast.makeText(getActivity(),"Run out of chances!",Toast.LENGTH_SHORT).show();
        }
        text.setText(ReplaceCharInString.replace(tempText,Integer.toString(count)));
    }
}