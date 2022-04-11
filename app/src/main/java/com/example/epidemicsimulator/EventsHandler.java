package com.example.epidemicsimulator;

import android.app.Activity;
import android.app.Dialog;
import android.view.WindowManager;
import android.widget.TextView;

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
        int layoutResId;
        switch (eventID){
            case 1: layoutResId = R.layout.dialog_event1;
            mEventTitle=(TextView)activity.findViewById(R.id.event_title);
            mEventDescription=(TextView)activity.findViewById(R.id.event_descrip);
            mPlayer.getFood();
            // To Do: ...
                break;

        }
        dialog.setContentView(R.layout.dialog_item_use);
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
