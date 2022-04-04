package com.example.epidemicsimulator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class GameFragment extends Fragment {
    private Player mPlayer;
    Button mFoodButton, mDrinkButton, mWeaponButton, mMedicineButton, mToyButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_game, container, false);
        mPlayer= Player.get(getActivity());

        mFoodButton = (Button) v.findViewById(R.id.food_button);
        mFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"number is "+mPlayer.getFood(),Toast.LENGTH_SHORT).show();
            }
        });

        mDrinkButton = (Button) v.findViewById(R.id.drink_button);
        mDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"number is "+mPlayer.getDrink(),Toast.LENGTH_SHORT).show();
            }
        });

        mWeaponButton = (Button) v.findViewById(R.id.weapon_button);
        mWeaponButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"number is "+mPlayer.getWeapon(),Toast.LENGTH_SHORT).show();
            }
        });

        mToyButton = (Button) v.findViewById(R.id.toy_button);
        mToyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"number is "+mPlayer.getToy(),Toast.LENGTH_SHORT).show();
            }
        });

        mMedicineButton = (Button) v.findViewById(R.id.medicine_button);
        mMedicineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"number is "+mPlayer.getMedicine(),Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

}
