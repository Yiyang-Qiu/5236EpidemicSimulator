package com.example.epidemicsimulator;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class GameFragment extends Fragment {
    private Player mPlayer;
    Button mFoodButton, mDrinkButton, mWeaponButton, mMedicineButton, mToyButton, mExploreButton, mEndButton;
    TextView mDayText;
    int buttonFlag; // Detect which button is clicked: 1-food, 2-drink, 3-medicine, 4-toy, 5-weapon
    int mDay;
    String tempString;  // Use to store original text

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_game, container, false);
        mPlayer= Player.get(getActivity());
        mDay=1; // Initialize. Begin from day 1

        mDayText = (TextView)v.findViewById(R.id.day_text);
        tempString= mDayText.getText().toString();  // Retrieve the template string (Use to recover)
        mDayText.setText(ReplaceCharInString.replace(tempString,Integer.toString(mDay))); //replace Day text

        mFoodButton = (Button) v.findViewById(R.id.food_button);
        mFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"number is "+mPlayer.getFood(),Toast.LENGTH_SHORT).show();
                buttonFlag=1;
                createDialog(buttonFlag);
            }
        });

        mDrinkButton = (Button) v.findViewById(R.id.drink_button);
        mDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"number is "+mPlayer.getDrink(),Toast.LENGTH_SHORT).show();
                buttonFlag=2;
                createDialog(buttonFlag);
            }
        });

        mWeaponButton = (Button) v.findViewById(R.id.weapon_button);
        mWeaponButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"number is "+mPlayer.getWeapon(),Toast.LENGTH_SHORT).show();
                buttonFlag=5;
                createDialog(buttonFlag);
            }
        });

        mToyButton = (Button) v.findViewById(R.id.toy_button);
        mToyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"number is "+mPlayer.getToy(),Toast.LENGTH_SHORT).show();
                buttonFlag=4;
                createDialog(buttonFlag);
            }
        });

        mMedicineButton = (Button) v.findViewById(R.id.medicine_button);
        mMedicineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"number is "+mPlayer.getMedicine(),Toast.LENGTH_SHORT).show();
                buttonFlag=3;
                createDialog(buttonFlag);
            }
        });

        mExploreButton=(Button) v.findViewById(R.id.explore_button);
        mExploreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // To Do: add explore functions
            }
        });

        mEndButton = (Button) v.findViewById(R.id.end_button);
        mEndButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                endDay();
            }
        });

        return v;
    }

    private void endDay(){
        mDay++;
        mDayText.setText(ReplaceCharInString.replace(tempString,Integer.toString(mDay))); //replace Day text

        // Daily Decrease
        mPlayer.setPHealth(mPlayer.getPHealth()-10);
        mPlayer.setMHealth(mPlayer.getMHealth()-10);

        if(mDay==14 || mPlayer.getMHealth()==0 || mPlayer.getPHealth()==0){
            gameOver();
        }
//        if(mDay==4 || mDay==7 || mDay==12){
//            EventsHandler.pickEvent(mPlayer,getActivity()); //Events will occur at these days
//        }
    }

    // Player survives the game
    private void gameOver(){
        Intent intent1=new Intent(getActivity(),ScoreActivity.class);
        intent1.putExtra("DAY",mDay);
        startActivity(intent1);
    }

    private void createDialog(int buttonFlag){
        //create dialog
        Dialog dialog =  new Dialog(getContext());
        //set content view
        dialog.setContentView(R.layout.dialog_item_use);
        //initialize width
        int width = WindowManager.LayoutParams.MATCH_PARENT;
        //initialize height
        int height = WindowManager.LayoutParams.WRAP_CONTENT;
        //set layout
        dialog.getWindow().setLayout(width,height);
        //show dialog
        dialog.show();

        //Initialize and assign variables
        TextView mText = dialog.findViewById(R.id.item_number_text);
        Button mUseButton = dialog.findViewById(R.id.bt_use);
        Button mCancelButton = dialog.findViewById(R.id.bt_cancel);
        String tempString = mText.getText().toString();  // Here is the original text of textview
        int count=0;
        switch (buttonFlag){
            case 1: count=mPlayer.getFood();
                    break;
            case 2: count=mPlayer.getDrink();
                    break;
            case 3: count=mPlayer.getMedicine();
                    break;
            case 4: count=mPlayer.getToy();
                    break;
            case 5: count=mPlayer.getWeapon();
                    break;
        }

        mText.setText(ReplaceCharInString.replace(tempString,Integer.toString(count)));
        // Use button
        if(count==0) mUseButton.setEnabled(false);
        mUseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                switch (buttonFlag){
                    case 1: mPlayer.setFood(mPlayer.getFood()-1);break;
                    case 2: mPlayer.setDrink(mPlayer.getDrink()-1);break;
                    case 3: mPlayer.setMedicine(mPlayer.getMedicine()-1);break;
                    case 4: mPlayer.setToy(mPlayer.getToy()-1);break;
                    case 5: mPlayer.setWeapon(mPlayer.getWeapon()-1);break;
                }
                mText.setText(tempString); // recover to the template
                Toast.makeText(getActivity(),"Use Successfully",Toast.LENGTH_SHORT).show();
            }
        });

        // Cancel button
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(getActivity(),"Use nothing",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
