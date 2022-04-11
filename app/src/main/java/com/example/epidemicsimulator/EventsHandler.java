package com.example.epidemicsimulator;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class EventsHandler {

    // Randomly pick an event
    public static void pickEvent(Player mPlayer, Activity activity){
        RoomDB database = RoomDB.getInstance(activity);
        int eventNum=database.eventDao().getCount();
        Random random=new Random();
        EventData event = database.eventDao().getEvent(random.nextInt(eventNum)+1);  //randomly pick an event
        TextView mEventTitle, mEventDescription;

        int eventID=event.getID();

        //create dialog
        Dialog dialog =  new Dialog(activity);
        //set content view
        int layoutResId=0;
        switch (eventID){
            case 1:
                layoutResId = R.layout.dialog_event1;
    //            mEventTitle=(TextView)activity.findViewById(R.id.event_title);
    //            mEventDescription=(TextView)activity.findViewById(R.id.event_descrip);
                if(mPlayer.getFood()==0){
                    mPlayer.setFood(1);
                }
                else if(mPlayer.getDrink()==0){
                    mPlayer.setDrink(1);
                }
                else if(mPlayer.getFood()+mPlayer.getDrink()<4){
                    int flag=(mPlayer.getFood()<mPlayer.getDrink()?0:1);  //0: food<drink else 1
                    if(flag==0){
                        mPlayer.setFood(mPlayer.getFood()+1);
                    }else{
                        mPlayer.setDrink(mPlayer.getDrink()+1);
                    }
                }
                else{
                    mPlayer.setFood(0);
                    mPlayer.setDrink(0);
                }
                break;

            case 2:
                if(!mPlayer.isHasMask()){
                    mPlayer.setInfected(true);
                }
                layoutResId = R.layout.dialog_event2;
                Button mGiveButton = (Button) activity.findViewById(R.id.bt_give);
                mGiveButton.setEnabled(false);
                if(mPlayer.getMedicine()!=0){
                    mGiveButton.setEnabled(true);
                }
                mGiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(activity,"You hand out the medicine",Toast.LENGTH_SHORT).show();
                        mPlayer.setMedicine(mPlayer.getMedicine()-1);
                    }
                });
                Button mRefuseButton = (Button) activity.findViewById(R.id.bt_refuse);
                mRefuseButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // went back
                    }
                });
                break;

            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;


        }
        dialog.setContentView(layoutResId);
        //initialize width
        int width = WindowManager.LayoutParams.MATCH_PARENT;
        //initialize height
        int height = WindowManager.LayoutParams.WRAP_CONTENT;
        //set layout
        dialog.getWindow().setLayout(width,height);
        //show dialog
        dialog.show();



    }
}
